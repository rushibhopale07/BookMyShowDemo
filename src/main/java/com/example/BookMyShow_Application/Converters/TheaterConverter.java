package com.example.BookMyShow_Application.Converters;

import com.example.BookMyShow_Application.EntityLayer.TheaterEntity;
import com.example.BookMyShow_Application.EntryDTOs.TheaterEntryDto;

public class TheaterConverter {

    public static TheaterEntity convertDtoToEntity(TheaterEntryDto theaterEntryDto)
    {
            TheaterEntity theaterEntity = TheaterEntity.builder()
                    .name(theaterEntryDto.getName())
                    .location(theaterEntryDto.getLocation()).build();
            return theaterEntity;
    }
}
