package com.globalmemories.backend.controllers;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.entites.Country;
import com.globalmemories.backend.entites.User;
import com.globalmemories.backend.services.CountryService;
import com.globalmemories.backend.services.TripService;
import com.globalmemories.backend.services.UserService;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trips")
@RequiredArgsConstructor
public class TripController {

    private final TripService tripService;
    private final UserService userService;
    private final CountryService countryService;

    /**
     * Create a new trip.
     *
     * @param tripDto the trip details from the client
     * @param user    the user associated with the trip (you can get this from authentication)
     * @param country the country associated with the trip
     * @return the created trip in the form of TripDto
     */
    @PostMapping
    public ResponseEntity<TripDto> createTrip(@RequestBody TripDto tripDto,
                                              @RequestParam Long userId,
                                              @RequestParam Long countryId) {
        // Retrieve User and Country using their respective services
        User user = userService.getUserById(userId);
        Country country = countryService.getCountryById(countryId);

        // Call the service method to create the trip
        TripDto createdTripDto = tripService.createTrip(tripDto, user, country);

        // Return the created trip as a response with HTTP 201 status
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTripDto);
    }

}