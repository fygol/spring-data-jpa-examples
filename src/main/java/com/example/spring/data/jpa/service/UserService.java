package com.example.spring.data.jpa.service;

import com.example.spring.data.jpa.model.User;

public interface UserService {
    User findById(Long id);
}
