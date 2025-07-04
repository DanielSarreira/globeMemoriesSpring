package com.globalmemories.backend.dtos.trip;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.globalmemories.backend.dtos.CategoryDto;
import com.globalmemories.backend.dtos.LanguageSpokenDto;

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
    private String weather;
    private int tripRating;

    private CostDto cost;
    private TripItineraryDto tripItinerary; // Add this field

    private List<CategoryDto> categories;
    private List<LanguageSpokenDto> languagesSpoken;

    private List<NegativePointDto> negativePoints;
    private List<RecommendedFoodDto> recommendedFoods;
    private List<TripReferencePointDto> referencePoints;
    private List<TripTransportDto> tripTransports;
    private List<AccommodationDto> accommodations;
    
}
