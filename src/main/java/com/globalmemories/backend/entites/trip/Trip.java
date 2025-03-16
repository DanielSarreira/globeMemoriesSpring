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
import com.globalmemories.backend.entites.Country;
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

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TripCategory> tripCategories;

    @Column(nullable = true)
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripReferencePoint> referencePoints;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cost_id", referencedColumnName = "id")
    private Cost cost;

    @Column(name = "trip_duration_days", nullable = false)
    private Integer tripDurationDays;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripTransport> tripTransports = new ArrayList<>();

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripLanguageSpoken> tripLanguagesSpoken = new ArrayList<>();

    @Column(name = "trip_sumary", nullable = false)
    @Size(max = 1000)
    private String tripSummary;
    
    @Column(name = "trip_description", nullable = false)
    @Size(max = 1000)
    private String tripDescription;

    @Column(name = "trip_rating", nullable = false)
    private int tripRating;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Accommodation> accommodations = new ArrayList<>();

    @Column(name = "trip_privacy", nullable = true)
    @Size(max = 100)
    private String tripPrivacy;

    @Column(name = "allow_comments", nullable = true)
    private Boolean allowComments;

    @Column(name = "comments_per_user", nullable = true)
    @Size(max = 100)
    private String commentsPerUser;

}
