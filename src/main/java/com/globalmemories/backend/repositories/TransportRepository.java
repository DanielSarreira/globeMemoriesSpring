package com.globalmemories.backend.repositories;

import com.globalmemories.backend.entites.trip.Transport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransportRepository extends JpaRepository<Transport, Long> {
}
