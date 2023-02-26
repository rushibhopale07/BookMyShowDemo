package com.example.BookMyShow_Application.EntityLayer;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

@Entity
@Table(name = "Ticket")
@Data
@NoArgsConstructor
public class TicketEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(nullable = false)
    private String movieName;
    private LocalDate showDate;
    private LocalTime showTime;
    private int totalAmount;
    private String ticketId= UUID.randomUUID().toString();
    private  String theaterName;


    //ticket acts as child of user, user have different tickets
    @ManyToOne
    @JoinColumn
    private UserEntity user;

    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;
}
