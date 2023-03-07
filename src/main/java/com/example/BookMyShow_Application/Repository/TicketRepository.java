package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.EntityLayer.TicketEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketEntity, Integer> {
}
