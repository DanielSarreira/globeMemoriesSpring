package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmemories.backend.entites.trip.TripReferencePoint;

public interface RecommendedFoodRepository extends JpaRepository<TripReferencePoint, Long> {

}