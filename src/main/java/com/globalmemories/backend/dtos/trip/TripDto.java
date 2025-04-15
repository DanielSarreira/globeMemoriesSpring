package com.globalmemories.backend.dtos.trip;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private String countryName; // Add this field
    private String city;
    private String title;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate startDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate endDate;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;
    private Integer tripDurationDays;
    private String tripSummary;
    private String tripDescription;
    private int tripRating;

    private CostDto cost;

    private Set<Long> categoryIds;
    private Set<String> categoryNames; // Add this field
    private Set<Long> languageSpokenIds;
    private Set<String> languageSpokenNames; // Add this field

    private List<RecommendedFoodDto> recommendedFoods;
    private List<TripReferencePointDto> referencePoints;
    private List<TripTransportDto> tripTransports;
    private List<AccommodationDto> accommodations;
    
}
