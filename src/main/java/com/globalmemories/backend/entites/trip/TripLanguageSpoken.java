package com.globalmemories.backend.entites.trip;

import jakarta.persistence.*;
import lombok.*;

import com.globalmemories.backend.entites.LanguageSpoken;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "trip_language_spoken")
public class TripLanguageSpoken {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private TripLanguageSpokenId id;

    @ManyToOne
    @MapsId("tripId")
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;

    @ManyToOne
    @MapsId("languageSpokenId")
    @JoinColumn(name = "language_id", nullable = false)
    private LanguageSpoken languageSpoken;
}