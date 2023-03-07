package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.EntityLayer.ShowEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShowsRepository extends JpaRepository<ShowEntity, Integer> {
}
