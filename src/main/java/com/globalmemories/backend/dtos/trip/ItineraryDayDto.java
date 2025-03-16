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
public class ItineraryDayDto {
    private Long id;
    private String day;
    private List<ItineraryDayTopicDto> topics;
    private Long tripItineraryId;
}
