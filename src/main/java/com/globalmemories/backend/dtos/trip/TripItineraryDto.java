package com.globalmemories.backend.dtos.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripItineraryDto implements Serializable {

    private Long id;
    private Long tripId;  // Assuming you only need the trip ID in the DTO
    private List<ItineraryDayDto> itineraryDays;  // Assuming you have a DTO for ItineraryDay

}