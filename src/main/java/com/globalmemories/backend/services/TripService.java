package com.globalmemories.backend.services;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.dtos.trip.TripTransportDto;
import com.globalmemories.backend.entites.trip.*;
import com.globalmemories.backend.mappers.TripMapper;
import com.globalmemories.backend.mappers.TripMapperHelper;
import com.globalmemories.backend.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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
    private TripCategoryRepository tripCategoryRepository;
    @Autowired
    private TripLanguageSpokenRepository tripLanguageSpokenRepository;
    @Autowired
    private TripMapper tripMapper;
    @Autowired
    private TripMapperHelper tripMapperHelper;


    public List<TripDto> getAllTrips() {
        List<Trip> trips = tripRepository.findAll();
        List<TripDto> tripDtos = trips.stream()
                .map(tripMapper::toDto)
                .collect(Collectors.toList());
        return tripDtos;
    }

    public List<TripDto> getTripsByUser(Long userId) {
        if (userId == null || userId <= 0) {
            throw new IllegalArgumentException("Invalid user ID: " + userId);
        }
        List<Trip> trips = tripRepository.findByUserId(userId);
        List<TripDto> tripDtos = trips.stream()
                .map(tripMapper::toDto)
                .collect(Collectors.toList());
        return tripDtos;
    }

    @Transactional
    public TripDto createTrip(TripDto tripDto) {

        Trip trip = tripMapper.toEntity(tripDto);

        trip.setReferencePoints(null);
        trip.setTripTransports(null);
        trip.setAccommodations(null);
        trip.setTripCategories(null);
        trip.setTripLanguagesSpoken(null);
        
        trip = tripRepository.save(trip); // Save to get ID

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
        //ADD THIS METHOD TO CODE
        if (tripDto.getTripTransports() != null) {
            try {
                List<TripTransport> tripTransports = tripMapper.mapTripTransportsFromDto(tripDto.getTripTransports(), trip);
                List<TripTransportDto> transportDtos = tripDto.getTripTransports(); // Original DTO list
                for (int i = 0; i < tripTransports.size(); i++) {
                    TripTransport tt = tripTransports.get(i);
                    Long transportId = transportDtos.get(i).getTransportId(); // Match by index
                    tt.setTrip(trip);
                    Transport transport = transportRepository.findById(transportId)
                            .orElseThrow(() -> new RuntimeException("Transport not found with id: " + transportId));
                    tt.setTransport(transport);
                    tt.setId(new TripTransportId(trip.getId(), transport.getId()));
                }
                tripTransports = tripTransportRepository.saveAll(tripTransports);
                trip.setTripTransports(tripTransports);
            } catch (Exception e) {

            }
        }

        if (tripDto.getAccommodations() != null) {
            List<Accommodation> accommodations = tripMapperHelper.mapAccommodationsFromDto(tripDto.getAccommodations(), finalTrip);
            accommodations.forEach(acc -> 
                acc.setTrip(finalTrip)
            );
            accommodations = accommodationRepository.saveAll(accommodations);
            trip.setAccommodations(accommodations);
        }

        if (tripDto.getCategoryIds() != null) {
            System.out.println(" ");
            System.out.println("TRIP_CATEGORIES");
            System.out.println(" ");
            System.out.println("trip categories: {} " + tripDto.getCategoryIds());
            System.out.println(" ");
            Set<TripCategory> tripCategories = tripMapperHelper.mapCategoriesFromIds(tripDto.getCategoryIds(), finalTrip);
            tripCategories.forEach(acc -> 
                acc.setTrip(finalTrip)
            );
            tripCategories = new HashSet<>(tripCategoryRepository.saveAll(tripCategories));
            trip.setTripCategories(tripCategories);
        }

        if (tripDto.getLanguageSpokenIds() != null) {
            System.out.println(" ");
            System.out.println("TRIP_CATEGORIES");
            System.out.println(" ");
            System.out.println("trip categories: {} " + tripDto.getLanguageSpokenIds());
            System.out.println(" ");
            Set<TripLanguageSpoken> tripLanguageSpokens = tripMapperHelper.mapLanguagesSpokenFromIds(tripDto.getLanguageSpokenIds(), finalTrip);
            tripLanguageSpokens.forEach(acc -> 
                acc.setTrip(finalTrip)
            );
            tripLanguageSpokens = new HashSet<>(tripLanguageSpokenRepository.saveAll(tripLanguageSpokens));
            trip.setTripLanguagesSpoken(tripLanguageSpokens);
        }

        return tripMapper.toDto(tripRepository.save(trip));
    }

    public Trip getTripById(Long id) {
        return tripRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Trip not found with id: " + id));
    }
}