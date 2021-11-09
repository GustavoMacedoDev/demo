package com.example.demo.service;

import com.example.demo.domain.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {

    Product save(Product product);

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    Optional<Product> update(Product product);

    Optional<Product> inactivate(Product product);


}
