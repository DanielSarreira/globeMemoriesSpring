package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.globalmemories.backend.entites.trip.NegativePoint;

public interface NegativePointRepository extends JpaRepository<NegativePoint, Long> {

}