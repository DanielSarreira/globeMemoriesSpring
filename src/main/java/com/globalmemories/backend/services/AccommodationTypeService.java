package com.globalmemories.backend.services;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globalmemories.backend.dtos.trip.AccommodationTypeDto;
import com.globalmemories.backend.entites.trip.AccommodationType;
import com.globalmemories.backend.mappers.AccommodationTypeMapper;
import com.globalmemories.backend.repositories.AccommodationTypeRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AccommodationTypeService {

    private final AccommodationTypeRepository accommodationTypeRepository;
    private final AccommodationTypeMapper accommodationTypeMapper;

    public AccommodationType getAccommodationTypeById(Long accommodationTypeId) {
        return accommodationTypeRepository.findById(accommodationTypeId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + accommodationTypeId));
    }

    public List<AccommodationTypeDto> getAllAccommodationTypes() {
        List<AccommodationType> accommodationTypes = accommodationTypeRepository.findAll();
        return accommodationTypeMapper.toDtoList(accommodationTypes);
    }
}