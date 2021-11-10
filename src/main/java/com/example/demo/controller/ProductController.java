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

/**
 *
 */
@RestController
@RequestMapping("/product")
@CrossOrigin(origins = "*")
public class ProductController {

    @Autowired
    private ProductService productService;

    /*
     * find Product by Id
     */
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
    /*
     * find all products
     */
    @GetMapping("/products")
    public @ResponseBody List<Product> findAll() {
        return productService.findAll();

    }

    /*
     * persist a new product
     */
    @PostMapping("/save")
    public ResponseEntity<Void> saveProduct(@Validated @RequestBody Product product) {

        product = productService.save(product);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(product.getId()).toUri();
        ResponseEntity.created(uri).build();

        return ResponseEntity.noContent().build();
    }

    /*
     * update an existent product
     */

    @PutMapping("/update")
    public ResponseEntity<Void> updateProduct(@Validated @RequestBody Product product) {

        product = productService.update(product);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(product.getId()).toUri();
        ResponseEntity.created(uri).build();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/inactivate")
    public ResponseEntity<Void> inactivateProduct(@Validated @RequestBody Product product) {

        product = productService.inactivate(product);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(product.getId()).toUri();
        ResponseEntity.created(uri).build();

        return ResponseEntity.noContent().build();
    }

}
