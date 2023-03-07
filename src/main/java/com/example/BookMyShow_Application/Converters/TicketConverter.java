package com.example.BookMyShow_Application.Converters;

import com.example.BookMyShow_Application.EntityLayer.TicketEntity;
import com.example.BookMyShow_Application.EntryDTOs.TicketEntryDto;

public class TicketConverter {

    public static TicketEntity convertDtoToEntity(TicketEntryDto ticketEntryDto)
    {
        TicketEntity ticketEntity = new TicketEntity();
        return ticketEntity;
    }
}
