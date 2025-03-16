package com.globalmemories.backend.dtos.trip;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TripLanguageSpokenDto implements Serializable {

    private Long id;
    private Long tripId;  // ID of the related Trip entity
    private Long languageSpokenId;  // ID of the related LanguageSpoken entity
    
    // Optionally, you could add fields for the Trip name and Language name if needed
    private String tripName;  // Assuming there's a `name` field in the Trip entity
    private String languageName;  // Assuming there's a `name` field in the LanguageSpoken entity
}