package com.globalmemories.backend.entites.trip;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "accommodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(max = 55)
    private String name;

    @ManyToOne
    @JoinColumn(name = "accommodation_type_id", nullable = false)
    private AccommodationType accommodationType;

    @ManyToOne
    @JoinColumn(name = "accommodation_board_id", nullable = false)
    private AccommodationBoard accommodationBoard;

    @Column(name = "price", nullable = false)
    private int price;

    @Column(name = "nr_nights", nullable = false)
    private int nrNights;

    @Column(name = "check_in", nullable = true)
    private LocalDate checkIn;

    @Column(name = "check_out", nullable = true)
    private LocalDate checkOut;

    @Column(name = "booking_date", nullable = true)
    private LocalDate bookingDate;

    @Column(name = "description", nullable = false)
    @Size(max = 250)
    private String description;

    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    @ToString.Exclude
    private Trip trip;
}