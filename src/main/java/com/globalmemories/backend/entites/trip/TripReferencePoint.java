package com.globalmemories.backend.entites.trip;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "trip_reference_point")
public class TripReferencePoint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;
    
    @Column(nullable = false)
    private String description;

    @Column(name = "city", nullable = false)
    @Size(max = 55)
    private String city;

    @ElementCollection
    private List<String> photos;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;
    
}
