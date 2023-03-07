package com.example.BookMyShow_Application.EntryDTOs;

import com.example.BookMyShow_Application.EnumLayer.ShowType;

import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
public class ShowsEntryDto {
    private LocalDate showDate;
    private LocalTime showTime;
    private ShowType showType;

    // we cant create show directly we have to specific movie and theater
    // we just allocate the show of that movie is available at that theater

    private int movieId;

    private int theaterId;

    //we get seats price
    private int classicSeatPrice;

    private int premiumSeatPrice;
}
