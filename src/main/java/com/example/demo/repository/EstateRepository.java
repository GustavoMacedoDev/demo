package com.example.demo.repository;

import com.example.demo.domain.Estate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EstateRepository extends JpaRepository<Estate, Integer> {
}
