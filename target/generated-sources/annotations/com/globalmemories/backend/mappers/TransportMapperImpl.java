package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.trip.TransportDto;
import com.globalmemories.backend.entites.trip.Transport;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-29T16:50:22+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.50.v20250729-0351, environment: Java 21.0.8 (Eclipse Adoptium)"
)
@Component
public class TransportMapperImpl implements TransportMapper {

    @Override
    public TransportDto toDto(Transport transport) {
        if ( transport == null ) {
            return null;
        }

        TransportDto.TransportDtoBuilder transportDto = TransportDto.builder();

        transportDto.id( transport.getId() );
        transportDto.name( transport.getName() );

        return transportDto.build();
    }

    @Override
    public Transport toEntity(TransportDto transportDto) {
        if ( transportDto == null ) {
            return null;
        }

        Transport.TransportBuilder transport = Transport.builder();

        transport.id( transportDto.getId() );
        transport.name( transportDto.getName() );

        return transport.build();
    }

    @Override
    public List<TransportDto> toDtoList(List<Transport> transports) {
        if ( transports == null ) {
            return null;
        }

        List<TransportDto> list = new ArrayList<TransportDto>( transports.size() );
        for ( Transport transport : transports ) {
            list.add( toDto( transport ) );
        }

        return list;
    }
}
