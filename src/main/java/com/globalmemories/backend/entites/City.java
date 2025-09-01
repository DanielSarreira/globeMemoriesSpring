package com.globalmemories.backend.entites;

import java.util.Set;

import com.globalmemories.backend.entites.trip.TripCity;

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
@Table(name = "city")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "city_name", nullable = false)
    @Size(max = 55)
    private String cityName;

    @Column(name = "country_name", nullable = false)
    @Size(max = 55)
    private String countryName;

    @OneToMany(mappedBy = "city", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TripCity> tripCities;

}