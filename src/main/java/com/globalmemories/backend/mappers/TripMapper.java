package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.trip.*;
import com.globalmemories.backend.entites.trip.*;

import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring", uses = {TripMapperHelper.class})
public interface TripMapper {

    @Mapping(source = "user.id", target = "userId")
    @Mapping(source = "country.id", target = "countryId")
    @Mapping(source = "country.name", target = "countryName") // Map countryName
    @Mapping(target = "categoryIds", source = "tripCategories", qualifiedByName = "mapCategoriesToIds")
    @Mapping(target = "categoryNames", source = "tripCategories", qualifiedByName = "mapCategoriesToNames") // Map categoryNames
    @Mapping(source = "negativePoints", target = "negativePoints", qualifiedByName = "mapNegativePoints")
    @Mapping(source = "recommendedFoods", target = "recommendedFoods", qualifiedByName = "mapRecommendedFoods")
    @Mapping(source = "referencePoints", target = "referencePoints", qualifiedByName = "mapReferencePoints")
    @Mapping(source = "tripTransports", target = "tripTransports", qualifiedByName = "mapTripTransports")
    @Mapping(target = "languageSpokenIds", source = "tripLanguagesSpoken", qualifiedByName = "mapLanguagesSpokenToIds")
    @Mapping(target = "languageSpokenNames", source = "tripLanguagesSpoken", qualifiedByName = "mapLanguagesSpokenToNames") // Map languageSpokenNames
    @Mapping(source = "accommodations", target = "accommodations", qualifiedByName = "mapAccommodations")
    @Mapping(source = "cost", target = "cost", qualifiedByName = "mapCostToDto")
    @Mapping(source = "tripItinerary", target = "tripItinerary", qualifiedByName = "mapTripItineraryToDto")
    TripDto toDto(Trip trip);

    @Mapping(target = "user", source = "userId", qualifiedByName = "mapUserFromId")
    @Mapping(target = "country", source = "countryId", qualifiedByName = "mapCountryFromId")
    @Mapping(target = "tripCategories", source = "categoryIds", qualifiedByName = "mapCategoriesFromIds")
    @Mapping(target = "negativePoints", source = "negativePoints", qualifiedByName = "mapNegativePointsFromDto")
    @Mapping(target = "recommendedFoods", source = "recommendedFoods", qualifiedByName = "mapRecommendedFoodsFromDto")
    @Mapping(target = "referencePoints", source = "referencePoints", qualifiedByName = "mapReferencePointsFromDto")
    @Mapping(target = "tripTransports", source = "tripTransports", qualifiedByName = "mapTripTransportsFromDto")
    @Mapping(target = "tripLanguagesSpoken", source = "languageSpokenIds", qualifiedByName = "mapLanguagesSpokenFromIds")
    @Mapping(source = "accommodations", target = "accommodations", qualifiedByName = "mapAccommodationsFromDto")
    @Mapping(source = "cost", target = "cost", qualifiedByName = "mapCostFromDto")
    @Mapping(source = "tripItinerary", target = "tripItinerary", qualifiedByName = "mapTripItineraryFromDto")
    @Mapping(source = "startDate", target = "startDate")
    @Mapping(source = "endDate", target = "endDate")
    @Mapping(source = "tripDurationDays", target = "tripDurationDays")
    @Mapping(source = "title", target = "title")
    @Mapping(source = "tripSummary", target = "tripSummary")
    @Mapping(source = "tripDescription", target = "tripDescription")
    @Mapping(source = "weather", target = "weather")
    @Mapping(source = "tripRating", target = "tripRating")
    Trip toEntity(TripDto tripDto, @Context Trip trip);

    // Convenience method for creation
    default Trip toEntity(TripDto tripDto) {
        Trip trip = new Trip();
        return toEntity(tripDto, trip);
    }

    @Named("mapCategoriesToNames")
    default Set<String> mapCategoriesToNames(Set<TripCategory> tripCategories) {
        if (tripCategories == null) return null;
        return tripCategories.stream()
                .map(tc -> tc.getCategory().getName())
                .collect(Collectors.toSet());
    }

    @Named("mapLanguagesSpokenToNames")
    default Set<String> mapLanguagesSpokenToNames(Set<TripLanguageSpoken> tripLanguagesSpoken) {
        if (tripLanguagesSpoken == null) return null;
        return tripLanguagesSpoken.stream()
                .map(ls -> ls.getLanguageSpoken().getName())
                .collect(Collectors.toSet());
    }

    @Named("mapNegativePoints")
    default List<NegativePointDto> mapNegativePoints(List<NegativePoint> negativePoints) {
        if (negativePoints == null) return null;
        return negativePoints.stream()
                .map(np -> new NegativePointDto(
                    np.getId(), np.getName(), np.getDescription(), np.getTrip().getId()))
                .collect(Collectors.toList());
    }

    @Named("mapNegativePointsFromDto")
    default List<NegativePoint> mapNegativePointsFromDto(List<NegativePointDto> negativePointsDto, @Context Trip trip) {
        if (negativePointsDto == null) return null;
        return negativePointsDto.stream()
                .map(dto -> new NegativePoint(dto.getId(), dto.getName(), dto.getDescription(), trip))
                .collect(Collectors.toList());
    }

