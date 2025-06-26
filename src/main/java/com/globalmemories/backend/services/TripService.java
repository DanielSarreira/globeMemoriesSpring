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
    private TripItineraryRepository tripItineraryRepository;
    @Autowired
    private NegativePointRepository negativePointRepository;
    @Autowired
    private RecommendedFoodRepository recommendedFoodRepository;
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

        System.out.println(" ");
        System.out.println("TRIP");
        System.out.println(" ");
        System.out.println("trip {} " + tripDto);
        System.out.println(" ");
        
        trip.setNegativePoints(null);
        trip.setRecommendedFoods(null);
        trip.setReferencePoints(null);
        trip.setTripTransports(null);
        trip.setAccommodations(null);
        trip.setTripCategories(null);
        trip.setTripLanguagesSpoken(null);
        trip.setTripItinerary(null);
        
        try {
            trip = tripRepository.save(trip); // Save to get ID
        } catch (Exception e) {
            System.out.println("ERROR IN TRY CATCH: " + e.getMessage());
        }
        

        final Trip finalTrip = trip;      // Final reference for lambdas

        if (tripDto.getCost() != null) {
            Cost cost = tripMapper.mapCostFromDto(tripDto.getCost());
            cost.setTrip(finalTrip);
            cost = costRepository.save(cost);
            trip.setCost(cost);
        }

        // Save TripItinerary
        if (tripDto.getTripItinerary() != null) {
            TripItinerary tripItinerary = new TripItinerary();
            tripItinerary.setTrip(finalTrip);

            System.out.println(" ");
            System.out.println("TRIP_ITINERARY");
            System.out.println(" ");
            System.out.println("trip itinerary: {} " + tripDto.getTripItinerary());
            System.out.println(" ");

            // Save the TripItinerary first to generate its ID
            TripItinerary savedTripItinerary = tripItineraryRepository.save(tripItinerary);

            List<ItineraryDay> itineraryDays = tripDto.getTripItinerary().getItineraryDays().stream()
            .map(dayDto -> {
                ItineraryDay day = new ItineraryDay();
                day.setDay(dayDto.getDay());
                day.setTripItinerary(savedTripItinerary); // Associate with the saved TripItinerary

                List<ItineraryDayTopic> topics = dayDto.getTopics().stream()
                        .map(topicDto -> {
                            ItineraryDayTopic topic = new ItineraryDayTopic();
                            topic.setName(topicDto.getName());
                            topic.setDescription(topicDto.getDescription());
                            topic.setItineraryDay(day); // Associate with the ItineraryDay
                            return topic;
                        }).collect(Collectors.toList());

                day.setTopics(topics);
                return day;
            }).collect(Collectors.toList());

            savedTripItinerary.setItineraryDays(itineraryDays);
            tripItineraryRepository.save(savedTripItinerary);
            trip.setTripItinerary(savedTripItinerary);
        }

        if (tripDto.getNegativePoints() != null) {
            List<NegativePoint> negativePoints = tripMapper.mapNegativePointsFromDto(tripDto.getNegativePoints(), finalTrip);
            negativePoints.forEach(rp -> rp.setTrip(finalTrip));
            negativePoints = negativePointRepository.saveAll(negativePoints);
            trip.setNegativePoints(negativePoints);
        }

        if (tripDto.getRecommendedFoods() != null) {
            List<RecommendedFood> recommendedFoods = tripMapper.mapRecommendedFoodsFromDto(tripDto.getRecommendedFoods(), finalTrip);
            recommendedFoods.forEach(rp -> rp.setTrip(finalTrip));
            recommendedFoods = recommendedFoodRepository.saveAll(recommendedFoods);
            trip.setRecommendedFoods(recommendedFoods);
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
                    Transport transport = transportRepository.findById(transportId)
                            .orElseThrow(() -> new RuntimeException("Transport not found with id: " + transportId));
                    tt.setTrip(trip);
                    tt.setTransport(transport);
                    tt.setId(new TripTransportId(trip.getId(), transport.getId(), i)); // Use loop index as sequence_number
                }
                tripTransports = tripTransportRepository.saveAll(tripTransports); // Save all TripTransport objects
                trip.setTripTransports(tripTransports); // Set the saved objects back to the trip
            } catch (Exception e) {
                e.printStackTrace(); // Log the exception for debugging
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

        if (tripDto.getCategories() != null) {
            System.out.println(" ");
            System.out.println("TRIP_CATEGORIES");
            System.out.println(" ");
            System.out.println("trip categories: {} " + tripDto.getCategories());
            System.out.println(" ");
            Set<TripCategory> tripCategories = tripMapperHelper.mapCategoriesFromIds(tripDto.getCategories(), finalTrip);
            tripCategories.forEach(acc -> 
                acc.setTrip(finalTrip)
            );
            tripCategories = new HashSet<>(tripCategoryRepository.saveAll(tripCategories));
            trip.setTripCategories(tripCategories);
        }

        if (tripDto.getLanguagesSpoken() != null) {
            System.out.println(" ");
            System.out.println("TRIP_CATEGORIES");
            System.out.println(" ");
            System.out.println("trip categories: {} " + tripDto.getLanguagesSpoken());
            System.out.println(" ");
            Set<TripLanguageSpoken> tripLanguageSpokens = tripMapperHelper.mapLanguagesSpokenFromIds(tripDto.getLanguagesSpoken(), finalTrip);
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