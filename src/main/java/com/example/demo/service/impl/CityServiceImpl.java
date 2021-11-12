package com.example.demo.service.impl;

import com.example.demo.domain.City;
import com.example.demo.repository.CityRepository;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository cityRepository;

    @Override
    public City save(City city) {
        city.setId(null);
        return cityRepository.save(city);
    }

    @Override
    public List<City> findAll() {
        return cityRepository.findAll();
    }

    @Override
    public Optional<City> findById(Integer id) {
        return cityRepository.findById(id);
    }

    @Override
    public City update(City city) {
        return cityRepository.saveAndFlush(city);
    }
}
