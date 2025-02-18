package com.globalmemories.backend.entites.trip;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Data
@Entity
@Table(name = "cost")
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total", nullable = false)
    private int total;

    @Column(name = "accommodation", nullable = false)
    private int accommodation;

    @Column(name = "food", nullable = false)
    private int food;

    @Column(name = "transport", nullable = false)
    private int transport; 

    @Column(name = "extra", nullable = false)
    private int extra; 

    @OneToOne(mappedBy = "cost")
    private Trip trip;
}