package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.SignUpDto;
import com.globalmemories.backend.dtos.UserDto;
import com.globalmemories.backend.entites.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-01-15T23:09:26+0000",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.v20241217-1506, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.birthDate( user.getBirthDate() );
        userDto.city( user.getCity() );
        userDto.email( user.getEmail() );
        userDto.firstName( user.getFirstName() );
        userDto.id( user.getId() );
        userDto.languagesSpoken( user.getLanguagesSpoken() );
        userDto.lastName( user.getLastName() );
        userDto.nationality( user.getNationality() );
        userDto.userBio( user.getUserBio() );
        userDto.username( user.getUsername() );

        return userDto.build();
    }

    @Override
    public User signUpToUser(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.email( signUpDto.getEmail() );
        user.firstName( signUpDto.getFirstName() );
        user.lastName( signUpDto.getLastName() );
        user.nationality( signUpDto.getNationality() );
        user.username( signUpDto.getUsername() );

        return user.build();
    }
}
