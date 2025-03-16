package com.globalmemories.backend.dtos.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TripTransportDto {
    private Long id;
    private Long tripId;
    private Long transportId;
    private int cost;
}