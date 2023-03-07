package com.example.BookMyShow_Application.Controller;


import com.example.BookMyShow_Application.EntryDTOs.TicketEntryDto;
import com.example.BookMyShow_Application.Service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @PostMapping("/add")
    public ResponseEntity<String> addTicket(@RequestBody TicketEntryDto ticketEntryDto)
    {
        try {
            String message= ticketService.addTicket(ticketEntryDto);
            return new ResponseEntity<>(message, HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            String error= e.getMessage();
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }
}
