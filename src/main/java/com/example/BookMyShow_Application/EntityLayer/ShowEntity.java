package com.example.BookMyShow_Application.EntityLayer;

import com.example.BookMyShow_Application.EnumLayer.ShowType;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Shows")
@Data
@NoArgsConstructor

@Builder
@AllArgsConstructor
public class ShowEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    private LocalDate showDate;
    private LocalTime showTime;

    @Enumerated(value = EnumType.STRING)
    private ShowType showType;

    @CreationTimestamp
    private Date createdOn;
    @UpdateTimestamp
    private Date updateOn;


    //Different Shows can contains one movie
    @ManyToOne
    @JoinColumn
    private MovieEntity movieEntity;


    //Different Theaters having one shows
    @ManyToOne
    @JoinColumn
    private TheaterEntity theaterEntity;

    //one show can have many showsetas

    @OneToMany(mappedBy = "showEntity", cascade = CascadeType.ALL)
    private List<ShowSeatEntity> listOfShowSeats = new ArrayList<>();

    //One show can have different tickets
    @OneToMany(mappedBy = "showEntity",cascade = CascadeType.ALL)
    private List<TicketEntity> listOfTickets = new ArrayList<>();

}
