package com.example.demo.controller;

import com.example.demo.domain.Category;
import com.example.demo.response.Response;
import com.example.demo.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping("/categories")
    public List<Category> findAll() {
        return categoryService.findAll();
    }

    @GetMapping("/id")
    public ResponseEntity<Response<Category>> findById(@PathVariable("id") Integer id) {

        Response<Category> response = new Response<>();
        Optional<Category> category = categoryService.findById(id);

        if(!category.isPresent()) {
            response.getErrors().add("Categoria não encontrada! Id: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(category.get());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@Validated @RequestBody Category category) {
        category = categoryService.save(category);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(category.getId()).toUri();
        ResponseEntity.created(uri).build();

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<Void> update(@Validated @RequestBody Category category) {
        category = categoryService.update(category);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}").buildAndExpand(category.getId()).toUri();
        ResponseEntity.created(uri).build();

        return ResponseEntity.noContent().build();
    }




}
