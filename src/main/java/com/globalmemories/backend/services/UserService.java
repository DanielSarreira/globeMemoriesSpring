package com.globalmemories.backend.services;

import com.globalmemories.backend.dtos.CredentialsDto;
import com.globalmemories.backend.dtos.FollowRequestUserInfoDto;
import com.globalmemories.backend.dtos.SignUpDto;
import com.globalmemories.backend.dtos.UserAccountDto;
import com.globalmemories.backend.dtos.UserDto;
import com.globalmemories.backend.entites.Follow;
import com.globalmemories.backend.entites.FollowRequest;
import com.globalmemories.backend.entites.User;
import com.globalmemories.backend.exceptions.AppException;
import com.globalmemories.backend.mappers.UserMapper;
import com.globalmemories.backend.repositories.FollowRepository;
import com.globalmemories.backend.repositories.FollowRequestRepository;
import com.globalmemories.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final FollowRepository followRepository;
    private final FollowRequestRepository followRequestRepository;

    private final PasswordEncoder passwordEncoder;

    private final UserMapper userMapper;

    public UserDto login(CredentialsDto credentialsDto) {
        User user = userRepository.findByUsername(credentialsDto.getUsername())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

        if (passwordEncoder.matches(CharBuffer.wrap(credentialsDto.getPassword()), user.getPassword())) {
            return userMapper.toUserDto(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);
    }

    public UserDto register(SignUpDto userDto) {
        Optional<User> optionalUser = userRepository.findByUsername(userDto.getUsername());

        if (optionalUser.isPresent()) {
            throw new AppException("Username already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userDto.getPassword())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);
    }

    public UserDto findByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDto(user);
    }

    public User getUserById(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new AppException("User not found with id: " + userId, HttpStatus.NOT_FOUND));
        return user;
    }

    public UserDto updateUserProfile(Long id, UserDto userDto){   
        try {
            User user = userRepository.findById(id)
            .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));

            user.setFirstName(userDto.getFirstName());
            user.setLastName(userDto.getLastName());
            user.setUserBio(userDto.getUserBio());
            user.setNationality(userDto.getNationality());
            user.setCity(userDto.getCity());
            user.setGender(userDto.getGender());
            user.setBirthDate(userDto.getBirthDate());
            user.setLanguagesSpoken(userDto.getLanguagesSpoken());
            
            userRepository.save(user);

            return userMapper.toUserDto(user);

        } catch (IllegalArgumentException e) {
            throw new AppException("Invalid user data provided: " + e.getMessage(), HttpStatus.BAD_REQUEST, e);
        } catch (DataIntegrityViolationException e) {
            throw new AppException("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST, e);
        } catch (Exception e) {
            throw new AppException("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    public UserDto updateUserAccount(Long id, UserAccountDto userAccountDto){   
        try {
            User user = userRepository.findById(id)
            .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
            // Check if the email is already used by another user
            if (userAccountDto.getEmail() != null && !userAccountDto.getEmail().equals(user.getEmail())) {
                if (userRepository.existsByEmail(userAccountDto.getEmail())) {
                    throw new AppException("Email is already in use by another account", HttpStatus.CONFLICT);
                }
                user.setEmail(userAccountDto.getEmail());
            }
            // Check if the username is already taken by another user
            if (userAccountDto.getUsername() != null && !userAccountDto.getUsername().equals(user.getUsername())) {
                if (userRepository.existsByUsername(userAccountDto.getUsername())) {
                    throw new AppException("Username is already taken", HttpStatus.CONFLICT);
                }
                user.setUsername(userAccountDto.getUsername());
            }
            // Hash password if provided
            if (userAccountDto.getPassword() != null) {
                user.setPassword(passwordEncoder.encode(CharBuffer.wrap(userAccountDto.getPassword())));
            }

            userRepository.save(user);
            return userMapper.toUserDto(user);

        } catch (IllegalArgumentException e) {
            throw new AppException("Invalid user data provided: " + e.getMessage(), HttpStatus.BAD_REQUEST, e);
        } catch (DataIntegrityViolationException e) {
            throw new AppException("Data integrity violation: " + e.getMessage(), HttpStatus.BAD_REQUEST, e);
        } catch (Exception e) {
            throw new AppException("An unexpected error occurred: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR, e);
        }
    }

    public void followUser(Long requesterId, Long targetId) {
        User requester = userRepository.findById(requesterId).orElseThrow();
        User target = userRepository.findById(targetId).orElseThrow();
        if (target.isPrivateProfile()) {
            if (!followRequestRepository.existsByRequesterIdAndTargetId(requesterId, targetId)) {
                followRequestRepository.save(FollowRequest.builder()
                    .requester(requester)
                    .target(target)
                    .accepted(false)
                    .build());
            }
        } else {
            if (!followRepository.existsByFollowerIdAndFollowedId(requesterId, targetId)) {
                followRepository.save(Follow.builder()
                    .follower(requester)
                    .followed(target)
                    .build());
            }
        }
    }

    public List<FollowRequestUserInfoDto> getPendingFollowRequests(Long userId) {
        List<FollowRequestUserInfoDto> pendentRequests = followRequestRepository.findByTargetIdAndAcceptedFalse(userId).stream()
            .map(fr -> FollowRequestUserInfoDto.builder()
                .id(fr.getId())
                .requester(userMapper.toUserDto(fr.getRequester()))
                .targetId(fr.getTarget().getId())
                .accepted(fr.isAccepted())
                .build())
            .toList();
        return pendentRequests;  
    }

    public void acceptFollowRequest(Long userId, Long requestId) {
        FollowRequest followRequest = followRequestRepository.findById(requestId)
            .orElseThrow(() -> new AppException("Follow request not found", HttpStatus.NOT_FOUND));
        if (!followRequest.getTarget().getId().equals(userId)) {
            throw new AppException("You are not authorized to accept this follow request", HttpStatus.FORBIDDEN);
        }
        followRequest.setAccepted(true);
        followRequestRepository.save(followRequest);
        followRepository.save(Follow.builder()
            .follower(followRequest.getRequester())
            .followed(followRequest.getTarget())
            .build());
        followRequestRepository.delete(followRequest);    
    }
    
    public void rejectFollowRequest(Long userId, Long requestId) {
        FollowRequest followRequest = followRequestRepository.findById(requestId)
            .orElseThrow(() -> new AppException("Follow request not found", HttpStatus.NOT_FOUND));
        if (!followRequest.getTarget().getId().equals(userId)) {
            throw new AppException("You are not authorized to reject this follow request", HttpStatus.FORBIDDEN);
        }
        followRequestRepository.delete(followRequest);    
    }

    public Long getNumberOfFollows(Long userId) {
        return followRepository.countByFollowerId(userId);
    }

    public Long getNumberOfFollowers(Long userId) {
        return followRepository.countByFollowedId(userId);
    }

    public List<UserDto> getFollows(Long userId) {
        List<User> follows = followRepository.findAll().stream()
            .filter(f -> f.getFollower().getId().equals(userId))
            .map(Follow::getFollowed)
            .toList();
        return userMapper.toDtoList(follows);
    }

    public List<UserDto> getFollowers(Long userId) {
        List<User> followers = followRepository.findAll().stream()
            .filter(f -> f.getFollowed().getId().equals(userId))
            .map(Follow::getFollower)
            .toList();
        return userMapper.toDtoList(followers);
    }
}


