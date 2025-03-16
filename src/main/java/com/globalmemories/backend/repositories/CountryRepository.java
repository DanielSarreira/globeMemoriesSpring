package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.globalmemories.backend.entites.Country;

public interface CountryRepository extends JpaRepository<Country, Long> {
}