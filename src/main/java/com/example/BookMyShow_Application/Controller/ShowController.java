package com.example.BookMyShow_Application.Controller;

import com.example.BookMyShow_Application.EntryDTOs.ShowsEntryDto;
import com.example.BookMyShow_Application.Service.ShowsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/Shows")
public class ShowController {

    @Autowired
    ShowsService showsService;

    @PostMapping("/add")
    public ResponseEntity<String> createShows(@RequestBody ShowsEntryDto showsEntryDto)
    {
        try {
            String message=showsService.addShow(showsEntryDto);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch (Exception e)
        {
            String error=e.getMessage();
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
