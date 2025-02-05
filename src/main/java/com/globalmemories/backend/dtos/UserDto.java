package com.globalmemories.backend.dtos;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String userBio;
    private String nationality;
    private String city;
    private String gender;
    private LocalDate birthDate;
    private String languagesSpoken;
    private String email;
    private String username;
    private String token;
    
}
