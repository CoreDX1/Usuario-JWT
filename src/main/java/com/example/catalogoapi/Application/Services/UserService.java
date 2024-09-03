package com.example.catalogoapi.Application.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.catalogoapi.Domain.Entity.Usuario;
import com.example.catalogoapi.Domain.Interfaces.IUsuarioRepository;

@Service
public class UserService {

    private final IUsuarioRepository repository;

    public UserService(IUsuarioRepository repository) {
        this.repository = repository;
    }

    public List<Usuario> GetAll() {
        return this.repository.findAll();
    }

    public Usuario GetById(int id) {
        return this.repository.findById(id).orElse(null);
    }
}
