package com.globalmemories.backend.entites.trip;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Embeddable
public class TripCategoryId implements Serializable {

    private Long tripId;
    private Long categoryId;

}