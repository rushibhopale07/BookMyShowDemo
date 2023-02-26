package com.example.BookMyShow_Application.EntityLayer;

import com.example.BookMyShow_Application.EnumLayer.SeatType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "Show_Seat")
@Data
@NoArgsConstructor
public class ShowSeatEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private boolean isBooked;
    private int seatNumber;
    private int price;
    @Enumerated(value = EnumType.STRING)
    private SeatType seatType;
    private Date bookedAt;

    //many showseats can have one show
    @ManyToOne
    @JoinColumn
    private ShowEntity showEntity;

}
