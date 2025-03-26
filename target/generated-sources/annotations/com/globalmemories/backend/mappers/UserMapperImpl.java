package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.SignUpDto;
import com.globalmemories.backend.dtos.UserDto;
import com.globalmemories.backend.entites.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-26T00:13:54+0000",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.4 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toUserDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto.UserDtoBuilder userDto = UserDto.builder();

        userDto.id( user.getId() );
        userDto.firstName( user.getFirstName() );
        userDto.lastName( user.getLastName() );
        userDto.userBio( user.getUserBio() );
        userDto.nationality( user.getNationality() );
        userDto.city( user.getCity() );
        userDto.gender( user.getGender() );
        userDto.birthDate( user.getBirthDate() );
        userDto.languagesSpoken( user.getLanguagesSpoken() );
        userDto.email( user.getEmail() );
        userDto.username( user.getUsername() );

        return userDto.build();
    }

    @Override
    public User signUpToUser(SignUpDto signUpDto) {
        if ( signUpDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.firstName( signUpDto.getFirstName() );
        user.lastName( signUpDto.getLastName() );
        user.nationality( signUpDto.getNationality() );
        user.email( signUpDto.getEmail() );
        user.username( signUpDto.getUsername() );

        return user.build();
    }
}
