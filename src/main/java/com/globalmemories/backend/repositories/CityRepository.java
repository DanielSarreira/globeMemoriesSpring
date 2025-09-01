package com.globalmemories.backend.repositories;

import com.globalmemories.backend.dtos.CityDto;
import com.globalmemories.backend.entites.City;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
    @Query("SELECT DISTINCT c.country_name FROM City c")
    List<String> findAllDistinctCountries();

    @Query("SELECT DISTINCT c FROM City c WHERE c.country_name = ?1")
    List<City> findAllDistinctCitiesByCountry(String countryName);
}

