package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.globalmemories.backend.entites.trip.AccommodationType;

@Repository
public interface AccommodationTypeRepository extends JpaRepository<AccommodationType, Long> {
}
