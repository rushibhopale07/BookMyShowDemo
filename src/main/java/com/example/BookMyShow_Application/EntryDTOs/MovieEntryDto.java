package com.example.BookMyShow_Application.EntryDTOs;

import com.example.BookMyShow_Application.EnumLayer.Genre;
import com.example.BookMyShow_Application.EnumLayer.Language;

import lombok.Data;

@Data
public class MovieEntryDto {
    private String movieName;
    private int duration;
    private double ratings;
    private Genre genre;
    private Language language;
}
