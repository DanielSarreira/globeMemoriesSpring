package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.entites.Country;
import com.globalmemories.backend.entites.User;
import com.globalmemories.backend.entites.trip.Trip;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-09T19:14:38+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class TripMapperImpl implements TripMapper {

    @Autowired
    private TripMapperHelper tripMapperHelper;

    @Override
    public TripDto toDto(Trip trip) {
        if ( trip == null ) {
            return null;
        }

        TripDto.TripDtoBuilder tripDto = TripDto.builder();

        tripDto.userId( tripUserId( trip ) );
        tripDto.countryId( tripCountryId( trip ) );
        tripDto.countryName( tripCountryName( trip ) );
        tripDto.categoryIds( tripMapperHelper.mapCategoriesToIds( trip.getTripCategories() ) );
        tripDto.categoryNames( mapCategoriesToNames( trip.getTripCategories() ) );
        tripDto.negativePoints( mapNegativePoints( trip.getNegativePoints() ) );
        tripDto.recommendedFoods( mapRecommendedFoods( trip.getRecommendedFoods() ) );
        tripDto.referencePoints( mapReferencePoints( trip.getReferencePoints() ) );
        tripDto.tripTransports( mapTripTransports( trip.getTripTransports() ) );
        tripDto.languageSpokenIds( tripMapperHelper.mapLanguagesSpokenToIds( trip.getTripLanguagesSpoken() ) );
        tripDto.languageSpokenNames( mapLanguagesSpokenToNames( trip.getTripLanguagesSpoken() ) );
        tripDto.accommodations( tripMapperHelper.mapAccommodations( trip.getAccommodations() ) );
        tripDto.cost( mapCostToDto( trip.getCost() ) );
        tripDto.tripItinerary( mapTripItineraryToDto( trip.getTripItinerary() ) );
        tripDto.bookingDate( trip.getBookingDate() );
        tripDto.city( trip.getCity() );
        tripDto.endDate( trip.getEndDate() );
        tripDto.id( trip.getId() );
        tripDto.startDate( trip.getStartDate() );
        tripDto.title( trip.getTitle() );
        tripDto.tripDescription( trip.getTripDescription() );
        tripDto.tripDurationDays( trip.getTripDurationDays() );
        tripDto.tripRating( trip.getTripRating() );
        tripDto.tripSummary( trip.getTripSummary() );
        tripDto.weather( trip.getWeather() );

        return tripDto.build();
    }

    @Override
    public Trip toEntity(TripDto tripDto, Trip trip) {
        if ( tripDto == null ) {
            return null;
        }

        Trip.TripBuilder trip1 = Trip.builder();

        trip1.user( tripMapperHelper.mapUserFromId( tripDto.getUserId() ) );
        trip1.country( tripMapperHelper.mapCountryFromId( tripDto.getCountryId() ) );
        trip1.tripCategories( tripMapperHelper.mapCategoriesFromIds( tripDto.getCategoryIds(), trip ) );
        trip1.negativePoints( mapNegativePointsFromDto( tripDto.getNegativePoints(), trip ) );
        trip1.recommendedFoods( mapRecommendedFoodsFromDto( tripDto.getRecommendedFoods(), trip ) );
        trip1.referencePoints( mapReferencePointsFromDto( tripDto.getReferencePoints(), trip ) );
        trip1.tripTransports( mapTripTransportsFromDto( tripDto.getTripTransports(), trip ) );
        trip1.tripLanguagesSpoken( tripMapperHelper.mapLanguagesSpokenFromIds( tripDto.getLanguageSpokenIds(), trip ) );
        trip1.accommodations( tripMapperHelper.mapAccommodationsFromDto( tripDto.getAccommodations(), trip ) );
        trip1.cost( mapCostFromDto( tripDto.getCost() ) );
        trip1.tripItinerary( mapTripItineraryFromDto( tripDto.getTripItinerary(), trip ) );
        trip1.startDate( tripDto.getStartDate() );
        trip1.endDate( tripDto.getEndDate() );
        trip1.tripDurationDays( tripDto.getTripDurationDays() );
        trip1.title( tripDto.getTitle() );
        trip1.tripSummary( tripDto.getTripSummary() );
        trip1.tripDescription( tripDto.getTripDescription() );
        trip1.weather( tripDto.getWeather() );
        trip1.tripRating( tripDto.getTripRating() );
        trip1.bookingDate( tripDto.getBookingDate() );
        trip1.city( tripDto.getCity() );
        trip1.id( tripDto.getId() );

        return trip1.build();
    }

    private Long tripUserId(Trip trip) {
        if ( trip == null ) {
            return null;
        }
        User user = trip.getUser();
        if ( user == null ) {
            return null;
        }
        Long id = user.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long tripCountryId(Trip trip) {
        if ( trip == null ) {
            return null;
        }
        Country country = trip.getCountry();
        if ( country == null ) {
            return null;
        }
        Long id = country.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String tripCountryName(Trip trip) {
        if ( trip == null ) {
            return null;
        }
        Country country = trip.getCountry();
        if ( country == null ) {
            return null;
        }
        String name = country.getName();
        if ( name == null ) {
            return null;
        }
        return name;
    }
}
