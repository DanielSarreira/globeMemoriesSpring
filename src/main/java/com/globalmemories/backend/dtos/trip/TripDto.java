package com.globalmemories.backend.dtos.trip;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.globalmemories.backend.entites.trip.TripItinerary;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TripDto {

    private Long id;
    private Long userId;
    private Long countryId;
    private String title;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer tripDurationDays;
    private String tripSummary;
    private String tripDescription;
    private int tripRating;

    private CostDto cost;

    private Set<Long> categoryIds;
    private Set<Long> languageSpokenIds;

    private List<TripReferencePointDto> referencePoints;
    private List<TripTransportDto> tripTransports;
    private List<AccommodationDto> accommodations;
    
}
