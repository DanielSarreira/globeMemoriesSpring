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
    private String title;
    private String countryName;
    private Integer tripDurationDays;
    private String tripSummary;
    private String tripDescription;
    private int tripRating;

    // Nested DTOs or simplified lists
    private List<String> tripCategories;
    private List<String> referencePoints;
    private List<String> tripTransports;
    private List<String> tripLanguagesSpoken;
    private List<String> accommodations;
    
}
