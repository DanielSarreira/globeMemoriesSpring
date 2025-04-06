package com.globalmemories.backend.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globalmemories.backend.repositories.CountryRepository;
import com.globalmemories.backend.dtos.CountryDto;
import com.globalmemories.backend.entites.Country;
import com.globalmemories.backend.mappers.CountryMapper;

@Service
@RequiredArgsConstructor
public class CountryService {

    private final CountryRepository countryRepository;
    private final CountryMapper countryMapper;

    public Country getCountryById(Long countryId) {
        return countryRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + countryId));
    }

    public List<CountryDto> getAllCountries() {
        List<Country> countries = countryRepository.findAll();
        return countryMapper.toDtoList(countries);
    }
}