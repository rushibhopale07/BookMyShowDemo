package com.example.BookMyShow_Application.ResponseDTOs;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TheaterResponse {
    private int id;
    private String name;
    private int sizeOfTheater;

}
