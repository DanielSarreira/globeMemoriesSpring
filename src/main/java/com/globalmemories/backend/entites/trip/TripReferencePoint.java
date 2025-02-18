package com.globalmemories.backend.entites.trip;

import jakarta.persistence.*;
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

    private String name;
    
    private String description;

    @ElementCollection
    private List<String> photos;

    @ManyToOne
    @JoinColumn(name = "trip_id", nullable = false)
    private Trip trip;
    
}
