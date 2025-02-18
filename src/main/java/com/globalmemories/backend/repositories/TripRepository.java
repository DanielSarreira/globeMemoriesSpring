package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.globalmemories.backend.entites.trip.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT tc.trip FROM TripCategory tc WHERE tc.category.name = :name")
    List<Trip> findTripsByCategoryName(@Param("name") String name);
}