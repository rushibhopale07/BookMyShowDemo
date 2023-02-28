package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.EntityLayer.TheaterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TheaterRepository extends JpaRepository<TheaterEntity, Integer> {
}
