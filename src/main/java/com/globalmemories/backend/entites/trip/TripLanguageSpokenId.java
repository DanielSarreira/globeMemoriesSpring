package com.globalmemories.backend.entites.trip;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class TripLanguageSpokenId implements Serializable {

    @Column(name = "trip_id")
    private Long tripId;
    @Column(name = "language_id")
    private Long languageSpokenId;

}