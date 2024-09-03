package com.example.catalogoapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.example.catalogoapi.Application.Services.UserService;
import com.example.catalogoapi.Domain.Common.ApiResult;
import com.example.catalogoapi.Domain.Entity.Usuario;

@RestController
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping("/users")
    public ResponseEntity<ApiResult<List<Usuario>>> getAllUsers() {
        var result = this.service.GetAll();
        return ResponseEntity.ok(result);
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<ApiResult<Usuario>> getUserById(@PathVariable int id) {
        var result = this.service.GetById(id);
        return ResponseEntity.ok(result);
    }
}
