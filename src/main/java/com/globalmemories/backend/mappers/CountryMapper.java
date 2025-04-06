package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.CountryDto;
import com.globalmemories.backend.entites.Country;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CountryMapper {

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    CountryDto toDto(Country country);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Country toEntity(CountryDto countryDto);

    List<CountryDto> toDtoList(List<Country> countries);
}