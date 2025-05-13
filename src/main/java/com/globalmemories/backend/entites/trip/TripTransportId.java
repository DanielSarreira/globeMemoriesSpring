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
public class TripTransportId implements Serializable {

    private Long tripId;
    private Long transportId;
    private Integer sequenceNumber;
}