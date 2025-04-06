package com.globalmemories.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.globalmemories.backend.dtos.LanguageSpokenDto;
import com.globalmemories.backend.entites.LanguageSpoken;
import com.globalmemories.backend.mappers.LanguageSpokenMapper;
import com.globalmemories.backend.repositories.LanguageSpokenRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class LanguageSpokenService {
    private final LanguageSpokenRepository languageSpokenRepository;
    private final LanguageSpokenMapper languageSpokenMapper;

    public LanguageSpoken getLanguageSpokenById(Long languageSpokenId) {
        return languageSpokenRepository.findById(languageSpokenId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + languageSpokenId));
    }

    public List<LanguageSpokenDto> getAllLanguagesSpoken() {
        List<LanguageSpoken> languagesSpoken = languageSpokenRepository.findAll();
        return languageSpokenMapper.toDtoList(languagesSpoken);
    }
}