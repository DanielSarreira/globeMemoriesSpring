package com.globalmemories.backend.dtos.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
public class TripCategoryIdDto implements Serializable {

    private Long tripId;
    private Long categoryId;
}