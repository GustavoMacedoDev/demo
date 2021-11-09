package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.response.Response;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/email/{email}", method = RequestMethod.GET)
    public ResponseEntity<Response<User>> findByEmail(@PathVariable("email") String email) {
        Response<User> response = new Response<User>();
        Optional<User> user = userService.findByEmail(email);

        if(!user.isPresent()){
            response.getErrors().add("Usuário não encontrado - email: " + email);
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(user.get());
        return ResponseEntity.ok(response);

    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Response<User>> findById(@PathVariable("id") Integer id) {
        Response<User> response = new Response<User>();
        Optional<User> user = userService.findById(id);

        if(!user.isPresent()){
            response.getErrors().add("Usuário não encontrado - id: " + id);
            return ResponseEntity.badRequest().body(response);
        }
        response.setData(user.get());
        return ResponseEntity.ok(response);

    }


}