    @Named("mapRecommendedFoods")
    default List<RecommendedFoodDto> mapRecommendedFoods(List<RecommendedFood> recommendedFoods) {
        if (recommendedFoods == null) return null;
        return recommendedFoods.stream()
                .map(rf -> new RecommendedFoodDto(
                        rf.getId(), rf.getName(), rf.getDescription(), rf.getPhotos(), rf.getTrip().getId()))
                .collect(Collectors.toList());
    }

    @Named("mapRecommendedFoodsFromDto")
    default List<RecommendedFood> mapRecommendedFoodsFromDto(List<RecommendedFoodDto> recommendedFoodsDto, @Context Trip trip) {
        if (recommendedFoodsDto == null) return null;
        return recommendedFoodsDto.stream()
                .map(dto -> new RecommendedFood(dto.getId(), dto.getName(), dto.getDescription(), dto.getPhotos(), trip))
                .collect(Collectors.toList());
    }

    @Named("mapReferencePoints")
    default List<TripReferencePointDto> mapReferencePoints(List<TripReferencePoint> referencePoints) {
        if (referencePoints == null) return null;
        return referencePoints.stream()
                .map(rp -> new TripReferencePointDto(
                        rp.getId(), rp.getName(), rp.getDescription(), rp.getPhotos(), rp.getTrip().getId()))
                .collect(Collectors.toList());
    }

    @Named("mapReferencePointsFromDto")
    default List<TripReferencePoint> mapReferencePointsFromDto(List<TripReferencePointDto> referencePointDtos, @Context Trip trip) {
        if (referencePointDtos == null) return null;
        return referencePointDtos.stream()
                .map(dto -> new TripReferencePoint(dto.getId(), dto.getName(), dto.getDescription(), dto.getPhotos(), trip))
                .collect(Collectors.toList());
    }

    @Named("mapTripTransports")
    default List<TripTransportDto> mapTripTransports(List<TripTransport> tripTransports) {
        if (tripTransports == null) return null;
        return tripTransports.stream()
                .map(tt -> new TripTransportDto(tt.getTransport().getId(), tt.getCost(), tt.getDescription(), tt.getPhotos()))
                .collect(Collectors.toList());
    }

    @Named("mapTripTransportsFromDto")
    default List<TripTransport> mapTripTransportsFromDto(List<TripTransportDto> transportDtos, @Context Trip trip) {
        if (transportDtos == null) return null;
        return transportDtos.stream()
                .map(dto -> {
                    TripTransport tripTransport = new TripTransport();
                    tripTransport.setTrip(trip);
                    tripTransport.setCost(dto.getCost());
                    tripTransport.setDescription(dto.getDescription());
                    tripTransport.setPhotos(dto.getPhotos());
                    return tripTransport;
                })
                .collect(Collectors.toList());
    }

    @Named("mapCostToDto")
    default CostDto mapCostToDto(Cost cost) {
        if (cost == null) return null;
        return CostDto.builder()
                .id(cost.getId())
                .total(cost.getTotal())
                .accommodation(cost.getAccommodation())
                .food(cost.getFood())
                .transport(cost.getTransport())
                .extra(cost.getExtra())
                .tripId(cost.getTrip() != null ? cost.getTrip().getId() : null)
                .build();
    }

    @Named("mapCostFromDto")
    default Cost mapCostFromDto(CostDto costDto) {
        if (costDto == null) return null;
        Cost cost = new Cost();
        cost.setId(costDto.getId());
        cost.setTotal(costDto.getTotal());
        cost.setAccommodation(costDto.getAccommodation());
        cost.setFood(costDto.getFood());
        cost.setTransport(costDto.getTransport());
        cost.setExtra(costDto.getExtra());
        return cost;
    }

    @Named("mapTripItineraryToDto")
    default TripItineraryDto mapTripItineraryToDto(TripItinerary tripItinerary) {
        if (tripItinerary == null) return null;

        return TripItineraryDto.builder()
                .id(tripItinerary.getId())
                .itineraryDays(tripItinerary.getItineraryDays().stream()
                        .map(day -> ItineraryDayDto.builder()
                                .id(day.getId())
                                .day(day.getDay())
                                .topics(day.getTopics().stream()
                                        .map(topic -> ItineraryDayTopicDto.builder()
                                                .id(topic.getId())
                                                .name(topic.getName())
                                                .description(topic.getDescription())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())
                        .collect(Collectors.toList()))
                .build();
    }

    @Named("mapTripItineraryFromDto")
    default TripItinerary mapTripItineraryFromDto(TripItineraryDto itineraryDto, @Context Trip trip) {
        if (itineraryDto == null) return null;

        TripItinerary tripItinerary = new TripItinerary();
        tripItinerary.setTrip(trip);

        List<ItineraryDay> itineraryDays = itineraryDto.getItineraryDays().stream()
                .map(dayDto -> {
                    ItineraryDay day = new ItineraryDay();
                    day.setDay(dayDto.getDay());
                    day.setTripItinerary(tripItinerary);

                    List<ItineraryDayTopic> topics = dayDto.getTopics().stream()
                            .map(topicDto -> {
                                ItineraryDayTopic topic = new ItineraryDayTopic();
                                topic.setName(topicDto.getName());
                                topic.setDescription(topicDto.getDescription());
                                topic.setItineraryDay(day);
                                return topic;
                            }).collect(Collectors.toList());

                    day.setTopics(topics);
                    return day;
                }).collect(Collectors.toList());

        tripItinerary.setItineraryDays(itineraryDays);
        return tripItinerary;
    }
}