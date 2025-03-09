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
@Table(name = "accommodation")
public class Accommodation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    @Size(max = 55)
    private String name;

    @Column(name = "price", nullable = false)
    private int price;

    //mudar para check in e out dates
    @Column(name = "nr_of_nights", nullable = false)
    private int nrOfNights;

    //adicionar tipo tbm e fotos tbm
    @Column(name = "description", nullable = false)
    @Size(max = 255)
    private String description;

    //adicionar regime tbm
    @Column(name = "rating", nullable = false)
    private int rating;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;
}