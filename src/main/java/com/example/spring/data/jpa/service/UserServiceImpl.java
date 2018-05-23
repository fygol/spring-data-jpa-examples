package com.example.spring.data.jpa.service;

import com.example.spring.data.jpa.model.User;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {
    @Transactional
    @Override
    public User findById(Long id) {
        return null;
    }
}
