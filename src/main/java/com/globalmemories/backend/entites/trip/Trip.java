package com.globalmemories.backend.entites.trip;

import java.time.LocalDate;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

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

    @ManyToOne
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @Column(nullable = false)
    @Size(max = 100)
    private String title;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @Column(name = "trip_duration_days", nullable = false)
    private Integer tripDurationDays;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cost_id", referencedColumnName = "id")
    private Cost cost;

    @Column(name = "booking_date", nullable = true)
    private LocalDate bookingDate;

    @Column(name = "trip_sumary", nullable = false)
    @Size(max = 1000)
    private String tripSummary;
    
    @Column(name = "trip_description", nullable = false)
    @Size(max = 1000)
    private String tripDescription;

    @Column(name = "trip_rating", nullable = false)
    private int tripRating;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trip_itinerary_id", referencedColumnName = "id")
    private TripItinerary tripItinerary;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TripCategory> tripCategories;
    
    @Column(nullable = true)
    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripReferencePoint> referencePoints;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TripTransport> tripTransports;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<TripLanguageSpoken> tripLanguagesSpoken;

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL, orphanRemoval = true)
    @ToString.Exclude
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
