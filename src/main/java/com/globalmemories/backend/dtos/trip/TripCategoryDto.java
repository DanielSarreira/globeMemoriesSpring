package com.globalmemories.backend.dtos.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TripCategoryDto implements Serializable {

    private Long tripId;
    private Long categoryId;

    private String tripName;  
    private String categoryName; 
}