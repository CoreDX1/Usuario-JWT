package com.example.catalogoapi.Domain.Repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.catalogoapi.Domain.Interfaces.IGenericRepositoryAsync;

public abstract class GenericRepository<T> implements IGenericRepositoryAsync<T> {

    @Autowired
    private JpaRepository<T, Integer> jpaRepository;

    @Override
    public Optional<T> GetByIdAsync(int id) {
        return this.jpaRepository.findById(id);
    }

    @Override
    public List<T> GetAllAsync() {
        return this.jpaRepository.findAll();
    }

    @Override
    public void AddAsync(T entity) {
        this.jpaRepository.save(entity);
    }

    @Override
    public void UpdateAsync(T entity) {
        this.jpaRepository.save(entity);
    }

    @Override
    public void DeleteAsync(T entity) {
        this.jpaRepository.delete(entity);
    }

}
