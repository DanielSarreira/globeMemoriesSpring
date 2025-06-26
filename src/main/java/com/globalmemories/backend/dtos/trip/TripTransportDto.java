package com.globalmemories.backend.dtos.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TripTransportDto {
    private Long transportId; // Refers to Transport entity
    private int cost; // Cost of transport
    private String description;
    private List<String> photos; // List of photo URLs
    private String name; // Transport details
}
