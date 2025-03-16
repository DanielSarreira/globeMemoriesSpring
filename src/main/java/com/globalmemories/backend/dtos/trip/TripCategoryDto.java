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

    // Optionally, if you want to include additional fields from the `Trip` and `Category` objects.
    private String tripName;  // Assuming there's a `name` field in the Trip class
    private String categoryName;  // Assuming there's a `name` field in the Category class
}