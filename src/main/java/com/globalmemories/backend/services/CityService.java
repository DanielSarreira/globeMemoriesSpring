package com.globalmemories.backend.services;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.globalmemories.backend.repositories.CityRepository;
import com.globalmemories.backend.dtos.CityDto;
import com.globalmemories.backend.entites.City;
import com.globalmemories.backend.mappers.CityMapper;

@Service
@RequiredArgsConstructor
public class CityService {

    private final CityRepository cityRepository;
    private final CityMapper cityMapper;

    public City getCountryById(Long countryId) {
        return cityRepository.findById(countryId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + countryId));
    }

    public List<String> getAllCountries() {
        List<String> countries = cityRepository.findAllDistinctCountries();
        return countries.stream()
                .sorted()
                .collect(Collectors.toList());
    }

    public List<CityDto> getCitiesByCountry(String countryName) {
        List<City> cities = cityRepository.findAllDistinctCitiesByCountry(countryName);
        return cityMapper.toDtoList(cities);
    }
}