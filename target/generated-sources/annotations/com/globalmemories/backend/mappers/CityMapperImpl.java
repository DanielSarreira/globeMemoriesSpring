package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.CityDto;
import com.globalmemories.backend.entites.City;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-17T00:07:06+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class CityMapperImpl implements CityMapper {

    @Override
    public CityDto toDto(City city) {
        if ( city == null ) {
            return null;
        }

        CityDto.CityDtoBuilder cityDto = CityDto.builder();

        cityDto.id( city.getId() );
        cityDto.cityName( city.getCityName() );
        cityDto.countryName( city.getCountryName() );

        return cityDto.build();
    }

    @Override
    public City toEntity(CityDto cityDto) {
        if ( cityDto == null ) {
            return null;
        }

        City.CityBuilder city = City.builder();

        city.id( cityDto.getId() );
        city.cityName( cityDto.getCityName() );
        city.countryName( cityDto.getCountryName() );

        return city.build();
    }

    @Override
    public List<CityDto> toDtoList(List<City> cities) {
        if ( cities == null ) {
            return null;
        }

        List<CityDto> list = new ArrayList<CityDto>( cities.size() );
        for ( City city : cities ) {
            list.add( toDto( city ) );
        }

        return list;
    }
}
