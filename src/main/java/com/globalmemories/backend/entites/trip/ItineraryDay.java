package com.globalmemories.backend.entites.trip;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "itinerary_day")
public class ItineraryDay {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "day", nullable = false)
    @Size(max = 55)
    private String day;

    @OneToMany(mappedBy = "itineraryDay", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItineraryDayTopic> topics = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "trip_itinerary_id", nullable = false)
    private TripItinerary tripItinerary;
}