package com.example.spring.data.jpa.repository;

import com.example.spring.data.jpa.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
