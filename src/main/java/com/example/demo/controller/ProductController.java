package com.example.demo.controller;

import com.example.demo.domain.Product;
import com.example.demo.response.Response;
import com.example.demo.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/id/{id}")
    public ResponseEntity<Response<Product>> findById(@PathVariable("id") Integer id) {
        Response<Product> response = new Response<Product>();
        Optional<Product> product = productService.findById(id);

        if(!product.isPresent()) {
            response.getErrors().add("Produto não encontrado: id: " + id);
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(product.get());

        return ResponseEntity.ok(response);

    }

    @GetMapping("/products")
    public @ResponseBody List<Product> findAll() {
        return productService.findAll();

    }

    @PostMapping("/save")
    public ResponseEntity<Void> saveProduct(@Validated @RequestBody Product product) {

        product = productService.save(product);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(product.getId()).toUri();
        ResponseEntity.created(uri).build();

        return ResponseEntity.noContent().build();
    }



}
