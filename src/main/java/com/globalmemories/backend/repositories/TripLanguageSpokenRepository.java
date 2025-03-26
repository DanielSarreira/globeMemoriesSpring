package com.globalmemories.backend.repositories;

import com.globalmemories.backend.entites.trip.TripLanguageSpoken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TripLanguageSpokenRepository extends JpaRepository<TripLanguageSpoken, Long> {

}
