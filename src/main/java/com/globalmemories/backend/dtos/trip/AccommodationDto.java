package com.globalmemories.backend.dtos.trip;

import java.time.LocalDate;

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
    private Long accommodationTypeId; // Instead of entity reference
    private String accommodationTypeName; // Name of the accommodation type
    private Long accommodationBoardId; // Instead of entity reference
    private String accommodationBoardName; // Name of the accommodation board
    private int price;
    private int nrNights;
    private LocalDate checkIn;
    private LocalDate checkOut;
    private LocalDate bookingDate;
    private String description;
    private int rating;
}