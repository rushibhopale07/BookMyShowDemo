package com.example.BookMyShow_Application.Controller;

import com.example.BookMyShow_Application.EntryDTOs.MovieEntryDto;
import com.example.BookMyShow_Application.ResponseDTOs.MovieResponse;
import com.example.BookMyShow_Application.Service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    @Autowired
    MovieService movieService;
    @PostMapping("/add")
    public ResponseEntity<String> createMovie(@RequestBody MovieEntryDto movieEntryDto){
        String message;
        try {
           message=movieService.createMovie(movieEntryDto);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            message="Insufficient Information";
            return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
        }


    }
    @GetMapping("/get-all-movies")
    public List<MovieResponse> getAllMovies() {
        return movieService.getAllMovies();
    }

    //get movie name with max no of shows acros all places
    // we need to traverse movie one by one and count the max no of shows

    @GetMapping("/get-max-show")
    public ResponseEntity<String> getMaxShowNoOfMovie()
    {
        try
        {
           String message = movieService.getMaxShowOfMovie();
           return new ResponseEntity<>(message, HttpStatus.FOUND);
        }
        catch (Exception e)
        {
            String error = e.getMessage();
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}
