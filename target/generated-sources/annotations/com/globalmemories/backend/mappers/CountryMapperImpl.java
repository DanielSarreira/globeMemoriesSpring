package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.CountryDto;
import com.globalmemories.backend.entites.Country;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-06-26T22:36:26+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.v20250514-1000, environment: Java 21.0.7 (Eclipse Adoptium)"
)
@Component
public class CountryMapperImpl implements CountryMapper {

    @Override
    public CountryDto toDto(Country country) {
        if ( country == null ) {
            return null;
        }

        CountryDto.CountryDtoBuilder countryDto = CountryDto.builder();

        countryDto.id( country.getId() );
        countryDto.name( country.getName() );

        return countryDto.build();
    }

    @Override
    public Country toEntity(CountryDto countryDto) {
        if ( countryDto == null ) {
            return null;
        }

        Country.CountryBuilder country = Country.builder();

        country.id( countryDto.getId() );
        country.name( countryDto.getName() );

        return country.build();
    }

    @Override
    public List<CountryDto> toDtoList(List<Country> countries) {
        if ( countries == null ) {
            return null;
        }

        List<CountryDto> list = new ArrayList<CountryDto>( countries.size() );
        for ( Country country : countries ) {
            list.add( toDto( country ) );
        }

        return list;
    }
}
