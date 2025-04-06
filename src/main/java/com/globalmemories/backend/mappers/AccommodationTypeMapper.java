package com.globalmemories.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.globalmemories.backend.dtos.trip.AccommodationTypeDto;
import com.globalmemories.backend.entites.trip.AccommodationType;

@Mapper(componentModel = "spring")
public interface AccommodationTypeMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "type", target = "type")
    AccommodationTypeDto toDto(AccommodationType accommodationType);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "type", target = "type")
    AccommodationType toEntity(AccommodationTypeDto accommodationTypeDto);

    List<AccommodationTypeDto> toDtoList(List<AccommodationType> accommodationTypes);
}