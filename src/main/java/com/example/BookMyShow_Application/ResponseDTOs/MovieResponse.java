package com.example.BookMyShow_Application.ResponseDTOs;

import com.example.BookMyShow_Application.EnumLayer.Genre;
import com.example.BookMyShow_Application.EnumLayer.Language;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MovieResponse {
    private int movieId;
    private String movieName;

    private int duration;
    private double ratings;
    @Enumerated(value = EnumType.STRING)
    private Genre genre;

    @Enumerated(value = EnumType.STRING)
    private Language language;
}
