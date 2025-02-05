package com.globalmemories.backend.controllers;


import com.globalmemories.backend.dtos.UserAccountDto;
import com.globalmemories.backend.dtos.UserDto;
import com.globalmemories.backend.services.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import java.util.HashMap;
import java.util.Map;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
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

}
