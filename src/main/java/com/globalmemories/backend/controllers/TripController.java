package com.globalmemories.backend.controllers;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.entites.trip.Trip;
import com.globalmemories.backend.services.TripService;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    @Autowired
    private TripService tripService;

    @GetMapping
    public ResponseEntity<List<TripDto>> getAllTripsDto() {
        List<TripDto> tripDtos = tripService.getAllTrips();
        return ResponseEntity.ok(tripDtos);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TripDto>> getTripsByUserDto(@PathVariable Long userId) {
        List<TripDto> tripDtos = tripService.getTripsByUser(userId);
        return ResponseEntity.ok(tripDtos);
    }

    @PostMapping
    public ResponseEntity<TripDto> createTrip(@RequestBody TripDto tripDto) {
        TripDto createdTrip = tripService.createTrip(tripDto);
        return ResponseEntity.ok(createdTrip);
    }

}