package com.example.demo.controller;

import com.example.demo.domain.City;
import com.example.demo.response.Response;
import com.example.demo.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.lang.management.OperatingSystemMXBean;
import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(value = "*")
@RequestMapping("/city")
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<City> findAll() {
        return cityService.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Response<City>> findById(@PathVariable("id") Integer id) {
        Response<City> response = new Response<>();
        Optional<City> city = cityService.findById(id);

        if(!city.isPresent()) {
            response.getErrors().add("Cidade não encontrada: " + id);
            return ResponseEntity.badRequest().body(response);
        }

        response.setData(city.get());
        return ResponseEntity.ok(response);
    }
}
