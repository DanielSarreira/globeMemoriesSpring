package com.globalmemories.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.globalmemories.backend.dtos.trip.AccommodationBoardDto;
import com.globalmemories.backend.entites.trip.AccommodationBoard;

@Mapper(componentModel = "spring")
public interface AccommodationBoardMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "board", target = "board")
    AccommodationBoardDto toDto(AccommodationBoard accommodationBoard);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "board", target = "board")
    AccommodationBoard toEntity(AccommodationBoardDto accommodationBoardDto);

    List<AccommodationBoardDto> toDtoList(List<AccommodationBoard> accommodationBoards);
}