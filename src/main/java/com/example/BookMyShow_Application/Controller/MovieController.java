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
}
