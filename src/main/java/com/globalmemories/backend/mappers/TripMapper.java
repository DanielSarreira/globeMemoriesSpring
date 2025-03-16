package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.trip.*;
import com.globalmemories.backend.entites.trip.*;
import com.globalmemories.backend.entites.Country;
import com.globalmemories.backend.entites.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Mapper(componentModel = "spring")
public interface TripMapper {

    @Mapping(source = "country.name", target = "countryName")
    @Mapping(source = "tripCategories", target = "tripCategories", qualifiedByName = "mapCategories")
    @Mapping(source = "referencePoints", target = "referencePoints", qualifiedByName = "mapReferencePoints")
    @Mapping(source = "tripTransports", target = "tripTransports", qualifiedByName = "mapTransports")
    @Mapping(source = "tripLanguagesSpoken", target = "tripLanguagesSpoken", qualifiedByName = "mapLanguages")
    @Mapping(source = "accommodations", target = "accommodations", qualifiedByName = "mapAccommodations")
    TripDto toDto(Trip trip);

    @Mapping(source = "countryName", target = "country.name")
    @Mapping(target = "user", ignore = true) // You will set user explicitly in service layer
    @Mapping(target = "tripCategories", ignore = true) // You can map this separately in the service layer
    @Mapping(target = "referencePoints", ignore = true) // Map this separately in service layer
    @Mapping(target = "tripTransports", ignore = true) // Map this separately in service layer
    @Mapping(target = "tripLanguagesSpoken", ignore = true) // Map this separately in service layer
    @Mapping(target = "accommodations", ignore = true) // Map this separately in service layer
    Trip toEntity(TripDto tripDto);

    @Named("mapCategories")
    default List<TripCategoryDto> mapCategories(Set<TripCategory> categories) {
        return categories.stream()
                .map(c -> new TripCategoryDto(c.getTrip().getId(), c.getCategory().getId(), c.getTrip().getTitle(), c.getCategory().getName()))
                .collect(Collectors.toList());
    }

    @Named("mapReferencePoints")
    default List<TripReferencePointDto> mapReferencePoints(List<TripReferencePoint> referencePoints) {
        return referencePoints.stream()
                .map(rp -> new TripReferencePointDto(rp.getId(), rp.getName(), rp.getDescription(), rp.getPhotos(), rp.getTrip().getId()))
                .collect(Collectors.toList());
    }

    @Named("mapTransports")
    default List<TripTransportDto> mapTransports(List<TripTransport> transports) {
        return transports.stream()
                .map(tt -> new TripTransportDto(tt.getId(), tt.getTrip().getId(), tt.getTransport().getId(), tt.getCost()))
                .collect(Collectors.toList());
    }

    @Named("mapLanguages")
    default List<TripLanguageSpokenDto> mapLanguages(List<TripLanguageSpoken> languages) {
        return languages.stream()
                .map(tl -> new TripLanguageSpokenDto(tl.getId(), tl.getTrip().getId(), tl.getLanguageSpoken().getId(), tl.getTrip().getTitle(), tl.getLanguageSpoken().getName()))
                .collect(Collectors.toList());
    }

    @Named("mapAccommodations")
    default List<AccommodationDto> mapAccommodations(List<Accommodation> accommodations) {
        return accommodations.stream()
                .map(acc -> new AccommodationDto(acc.getId(), acc.getName(), acc.getPrice(), acc.getNrOfNights(), acc.getDescription(), acc.getRating(), acc.getTrip().getId()))
                .collect(Collectors.toList());
    }
}