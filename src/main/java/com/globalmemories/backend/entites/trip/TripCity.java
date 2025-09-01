package com.globalmemories.backend.entites.trip;

import java.io.Serializable;

import com.globalmemories.backend.entites.City;
import jakarta.persistence.*;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.*;

@Entity
@Table(name = "trip_city")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString(exclude = {"trip", "city"}) // Prevents infinite loops in bidirectional relationships
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Ensures proper comparisons
public class TripCity implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private TripCityId id;

    @ManyToOne
    @MapsId("tripId")
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @MapsId("cityId")
    @JoinColumn(name = "city_id")
    private City city;
}