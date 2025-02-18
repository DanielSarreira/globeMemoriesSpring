package com.globalmemories.backend.entites.trip;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "trip_itinerary")
public class TripItinerary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nr_days", nullable = false)
    private Integer nrDays;

    @OneToMany(mappedBy = "trip_itinerary", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItineraryDay> itineraryDays = new ArrayList<>();

    @OneToOne(mappedBy = "trip_itinerary", cascade = CascadeType.ALL)
    private Trip trip;
}