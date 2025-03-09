package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.entites.trip.Trip;
import com.globalmemories.backend.entites.trip.TripCategory;
import com.globalmemories.backend.entites.trip.TripReferencePoint;
import com.globalmemories.backend.entites.trip.TripTransport;
import com.globalmemories.backend.entites.trip.TripLanguageSpoken;
import com.globalmemories.backend.entites.trip.Accommodation;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.Set;
import java.util.List;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TripMapper {

    @Mapping(source = "country.name", target = "countryName")
    @Mapping(source = "tripCategories", target = "tripCategories", qualifiedByName = "mapTripCategories")
    @Mapping(source = "referencePoints", target = "referencePoints", qualifiedByName = "mapReferencePoints")
    @Mapping(source = "tripTransports", target = "tripTransports", qualifiedByName = "mapTripTransports")
    @Mapping(source = "tripLanguagesSpoken", target = "tripLanguagesSpoken", qualifiedByName = "mapTripLanguagesSpoken")
    @Mapping(source = "accommodations", target = "accommodations", qualifiedByName = "mapAccommodations")
    TripDto toTripDto(Trip trip);

    @Named("mapTripCategories")
    default List<String> mapTripCategories(Set<TripCategory> tripCategories) {
        return tripCategories.stream().map(TripCategory::toString).collect(Collectors.toList());
    }

    @Named("mapReferencePoints")
    default List<String> mapReferencePoints(List<TripReferencePoint> referencePoints) {
        return referencePoints.stream().map(TripReferencePoint::toString).collect(Collectors.toList());
    }

    @Named("mapTripTransports")
    default List<String> mapTripTransports(List<TripTransport> tripTransports) {
        return tripTransports.stream().map(TripTransport::toString).collect(Collectors.toList());
    }

    @Named("mapTripLanguagesSpoken")
    default List<String> mapTripLanguagesSpoken(List<TripLanguageSpoken> tripLanguagesSpoken) {
        return tripLanguagesSpoken.stream().map(TripLanguageSpoken::toString).collect(Collectors.toList());
    }

    @Named("mapAccommodations")
    default List<String> mapAccommodations(List<Accommodation> accommodations) {
        return accommodations.stream().map(Accommodation::toString).collect(Collectors.toList());
    }
}