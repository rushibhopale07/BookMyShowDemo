package com.example.BookMyShow_Application.Controller;

import com.example.BookMyShow_Application.EntryDTOs.TheaterEntryDto;
import com.example.BookMyShow_Application.ResponseDTOs.TheaterResponse;
import com.example.BookMyShow_Application.Service.TheaterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theater")
public class TheaterController {

    @Autowired
    TheaterService theaterService;

    @PostMapping("/add")
    public ResponseEntity<String> createTheater(@RequestBody TheaterEntryDto theaterEntryDto)
    {
        try {
            String message= theaterService.createTheater(theaterEntryDto);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            String error= e.getMessage();
            return new ResponseEntity<>(error, HttpStatus.CREATED);
        }
    }

    @GetMapping("/nooftheaters")
    public List<TheaterResponse> getNoOfTheaters()
    {
        return theaterService.Theaters();
    }
}
