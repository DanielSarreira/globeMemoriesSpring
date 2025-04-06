package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.trip.AccommodationTypeDto;
import com.globalmemories.backend.entites.trip.AccommodationType;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-04-04T19:02:54+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class AccommodationTypeMapperImpl implements AccommodationTypeMapper {

    @Override
    public AccommodationTypeDto toDto(AccommodationType accommodationType) {
        if ( accommodationType == null ) {
            return null;
        }

        AccommodationTypeDto.AccommodationTypeDtoBuilder accommodationTypeDto = AccommodationTypeDto.builder();

        accommodationTypeDto.id( accommodationType.getId() );
        accommodationTypeDto.type( accommodationType.getType() );

        return accommodationTypeDto.build();
    }

    @Override
    public AccommodationType toEntity(AccommodationTypeDto accommodationTypeDto) {
        if ( accommodationTypeDto == null ) {
            return null;
        }

        AccommodationType.AccommodationTypeBuilder accommodationType = AccommodationType.builder();

        accommodationType.id( accommodationTypeDto.getId() );
        accommodationType.type( accommodationTypeDto.getType() );

        return accommodationType.build();
    }

    @Override
    public List<AccommodationTypeDto> toDtoList(List<AccommodationType> accommodationTypes) {
        if ( accommodationTypes == null ) {
            return null;
        }

        List<AccommodationTypeDto> list = new ArrayList<AccommodationTypeDto>( accommodationTypes.size() );
        for ( AccommodationType accommodationType : accommodationTypes ) {
            list.add( toDto( accommodationType ) );
        }

        return list;
    }
}
