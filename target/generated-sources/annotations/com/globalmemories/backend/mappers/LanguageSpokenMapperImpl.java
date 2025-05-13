package com.globalmemories.backend.mappers;

import com.globalmemories.backend.dtos.LanguageSpokenDto;
import com.globalmemories.backend.entites.LanguageSpoken;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-09T18:12:45+0100",
    comments = "version: 1.5.3.Final, compiler: Eclipse JDT (IDE) 3.42.0.z20250331-1358, environment: Java 21.0.6 (Eclipse Adoptium)"
)
@Component
public class LanguageSpokenMapperImpl implements LanguageSpokenMapper {

    @Override
    public LanguageSpokenDto toDto(LanguageSpoken languageSpoken) {
        if ( languageSpoken == null ) {
            return null;
        }

        LanguageSpokenDto.LanguageSpokenDtoBuilder languageSpokenDto = LanguageSpokenDto.builder();

        languageSpokenDto.id( languageSpoken.getId() );
        languageSpokenDto.name( languageSpoken.getName() );

        return languageSpokenDto.build();
    }

    @Override
    public LanguageSpoken toEntity(LanguageSpokenDto languageSpokenDto) {
        if ( languageSpokenDto == null ) {
            return null;
        }

        LanguageSpoken.LanguageSpokenBuilder languageSpoken = LanguageSpoken.builder();

        languageSpoken.id( languageSpokenDto.getId() );
        languageSpoken.name( languageSpokenDto.getName() );

        return languageSpoken.build();
    }

    @Override
    public List<LanguageSpokenDto> toDtoList(List<LanguageSpoken> languageSpokens) {
        if ( languageSpokens == null ) {
            return null;
        }

        List<LanguageSpokenDto> list = new ArrayList<LanguageSpokenDto>( languageSpokens.size() );
        for ( LanguageSpoken languageSpoken : languageSpokens ) {
            list.add( toDto( languageSpoken ) );
        }

        return list;
    }
}
