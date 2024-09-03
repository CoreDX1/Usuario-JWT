package com.example.catalogoapi;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.example.catalogoapi.Domain.Entity.Usuario;

@RestController
public class UserController {

    private final List<Usuario> users = List.of(
            new Usuario("Christian", "christian@gmail.com"),
            new Usuario("John", "john@gmail.com"),
            new Usuario("Anna", "anna@gmail.com"));

    @GetMapping("/users")
    public ResponseEntity<List<Usuario>> getUsers() {
        return ResponseEntity.ok(this.users);
    }

    @GetMapping(path = "/user/{name}", produces = "application/json")
    public ResponseEntity<Usuario> getUserByName(@PathVariable String name) {
        var user = this.users.stream().filter(u -> u.getNome().equals(name)).findFirst();

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/user")
    public ResponseEntity<Usuario> createUser(@RequestBody Usuario user) {
        this.users.add(user);
        return ResponseEntity.ok(user);
    }

    @PutMapping("/user/{name}")
    public ResponseEntity<Usuario> updateUser(@PathVariable String name, @RequestBody Usuario user) {
        var existingUser = this.users.stream().filter(u -> u.getNome().equals(name)).findFirst();

        if (existingUser.isPresent()) {
            existingUser.get().setNome(user.getNome());
            existingUser.get().setEmail(user.getEmail());
            return ResponseEntity.ok(existingUser.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/user/{name}")
    public ResponseEntity<Void> deleteUser(@PathVariable String name) {
        var user = this.users.stream().filter(u -> u.getNome().equals(name)).findFirst();

        if (user.isPresent()) {
            this.users.remove(user.get());
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<Usuario> getUserByEmail(@PathVariable String email) {
        var user = this.users.stream().filter(u -> u.getEmail().equals(email)).findFirst();

        return user.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
