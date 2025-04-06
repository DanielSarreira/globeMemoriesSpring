package com.globalmemories.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.globalmemories.backend.dtos.trip.TransportDto;
import com.globalmemories.backend.entites.trip.Transport;

@Mapper(componentModel = "spring")
public interface TransportMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    TransportDto toDto(Transport transport);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    Transport toEntity(TransportDto transportDto);

    List<TransportDto> toDtoList(List<Transport> transports);

}