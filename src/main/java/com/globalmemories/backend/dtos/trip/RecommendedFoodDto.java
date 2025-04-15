package com.globalmemories.backend.dtos.trip;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RecommendedFoodDto  implements Serializable{
    private Long id;
    private String name;
    private String description;
    private List<String> photos;
    private Long tripId;  // The ID of the related Trip entity
}