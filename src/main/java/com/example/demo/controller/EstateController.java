package com.example.demo.controller;

import com.example.demo.domain.Estate;
import com.example.demo.response.Response;
import com.example.demo.service.EstateService;
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
@RequestMapping("/estate")
public class EstateController {

    @Autowired
    private EstateService estateService;

    @GetMapping("/estates")
    public List<Estate> findAll() {
        return estateService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Estate>> findById(@PathVariable("id") Integer id) {
        Response<Estate> response = new Response<>();
        Optional<Estate> estate = estateService.findById(id);

        if(!estate.isPresent()) {
            response.getErrors().add("Estado não encontrado: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(estate.get());

        return ResponseEntity.ok(response);
    }

    @PostMapping("/save")
    public ResponseEntity<Void> save(@Validated @RequestBody Estate estate) {
        estate = estateService.save(estate);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(estate.getId()).toUri();
        ResponseEntity.created(uri).build();

        return ResponseEntity.noContent().build();

    }

    @PostMapping("/update")
    public ResponseEntity<Void> update(@Validated @RequestBody Estate estate) {
        estate = estateService.update(estate);

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/id").buildAndExpand(estate.getId()).toUri();
        ResponseEntity.created(uri).build();

        return ResponseEntity.noContent().build();

    }


}
