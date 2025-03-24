package com.globalmemories.backend.repositories;

import com.globalmemories.backend.entites.trip.*;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TripTransportRepository extends JpaRepository<TripTransport, TripTransportId> {
    
}