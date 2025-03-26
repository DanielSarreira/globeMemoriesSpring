package com.globalmemories.backend.entites;

import java.util.ArrayList;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import com.globalmemories.backend.entites.trip.TripLanguageSpoken;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "language_spoken")
public class LanguageSpoken {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @OneToMany(mappedBy = "languageSpoken", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TripLanguageSpoken> tripLanguagesSpoken;

}