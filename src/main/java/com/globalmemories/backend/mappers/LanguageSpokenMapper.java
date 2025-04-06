package com.globalmemories.backend.mappers;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.globalmemories.backend.dtos.LanguageSpokenDto;
import com.globalmemories.backend.entites.LanguageSpoken;

@Mapper(componentModel = "spring")
public interface LanguageSpokenMapper {
    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    LanguageSpokenDto toDto(LanguageSpoken languageSpoken);

    @Mapping(source = "id", target = "id")
    @Mapping(source = "name", target = "name")
    LanguageSpoken toEntity(LanguageSpokenDto languageSpokenDto);

    List<LanguageSpokenDto> toDtoList(List<LanguageSpoken> languageSpokens);
}