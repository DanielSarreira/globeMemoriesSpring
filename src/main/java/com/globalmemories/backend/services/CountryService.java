package com.globalmemories.backend.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.globalmemories.backend.repositories.CountryRepository;
import com.globalmemories.backend.entites.Country;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;

    public Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + countryId));
    }
}