package com.globalmemories.backend.entites.trip;

import jakarta.persistence.*;
import lombok.*;

import com.globalmemories.backend.entites.LanguageSpoken;

@Entity
@Table(name = "trip_language_spoken")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString(exclude = {"trip", "language_spoken"}) // Prevents infinite loops in bidirectional relationships
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Ensures proper comparisons
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