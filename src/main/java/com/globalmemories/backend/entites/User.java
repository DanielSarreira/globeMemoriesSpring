package com.globalmemories.backend.entites;

import java.time.LocalDate;
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
@Table(name = "app_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "first_name", nullable = false)
    @Size(max = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    @Size(max = 100)
    private String lastName;

    @Column(name = "user_bio", nullable = true)
    @Size(max = 1000)
    private String userBio;

    @Column(nullable = false)
    @Size(max = 55)
    private String nationality;

    @Column(nullable = true)
    @Size(max = 255)
    private String city;

    @Column(nullable = true)
    @Size(max = 15)
    private String gender;

    @Column(name = "birth_date", nullable = true)
    private LocalDate birthDate;

    @Column(name = "languages_spoken", nullable = true)
    @Size(max = 55)
    private String languagesSpoken;

    @Column(nullable = false)
    @Size(max = 55)
    private String email;

    @Column(nullable = false)
    @Size(max = 55)
    private String username;

    @Column(nullable = false)
    @Size(max = 100)
    private String password;
}
