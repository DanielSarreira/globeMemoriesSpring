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
public class TripReferencePointDto implements Serializable {

    private Long id;
    private String name;
    private String description;
    private String city;
    private List<String> photos;
    private Long tripId;  // The ID of the related Trip entity
    
}