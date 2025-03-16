package com.globalmemories.backend.dtos.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class AccommodationDto {
    private Long id;
    private String name;
    private int price;
    private int nrOfNights;
    private String description;
    private int rating;
    private Long tripId;
}