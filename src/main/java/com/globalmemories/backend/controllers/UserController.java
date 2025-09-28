package com.globalmemories.backend.controllers;


import com.globalmemories.backend.dtos.FollowRequestDto;
import com.globalmemories.backend.dtos.FollowRequestUserInfoDto;
import com.globalmemories.backend.dtos.UserAccountDto;
import com.globalmemories.backend.dtos.UserDto;
import com.globalmemories.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // Endpoint to update name and nationality
    @PatchMapping("/{id}/update-profile")
    public ResponseEntity<UserDto> updateUserProfile(
            @PathVariable Long id,
            @RequestBody @Valid UserDto userDto) {
        UserDto updatedUser = userService.updateUserProfile(id, userDto);
        return ResponseEntity.ok(updatedUser);
    }

    // Endpoint to update name and nationality
    @PatchMapping("/{id}/update-account")
    public ResponseEntity<?> updateUserAccount(
            @PathVariable Long id,
            @RequestBody @Valid UserAccountDto userAccountDto,
            BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
                // Create a map to hold field-specific error messages
            Map<String, String> errorMessages = new HashMap<>();

            // Loop through all errors and categorize them
            for (ObjectError error : bindingResult.getAllErrors()) {
                String field = ((FieldError) error).getField(); // Extract field name
                String message = error.getDefaultMessage();  // Get the error message

                // Add the error to the map
                errorMessages.put(field + "ErrorMessage", message);
            }

            return new ResponseEntity<>(errorMessages, HttpStatus.BAD_REQUEST);
        }

        UserDto updatedUser = userService.updateUserAccount(id, userAccountDto);
        return ResponseEntity.ok(updatedUser);
    }

    // 1. Follow or request to follow a user
    @PostMapping("/{id}/follow")
    public ResponseEntity<Void> followUser(@PathVariable Long id, @RequestParam Long requesterId) {
        userService.followUser(requesterId, id);
        return ResponseEntity.ok().build();
    }

    // 2. Get pending follow requests for a user (private profile)
    @GetMapping("/{id}/follow-requests")
    public ResponseEntity<List<FollowRequestUserInfoDto>> getFollowRequests(@PathVariable Long id) {
        List<FollowRequestUserInfoDto> requests = userService.getPendingFollowRequests(id);
        return ResponseEntity.ok(requests);
    }

    // 3. Accept a follow request
    @PostMapping("/{id}/follow-requests/{requestId}/accept")
    public ResponseEntity<Void> acceptFollowRequest(@PathVariable Long id, @PathVariable Long requestId) {
        userService.acceptFollowRequest(id, requestId);
        return ResponseEntity.ok().build();
    }

    // 4. Reject a follow request
    @PostMapping("/{id}/follow-requests/{requestId}/reject")
    public ResponseEntity<Void> rejectFollowRequest(@PathVariable Long id, @PathVariable Long requestId) {
        userService.rejectFollowRequest(id, requestId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/nr-follows")
    public ResponseEntity<Long> getNumberOfFollows(@RequestParam Long userId) {
        Long numFollows = userService.getNumberOfFollows(userId);
        return ResponseEntity.ok(numFollows);
    }

    @GetMapping("/nr-followers")
    public ResponseEntity<Long> getNumberOfFollowers(@RequestParam Long userId) {
        Long numFollowers = userService.getNumberOfFollowers(userId);
        return ResponseEntity.ok(numFollowers);
    }

    @GetMapping("/follows")
    public ResponseEntity<List<UserDto>> getFollows(@RequestParam Long userId) {
        List<UserDto> follows = userService.getFollows(userId);
        return ResponseEntity.ok(follows);
    }

    @GetMapping("/followers")
    public ResponseEntity<List<UserDto>> getFollowers(@RequestParam Long userId) {
        List<UserDto> followers = userService.getFollowers(userId);
        return ResponseEntity.ok(followers);
    }

}
