package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.trip.TripDto;
import com.globalmemories.backend.entites.Country;
import com.globalmemories.backend.entites.trip.Trip;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-03-07T18:27:04+0000",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.41.0.z20250213-2037, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class TripMapperImpl implements TripMapper {

    @Override
    public TripDto toTripDto(Trip trip) {
        if ( trip == null ) {
            return null;
        }

        TripDto.TripDtoBuilder tripDto = TripDto.builder();

        tripDto.countryName( tripCountryName( trip ) );
        tripDto.tripCategories( mapTripCategories( trip.getTripCategories() ) );
        tripDto.referencePoints( mapReferencePoints( trip.getReferencePoints() ) );
        tripDto.tripTransports( mapTripTransports( trip.getTripTransports() ) );
        tripDto.tripLanguagesSpoken( mapTripLanguagesSpoken( trip.getTripLanguagesSpoken() ) );
        tripDto.accommodations( mapAccommodations( trip.getAccommodations() ) );
        tripDto.id( trip.getId() );
        tripDto.title( trip.getTitle() );
        tripDto.tripDescription( trip.getTripDescription() );
        tripDto.tripDurationDays( trip.getTripDurationDays() );
        tripDto.tripRating( trip.getTripRating() );

        return tripDto.build();
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
