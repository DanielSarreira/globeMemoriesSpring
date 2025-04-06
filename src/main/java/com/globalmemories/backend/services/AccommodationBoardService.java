package com.globalmemories.backend.services;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.stereotype.Service;

import com.globalmemories.backend.dtos.trip.AccommodationBoardDto;
import com.globalmemories.backend.entites.trip.AccommodationBoard;
import com.globalmemories.backend.mappers.AccommodationBoardMapper;
import com.globalmemories.backend.repositories.AccommodationBoardRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class AccommodationBoardService {
    private final AccommodationBoardRepository accommodationBoardRepository;
    private final AccommodationBoardMapper accommodationBoardMapper;

    public AccommodationBoard getAccommodationBoardById(Long accommodationBoardId) {
        return accommodationBoardRepository.findById(accommodationBoardId)
                .orElseThrow(() -> new EntityNotFoundException("Country not found with id: " + accommodationBoardId));
    }

    public List<AccommodationBoardDto> getAllAccommodationBoards() {
        List<AccommodationBoard> accommodationBoards = accommodationBoardRepository.findAll();
        return accommodationBoardMapper.toDtoList(accommodationBoards);
    }
}