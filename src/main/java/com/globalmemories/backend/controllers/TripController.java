package com.globalmemories.backend.controllers;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.entites.Country;
import com.globalmemories.backend.entites.User;
import com.globalmemories.backend.entites.trip.Trip;
import com.globalmemories.backend.services.CountryService;
import com.globalmemories.backend.services.TripService;
import com.globalmemories.backend.services.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    @Autowired
    private TripService tripService;

    @PostMapping("/trips")
    public ResponseEntity<Trip> createTrip(@RequestBody TripDto tripDto) {
        Trip trip = tripService.createTrip(tripDto);
        return ResponseEntity.ok(trip);
    }
}