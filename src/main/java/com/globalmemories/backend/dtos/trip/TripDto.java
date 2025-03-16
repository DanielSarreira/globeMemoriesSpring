package com.globalmemories.backend.dtos.trip;

import java.util.List;

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
    private Long costId;
    private String title;
    private Integer tripDurationDays;
    private String tripSummary;
    private String tripDescription;
    private int tripRating;

    private List<TripCategoryDto> tripCategories;
    private List<TripReferencePointDto> referencePoints;
    private List<TripTransportDto> tripTransports;
    private List<TripLanguageSpokenDto> tripLanguagesSpoken;
    private List<AccommodationDto> accommodations;
    
}
