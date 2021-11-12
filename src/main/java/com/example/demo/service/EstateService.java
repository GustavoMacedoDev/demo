package com.example.demo.service;

import com.example.demo.domain.Estate;

import java.util.List;
import java.util.Optional;

public interface EstateService {

    Estate save(Estate estate);

    List<Estate> findAll();

    Optional<Estate> findById(Integer id);

    Estate update(Estate estate);
}
