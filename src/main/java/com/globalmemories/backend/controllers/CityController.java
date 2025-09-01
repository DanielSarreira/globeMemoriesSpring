package com.globalmemories.backend.controllers;

import com.globalmemories.backend.dtos.CityDto;
import com.globalmemories.backend.services.CityService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
@RequiredArgsConstructor
public class CityController {

    private final CityService cityService;

    @GetMapping("/countries")
    public ResponseEntity<List<String>> getAllCountries() {
        List<String> countries = cityService.getAllCountries();
        return ResponseEntity.ok(countries);
    }

    @GetMapping("/by-country")
    public ResponseEntity<List<CityDto>> getCitiesByCountry(@RequestParam String countryName) {
        List<CityDto> cities = cityService.getCitiesByCountry(countryName);
        return ResponseEntity.ok(cities);
    }
}