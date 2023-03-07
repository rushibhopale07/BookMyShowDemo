package com.example.BookMyShow_Application.EntryDTOs;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data

public class TicketEntryDto {

    private int showId;
    private List<String> requstedSeats = new ArrayList<>();
    private int userId;


}

