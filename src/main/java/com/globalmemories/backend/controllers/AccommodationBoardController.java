package com.globalmemories.backend.controllers;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalmemories.backend.dtos.trip.AccommodationBoardDto;
import com.globalmemories.backend.services.AccommodationBoardService;

@RestController
@RequestMapping("/accommodation-boards")
@RequiredArgsConstructor
public class AccommodationBoardController {

    private final AccommodationBoardService accommodationBoardService;

    @GetMapping
    public ResponseEntity<List<AccommodationBoardDto>> getAllCountries() {
        List<AccommodationBoardDto> accommodationBoardDtos = accommodationBoardService.getAllAccommodationBoards();
        return ResponseEntity.ok(accommodationBoardDtos);
    }
}