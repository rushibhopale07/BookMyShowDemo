package com.example.BookMyShow_Application.EntityLayer;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="User")
@Data
@NoArgsConstructor

@Builder
@AllArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private int age;
    private String email;
    @Column(unique = true,nullable = false)
    private String mobNo;
    private String address;


    //One User can have many tickets
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<TheaterEntity> listOfTickets = new ArrayList<>();

}
