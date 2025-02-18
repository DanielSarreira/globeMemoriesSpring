package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.globalmemories.backend.entites.trip.TripCategory;
import com.globalmemories.backend.entites.trip.TripCategoryId;
import com.globalmemories.backend.entites.Category;

import java.util.List;

public interface TripCategoryRepository extends JpaRepository<TripCategory, TripCategoryId> {
    @Query("SELECT tc.category FROM TripCategory tc WHERE tc.trip.id = :tripId")
    List<Category> findCategoriesByTripId(@Param("tripId") Long tripId);
}