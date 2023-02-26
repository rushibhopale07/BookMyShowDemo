package com.example.BookMyShow_Application.Repository;

import com.example.BookMyShow_Application.EntityLayer.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {
}
