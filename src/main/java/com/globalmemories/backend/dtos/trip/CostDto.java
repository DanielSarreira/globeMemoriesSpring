package com.globalmemories.backend.dtos.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class CostDto {
    private Long id;
    private int total;
    private int accommodation;
    private int food;
    private int transport;
    private int extra;
    private Long tripId;
}
