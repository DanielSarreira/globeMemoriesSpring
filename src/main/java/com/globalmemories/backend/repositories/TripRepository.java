package com.globalmemories.backend.repositories;

import org.springframework.data.domain.Page; 
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import com.globalmemories.backend.entites.trip.Trip;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    @Query("SELECT tc.trip FROM TripCategory tc WHERE tc.category.name = :name")
    List<Trip> findTripsByCategoryName(@Param("name") String name);

    // Existing method for non-paginated results
    List<Trip> findByUserId(Long userId);

    // New method for paginated results
    Page<Trip> findByUserId(Long userId, Pageable pageable);
}