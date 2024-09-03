package com.example.catalogoapi.Domain.Interfaces;

import org.springframework.data.repository.CrudRepository;

import com.example.catalogoapi.Domain.Entity.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {
}
