package com.globalmemories.backend.entites.trip;

import java.util.List;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "trip_transport")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@ToString(exclude = {"trip", "transport"}) // Prevents infinite loops in bidirectional relationships
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Ensures proper comparisons
public class TripTransport {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private TripTransportId id;

    @ManyToOne
    @MapsId("tripId")
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @MapsId("transportId")
    @JoinColumn(name = "transport_id")
    private Transport transport;

    @Column(name = "cost", nullable = false)
    private int cost;

    @Column(name = "description", nullable = false)
    @Size(max = 100)
    private String description;

    @ElementCollection
    private List<String> photos;

}