package com.globalmemories.backend.entites.trip;

import com.globalmemories.backend.entites.Country;

import jakarta.persistence.*; // JPA annotations
import lombok.*;

@Entity
@Table(name = "trip_countries")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"trip", "country"}) // Prevents infinite loops
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Avoids unintended Hibernate issues
public class TripCountry {
    @EmbeddedId
    @EqualsAndHashCode.Include
    private TripCountryId id;

    @ManyToOne
    @MapsId("tripId")
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @MapsId("countryId")
    @JoinColumn(name = "country_id")
    private Country country;
}