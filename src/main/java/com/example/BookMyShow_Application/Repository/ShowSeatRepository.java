package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.EntityLayer.ShowSeatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShowSeatRepository extends JpaRepository<ShowSeatEntity, Integer> {
}
