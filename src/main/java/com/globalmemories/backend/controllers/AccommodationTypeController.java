package com.globalmemories.backend.controllers;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalmemories.backend.dtos.trip.AccommodationTypeDto;
import com.globalmemories.backend.services.AccommodationTypeService;

@RestController
@RequestMapping("/accommodation-types")
@RequiredArgsConstructor
public class AccommodationTypeController {

    private final AccommodationTypeService accommodationTypeService;

    @GetMapping
    public ResponseEntity<List<AccommodationTypeDto>> getAllAccommodationTypes() {
        List<AccommodationTypeDto> accommodationtypes = accommodationTypeService.getAllAccommodationTypes();
        return ResponseEntity.ok(accommodationtypes);
    }
}