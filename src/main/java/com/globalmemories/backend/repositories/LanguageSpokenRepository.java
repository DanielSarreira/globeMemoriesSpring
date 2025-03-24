package com.globalmemories.backend.repositories;

import com.globalmemories.backend.entites.LanguageSpoken;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LanguageSpokenRepository extends JpaRepository<LanguageSpoken, Long> {

}
