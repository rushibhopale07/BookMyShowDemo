package com.example.BookMyShow_Application.Converters;

import com.example.BookMyShow_Application.EntityLayer.MovieEntity;
import com.example.BookMyShow_Application.EntryDTOs.MovieEntryDto;

public class MovieConverter {

    public static MovieEntity convertDtoToEntry(MovieEntryDto movieEntryDto)
    {
        MovieEntity movieEntity= MovieEntity.builder()
                .movieName(movieEntryDto.getMovieName())
                .genre(movieEntryDto.getGenre())
                .duration(movieEntryDto.getDuration())
                .language(movieEntryDto.getLanguage())
                .ratings(movieEntryDto.getRatings()).build();

        return movieEntity;
    }
}
