package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.EntityLayer.MovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieEntity, Integer> {
}
