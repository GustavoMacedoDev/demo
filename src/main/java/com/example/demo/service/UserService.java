package com.example.demo.service;

import com.example.demo.domain.User;

import java.util.Optional;

public interface UserService {

    Optional<User> findByEmail(String email);

    Optional<User> findById(Integer id);

    User save(User user);
}

