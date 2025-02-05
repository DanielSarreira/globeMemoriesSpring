package com.globalmemories.backend.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserAccountDto {

    @Email(message = "Invalid email format")
    private String email;

    @Size(min = 5, max = 30, message = "Username must be between 5 and 30 characters")
    private String username;

    @Pattern(
        regexp = "^(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
        message = "Password must be at least 8 characters long and include an uppercase letter, a digit, and a special character"
    )
    private String password;
    
}