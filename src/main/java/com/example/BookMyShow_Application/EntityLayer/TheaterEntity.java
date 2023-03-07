package com.example.BookMyShow_Application.EntityLayer;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Theater")

@Data
@NoArgsConstructor

@Builder
@AllArgsConstructor
public class TheaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String name;

    private String location;

    //Theater is parent of Shows and Theater Seats
    //One theater have different shows
    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    private List<ShowEntity> listOfShows = new ArrayList<>();


    //One Theater have different seats
    @OneToMany(mappedBy = "theaterEntity", cascade = CascadeType.ALL)
    private List<TheaterSeatEntity> listOfTheaterSeats = new ArrayList<>();
}
