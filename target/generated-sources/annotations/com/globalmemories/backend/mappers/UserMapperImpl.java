package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.SignUpDto;
import com.globalmemories.backend.dtos.UserDto;
import com.globalmemories.backend.entites.User;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-28T22:01:26+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
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
        userDto.gender( user.getGender() );
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

    @Override
    public List<UserDto> toDtoList(List<User> users) {
        if ( users == null ) {
            return null;
        }

        List<UserDto> list = new ArrayList<UserDto>( users.size() );
        for ( User user : users ) {
            list.add( toUserDto( user ) );
        }

        return list;
    }
}
