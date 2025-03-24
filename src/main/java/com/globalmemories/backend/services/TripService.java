package com.globalmemories.backend.services;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.entites.trip.*;
import com.globalmemories.backend.mappers.TripMapper;
import com.globalmemories.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class TripService {

    @Autowired
    private TripRepository tripRepository;
    @Autowired
    private CostRepository costRepository;
    @Autowired
    private TripReferencePointRepository referencePointRepository;
    @Autowired
    private TripTransportRepository tripTransportRepository;
    @Autowired
    private AccommodationRepository accommodationRepository;
    @Autowired
    private TransportRepository transportRepository;
    @Autowired
    private TripMapper tripMapper;

    @Transactional
    public Trip createTrip(TripDto tripDto) {
        System.out.println("TRIPDTO_TEST");
        System.out.println(" ");
        System.out.println(tripDto);
        System.out.println(" ");
        Trip trip = tripMapper.toEntity(tripDto);
        System.out.println(" ");
        System.out.println("TRIP_TEST");
        System.out.println(" ");
        System.out.println(trip);
        System.out.println(" ");
        System.out.println(" ");
        System.out.println("TRIP_TEST_TEST");
        System.out.println(" ");
        System.out.println("endDate before save: {} " + trip.getEndDate());
        System.out.println(" ");
        
        trip.setReferencePoints(null);
        trip.setTripTransports(null);
        trip.setAccommodations(null);
        trip.setTripCategories(null);
        trip.setTripLanguagesSpoken(null);
        
        trip = tripRepository.save(trip); // Save to get ID
        System.out.println(" ");
        System.out.println("TRIP_TEST_REPO");
        System.out.println(" ");
        System.out.println("endDate before save: {} " + trip);
        System.out.println(" ");

        final Trip finalTrip = trip;      // Final reference for lambdas

        if (tripDto.getCost() != null) {
            Cost cost = tripMapper.mapCostFromDto(tripDto.getCost());
            cost.setTrip(finalTrip);
            cost = costRepository.save(cost);
            trip.setCost(cost);
        }

        if (tripDto.getReferencePoints() != null) {
            List<TripReferencePoint> referencePoints = tripMapper.mapReferencePointsFromDto(tripDto.getReferencePoints(), finalTrip);
            referencePoints.forEach(rp -> rp.setTrip(finalTrip));
            referencePoints = referencePointRepository.saveAll(referencePoints);
            trip.setReferencePoints(referencePoints);
        }

        if (tripDto.getTripTransports() != null) {
            List<TripTransport> tripTransports = tripMapper.mapTripTransportsFromDto(tripDto.getTripTransports(), finalTrip);
            System.out.println(" ");
            System.out.println("TRANSPORT_TEST_REPO");
            System.out.println(" ");
            System.out.println("TRIP_TRANSPORTS {} " + tripTransports);
            System.out.println(" ");
            tripTransports.forEach(tt -> {
                tt.setTrip(finalTrip);
                System.out.println(" ");
                System.out.println("TRANSPORT_TEST_REPO");
                System.out.println(" ");
                System.out.println("TRIP_TRANSPORTS {} " + tt);
                System.out.println(" ");
                Transport transport = transportRepository.findById(tt.getTransport().getId())
                        .orElseThrow(() -> new RuntimeException("Transport not found with id: " + tt.getTransport().getId()));
                tt.setTransport(transport);
                tt.setId(new TripTransportId(finalTrip.getId(), transport.getId()));
            });
            tripTransports = tripTransportRepository.saveAll(tripTransports);
            trip.setTripTransports(tripTransports);
        }

        if (tripDto.getAccommodations() != null) {
            List<Accommodation> accommodations = tripMapper.mapAccommodationsFromDto(tripDto.getAccommodations(), finalTrip);
            accommodations.forEach(acc -> acc.setTrip(finalTrip));
            accommodations = accommodationRepository.saveAll(accommodations);
            trip.setAccommodations(accommodations);
        }

        return tripRepository.save(trip);
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id: " + id));
    }
}