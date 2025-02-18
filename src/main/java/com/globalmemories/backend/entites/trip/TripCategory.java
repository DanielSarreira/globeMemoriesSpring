package com.globalmemories.backend.entites.trip;

import java.io.Serializable;

import com.globalmemories.backend.entites.Category;
import jakarta.persistence.*;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import lombok.*;

@Entity
@Table(name = "trip_categories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString(exclude = {"trip", "category"}) // Prevents infinite loops in bidirectional relationships
@EqualsAndHashCode(onlyExplicitlyIncluded = true) // Ensures proper comparisons
public class TripCategory implements Serializable {

    @EmbeddedId
    @EqualsAndHashCode.Include
    private TripCategoryId id;

    @ManyToOne
    @MapsId("tripId")
    @JoinColumn(name = "trip_id")
    private Trip trip;

    @ManyToOne
    @MapsId("categoryId")
    @JoinColumn(name = "category_id")
    private Category category;
}