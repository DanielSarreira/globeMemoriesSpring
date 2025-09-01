package com.globalmemories.backend.dtos.trip;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

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
    private String city;
    private int price;
    private int nrNights;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate checkIn;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate checkOut;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private LocalDate bookingDate;
    private String description;
    private int rating;
}