package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.trip.AccommodationBoardDto;
import com.globalmemories.backend.entites.trip.AccommodationBoard;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-17T00:07:07+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.43.0.v20250819-1513, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class AccommodationBoardMapperImpl implements AccommodationBoardMapper {

    @Override
    public AccommodationBoardDto toDto(AccommodationBoard accommodationBoard) {
        if ( accommodationBoard == null ) {
            return null;
        }

        AccommodationBoardDto.AccommodationBoardDtoBuilder accommodationBoardDto = AccommodationBoardDto.builder();

        accommodationBoardDto.id( accommodationBoard.getId() );
        accommodationBoardDto.board( accommodationBoard.getBoard() );

        return accommodationBoardDto.build();
    }

    @Override
    public AccommodationBoard toEntity(AccommodationBoardDto accommodationBoardDto) {
        if ( accommodationBoardDto == null ) {
            return null;
        }

        AccommodationBoard.AccommodationBoardBuilder accommodationBoard = AccommodationBoard.builder();

        accommodationBoard.id( accommodationBoardDto.getId() );
        accommodationBoard.board( accommodationBoardDto.getBoard() );

        return accommodationBoard.build();
    }

    @Override
    public List<AccommodationBoardDto> toDtoList(List<AccommodationBoard> accommodationBoards) {
        if ( accommodationBoards == null ) {
            return null;
        }

        List<AccommodationBoardDto> list = new ArrayList<AccommodationBoardDto>( accommodationBoards.size() );
        for ( AccommodationBoard accommodationBoard : accommodationBoards ) {
            list.add( toDto( accommodationBoard ) );
        }

        return list;
    }
}
