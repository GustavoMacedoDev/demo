package com.example.demo.service;

import com.example.demo.domain.Category;
import com.example.demo.domain.Product;

import java.util.List;
import java.util.Optional;

public interface CategoryService {

    Category save(Category category);

    List<Category> findAll();

    Optional<Category> findById(Integer id);

    Category update(Category category);

}
