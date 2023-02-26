package com.example.BookMyShow_Application.Controller;

import com.example.BookMyShow_Application.EntryDTOs.UserEntryDto;
import com.example.BookMyShow_Application.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/create")
    public ResponseEntity<String> createUser(@RequestBody UserEntryDto userEntryDto)
    {
        String message;
        try {
            message = userService.createUser(userEntryDto);
        }
        catch (Exception e)
        {
           message ="Insufficient Information";
        }
        return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
    }
}
