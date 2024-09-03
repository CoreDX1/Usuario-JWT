package com.example.catalogoapi.Application.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.catalogoapi.Domain.Common.ApiResult;
import com.example.catalogoapi.Domain.Entity.Usuario;
import com.example.catalogoapi.Domain.Interfaces.IUsuarioRepository;

@Service
public class UserService {

    private final IUsuarioRepository repository;

    public UserService(IUsuarioRepository repository) {
        this.repository = repository;
    }

    public ApiResult<List<Usuario>> GetAll() {

        var users = this.repository.findAll();
        if (users.isEmpty()) {
            return ApiResult.notFound();
        }

        return ApiResult.success(users);
    }

    public ApiResult<Usuario> GetById(int id) {
        var user = this.repository.findById(id);
        if (user.isEmpty()) {
            return ApiResult.notFound();
        }

        return ApiResult.success(user.get());
    }
}
