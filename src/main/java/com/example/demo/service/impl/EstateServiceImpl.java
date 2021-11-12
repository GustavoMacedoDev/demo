package com.example.demo.service.impl;

import com.example.demo.domain.Estate;
import com.example.demo.repository.EstateRepository;
import com.example.demo.service.EstateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstateServiceImpl implements EstateService {

    @Autowired
    private EstateRepository estateRepository;

    @Override
    public Estate save(Estate estate) {
        estate.setId(null);
        return estateRepository.save(estate);
    }

    @Override
    public List<Estate> findAll() {
        return estateRepository.findAll();
    }

    @Override
    public Optional<Estate> findById(Integer id) {
        return estateRepository.findById(id);
    }

    @Override
    public Estate update(Estate estate) {
        return estateRepository.saveAndFlush(estate);
    }
}
