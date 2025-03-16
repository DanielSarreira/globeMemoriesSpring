package com.globalmemories.backend.services;

import org.springframework.stereotype.Service;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.entites.User;
import com.globalmemories.backend.entites.Country;
import com.globalmemories.backend.entites.trip.Trip;
import com.globalmemories.backend.mappers.TripMapper;
import com.globalmemories.backend.repositories.TripRepository;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class TripService {
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;

    public TripDto createTrip(TripDto tripDto, User user, Country country) {
        Trip trip = tripMapper.toEntity(tripDto);
        trip.setUser(user);
        trip.setCountry(country);
        tripRepository.save(trip);
        return tripMapper.toDto(trip);
    }
}