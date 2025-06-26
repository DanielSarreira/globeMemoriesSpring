package com.globalmemories.backend.mappers;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.mapstruct.Context;
import org.mapstruct.Named;
import org.springframework.stereotype.Component;

import com.globalmemories.backend.dtos.CategoryDto;
import com.globalmemories.backend.dtos.LanguageSpokenDto;
import com.globalmemories.backend.dtos.trip.AccommodationDto;
import com.globalmemories.backend.entites.Category;
import com.globalmemories.backend.entites.Country;
import com.globalmemories.backend.entites.LanguageSpoken;
import com.globalmemories.backend.entites.User;
import com.globalmemories.backend.entites.trip.Accommodation;
import com.globalmemories.backend.entites.trip.AccommodationBoard;
import com.globalmemories.backend.entites.trip.AccommodationType;
import com.globalmemories.backend.entites.trip.Trip;
import com.globalmemories.backend.entites.trip.TripCategory;
import com.globalmemories.backend.entites.trip.TripCategoryId;
import com.globalmemories.backend.entites.trip.TripLanguageSpoken;
import com.globalmemories.backend.entites.trip.TripLanguageSpokenId;
import com.globalmemories.backend.repositories.AccommodationBoardRepository;
import com.globalmemories.backend.repositories.AccommodationTypeRepository;
import com.globalmemories.backend.repositories.CategoryRepository;
import com.globalmemories.backend.repositories.CountryRepository;
import com.globalmemories.backend.repositories.LanguageSpokenRepository;
import com.globalmemories.backend.repositories.UserRepository;

import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class TripMapperHelper {

    private final UserRepository userRepository;
    private final CountryRepository countryRepository;
    private final CategoryRepository categoryRepository;
    private final LanguageSpokenRepository languageSpokenRepository;
    private final AccommodationTypeRepository accommodationTypeRepository;
    private final AccommodationBoardRepository accommodationBoardRepository;

    @Named("mapUserFromId")
    public User mapUserFromId(Long userId) {
        return userId == null ? null : userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + userId));
    }

    @Named("mapCountryFromId")
    public Country mapCountryFromId(Long countryId) {
        return countryId == null ? null : countryRepository.findById(countryId)
                .orElseThrow(() -> new RuntimeException("Country not found with id: " + countryId));
    }

    @Named("mapCategoriesFromIds")
    public Set<TripCategory> mapCategoriesFromIds(List<CategoryDto> categoryDtos, @Context Trip trip) {
        if (categoryDtos == null) {
            return null;
        }
        return categoryDtos.stream()
                .map(cat -> {
                    Category category = categoryRepository.findById(cat.getId())
                            .orElseThrow(() -> new RuntimeException("Category not found with id: " + cat.getId()));
                    return new TripCategory(new TripCategoryId(trip.getId(), category.getId()), trip, category);
                })
                .collect(Collectors.toSet());
    }

    @Named("mapLanguagesSpokenToIds")
    public Set<Long> mapLanguagesSpokenToIds(Set<TripLanguageSpoken> tripLanguagesSpoken) {
        if (tripLanguagesSpoken == null) {
            return null;
        }
        return tripLanguagesSpoken.stream()
                .map(languageSpoken -> languageSpoken.getLanguageSpoken().getId())
                .collect(Collectors.toSet());
    }

    @Named("mapLanguagesSpokenFromIds")
    public Set<TripLanguageSpoken> mapLanguagesSpokenFromIds(List<LanguageSpokenDto> languageSpokenDtos, @Context Trip trip) {
        if (languageSpokenDtos == null) {
            return null;
        }
        return languageSpokenDtos.stream()
                .map(ls -> {
                    LanguageSpoken languageSpoken = languageSpokenRepository.findById(ls.getId())
                            .orElseThrow(() -> new RuntimeException("Language Spoken not found with id: " + ls.getId()));
                    return new TripLanguageSpoken(new TripLanguageSpokenId(trip.getId(), languageSpoken.getId()), trip, languageSpoken);
                })
                .collect(Collectors.toSet());
    }

    @Named("mapAccommodations")
    public List<AccommodationDto> mapAccommodations(List<Accommodation> accommodations) {
        if (accommodations == null) return null;
        return accommodations.stream()
                .map(acc -> new AccommodationDto(
                        acc.getId(),
                        acc.getName(),
                        acc.getAccommodationType().getId(),
                        acc.getAccommodationType().getType(),
                        acc.getAccommodationBoard().getId(),
                        acc.getAccommodationBoard().getBoard(),
                        acc.getPrice(),
                        acc.getNrNights(),
                        acc.getCheckIn(),
                        acc.getCheckOut(),
                        acc.getBookingDate(),
                        acc.getDescription(),
                        acc.getRating()
                ))
                .collect(Collectors.toList());
    }

    @Named("mapAccommodationsFromDto")
    public List<Accommodation> mapAccommodationsFromDto(List<AccommodationDto> accommodationDtos, @Context Trip trip) {
        if (accommodationDtos == null) return null;
        return accommodationDtos.stream()
                .map(dto -> {
                    AccommodationType type = accommodationTypeRepository.findById(dto.getAccommodationTypeId())
                            .orElseThrow(() -> new RuntimeException("Accommodation Type not found"));
                    AccommodationBoard board = accommodationBoardRepository.findById(dto.getAccommodationBoardId())
                            .orElseThrow(() -> new RuntimeException("Accommodation Board not found"));
                    return new Accommodation(
                            dto.getId(),
                            dto.getName(),
                            type,
                            board,
                            dto.getPrice(),
                            dto.getNrNights(),
                            dto.getCheckIn(),
                            dto.getCheckOut(),
                            dto.getBookingDate(),
                            dto.getDescription(),
                            dto.getRating(),
                            trip
                    );
                })
                .collect(Collectors.toList());
    }
}









