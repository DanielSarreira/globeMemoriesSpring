package com.globalmemories.backend.services;

import java.util.List;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.globalmemories.backend.dtos.trip.TransportDto;
import com.globalmemories.backend.entites.trip.Transport;
import com.globalmemories.backend.mappers.TransportMapper;
import com.globalmemories.backend.repositories.TransportRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class TransportService {
    private final TransportRepository transportRepository;
    private final TransportMapper transportMapper;

    public Transport getTransportById(Long transportId) {
        return transportRepository.findById(transportId)
                .orElseThrow(() -> new EntityNotFoundException("Transport not found with id: " + transportId));
    }

    public List<TransportDto> getAllTransports() {
        List<Transport> transports = transportRepository.findAll();
        return transportMapper.toDtoList(transports);
    }
}