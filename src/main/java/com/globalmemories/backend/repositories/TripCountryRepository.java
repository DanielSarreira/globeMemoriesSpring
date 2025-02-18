package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmemories.backend.entites.trip.TripCountry;
import com.globalmemories.backend.entites.trip.TripCountryId;

public interface TripCountryRepository extends JpaRepository<TripCountry, TripCountryId> {
}