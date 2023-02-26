package com.example.BookMyShow_Application.Service;

import com.example.BookMyShow_Application.Converters.MovieConverter;
import com.example.BookMyShow_Application.EntityLayer.MovieEntity;
import com.example.BookMyShow_Application.EntryDTOs.MovieEntryDto;
import com.example.BookMyShow_Application.Repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    MovieRepository movieRepository;

    public String createMovie(MovieEntryDto movieEntryDto) throws Exception, NullPointerException
    {
        MovieEntity movieEntity= MovieConverter.convertDtoToEntry(movieEntryDto);
        movieRepository.save(movieEntity);
        return "Movie Is Created";
    }
}
