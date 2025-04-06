package com.globalmemories.backend.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.globalmemories.backend.dtos.trip.TransportDto;
import com.globalmemories.backend.services.TransportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/transports")
@RequiredArgsConstructor
public class TransportController {
    private final TransportService transportService;

    @GetMapping
    public ResponseEntity<List<TransportDto>> getAllTransports() {
        List<TransportDto> transports = transportService.getAllTransports();
        return ResponseEntity.ok(transports);
    }
}