package com.example.demo.service.impl;

import com.example.demo.domain.Product;
import com.example.demo.enums.StatusEnum;
import com.example.demo.repository.ProductRepository;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;


    @Override
    public Product save(Product product) {
        product.setId(null);
        product.setStatusEnum(StatusEnum.ACTIVE);
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return productRepository.findById(id);
    }

    @Override
    public Product update(Product product) {

        return productRepository.saveAndFlush(product);
    }

    @Override
    public Product inactivate(Product product) {
        return productRepository.saveAndFlush(product);
    }
}
