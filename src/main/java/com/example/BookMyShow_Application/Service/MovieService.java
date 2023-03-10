package com.example.BookMyShow_Application.Service;

import com.example.BookMyShow_Application.Converters.MovieConverter;
import com.example.BookMyShow_Application.EntityLayer.MovieEntity;
import com.example.BookMyShow_Application.EntryDTOs.MovieEntryDto;
import com.example.BookMyShow_Application.Repository.MovieRepository;
import com.example.BookMyShow_Application.ResponseDTOs.MovieResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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


    public List<MovieResponse> getAllMovies() {
        List<MovieEntity> movieEntityList = movieRepository.findAll();
        List<MovieResponse> movieList = new ArrayList<>();

        for(MovieEntity movieEntity : movieEntityList)
        {
            MovieResponse movieResponse = MovieResponse.builder()
                    .movieId(movieEntity.getId())
                    .movieName(movieEntity.getMovieName())
                    .duration(movieEntity.getDuration())
                    .ratings(movieEntity.getRatings())
                    .genre(movieEntity.getGenre())
                    .language(movieEntity.getLanguage()).build();

            movieList.add(movieResponse);
        }

        return movieList;
    }

    public String getMaxShowOfMovie() throws Exception
    {
        List<MovieEntity> movieEntityList = movieRepository.findAll();
        int maxId=0;
        int maxShow=0;
        for(MovieEntity movieEntity: movieEntityList)
        {
            if(movieEntity.getShowEntityList().size() > maxShow)
            {
                maxId= movieEntity.getId();
                maxShow = movieEntity.getShowEntityList().size();
            }
        }
        if(maxShow == 0)
            throw new Exception("Movie Not Available");

        String movieName= movieRepository.findById(maxId).get().getMovieName() ;
        return movieName + " with "+maxShow+" Shows";
    }
}
