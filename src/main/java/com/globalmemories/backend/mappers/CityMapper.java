package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.CityDto;
import com.globalmemories.backend.entites.City;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CityMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "cityName", target = "cityName")
    @Mapping(source = "countryName", target = "countryName")
    CityDto toDto(City city);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "cityName", target = "cityName")
    @Mapping(source = "countryName", target = "countryName")
    City toEntity(CityDto cityDto);

    List<CityDto> toDtoList(List<City> cities);
}