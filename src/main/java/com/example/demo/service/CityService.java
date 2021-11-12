package com.example.demo.service;

import com.example.demo.domain.City;

import java.util.List;
import java.util.Optional;

public interface CityService {

    City save(City city);

    List<City> findAll();

    Optional<City> findById(Integer id);

    City update(City city);
}
