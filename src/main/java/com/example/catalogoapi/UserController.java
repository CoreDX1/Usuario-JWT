package com.example.catalogoapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.catalogoapi.Application.Services.UserService;
import com.example.catalogoapi.Domain.Entity.Usuario;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> getUsers() {
        return ResponseEntity.ok(this.service.GetAll());
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<Usuario> getUserById(@PathVariable int id) {
        return ResponseEntity.ok(this.service.GetById(id));
    }
}
