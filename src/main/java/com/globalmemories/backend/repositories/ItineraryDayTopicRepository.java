package com.globalmemories.backend.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalmemories.backend.entites.trip.ItineraryDayTopic;

@Repository
public interface ItineraryDayTopicRepository extends JpaRepository<ItineraryDayTopic, Long> {
}