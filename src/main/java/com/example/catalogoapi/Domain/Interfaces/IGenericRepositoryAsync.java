package com.example.catalogoapi.Domain.Interfaces;

import java.util.Optional;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public interface IGenericRepositoryAsync<T> {
    Optional<T> GetByIdAsync(int id);

    List<T> GetAllAsync();

    void AddAsync(T entity);

    void UpdateAsync(T entity);

    void DeleteAsync(T entity);
}
