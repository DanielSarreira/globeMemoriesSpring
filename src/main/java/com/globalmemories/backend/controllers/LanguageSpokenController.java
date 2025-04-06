package com.globalmemories.backend.controllers;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalmemories.backend.dtos.LanguageSpokenDto;
import com.globalmemories.backend.services.LanguageSpokenService;

@RestController
@RequestMapping("/languages-spoken")
@RequiredArgsConstructor
public class LanguageSpokenController {
    private final LanguageSpokenService languageSpokenService;

    @GetMapping
    public ResponseEntity<List<LanguageSpokenDto>> getAllLanguagesSpoken() {
        List<LanguageSpokenDto> languagesSpoken = languageSpokenService.getAllLanguagesSpoken();
        return ResponseEntity.ok(languagesSpoken);
    }
}