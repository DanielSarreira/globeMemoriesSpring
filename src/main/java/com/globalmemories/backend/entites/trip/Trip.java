package com.globalmemories.backend.entites.trip;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Set;

import java.util.ArrayList;
import java.util.List;

import com.globalmemories.backend.entites.trip.TripReferencePoint;
import com.globalmemories.backend.entites.User;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "trip")
public class Trip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_itinerary_id", referencedColumnName = "id")
    private TripItinerary tripItinerary;
    
    @Column(nullable = false)
    @Size(max = 100)
    private String title;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TripCountry> tripCountries;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TripCategory> tripCategories;

    @Column(nullable = true)
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripReferencePoint> referencePoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cost_id", referencedColumnName = "id")
    private Cost cost;

    @Column(name = "trip_duration_days", nullable = false)
    @Size(max = 15)
    private Integer tripDurationDays;

    //create a class name and used for
    @Column(nullable = true)
    private String transportation;

    //create a table
    @Column(name = "language_spoken", nullable = true)
    @Size(max = 55)
    private String languageSpoken;

    @Column(name = "trip_description", nullable = false)
    @Size(max = 55)
    private String tripDescription;

    //a table for acomudation, each acomudation with price per day (optional), type (if hotel, motel, house, camping, etc), number of nights (optional), name of the place
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    @Size(max = 55)
    private List<Accomodations> accomodations = new ArrayList<>();

    @Column(name = "trip_privacy", nullable = false)
    @Size(max = 100)
    private String tripPrivacy;

    @Column(name = "allow_comments", nullable = false)
    @Size(max = 100)
    private Boolean allowComments;

    @Column(name = "comments_per_user", nullable = false)
    @Size(max = 100)
    private String commentsPerUser;

}
