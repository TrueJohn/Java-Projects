package com.example.Repository;

import com.example.Domain.Identifiable;

import java.util.ArrayList;

public class MemoryRepository<T extends Identifiable> implements IRepository<T> {
    private ArrayList<T> repository;

    public MemoryRepository() {
        this.repository = new ArrayList<>();
    }

    public boolean add(T elem) {
        if (repository.contains(elem))
            return false;
        repository.add(elem);
        return true;
    }

    @Override
    public boolean delete(T elem) {

        return repository.remove(elem);

    }

    @Override
    public void setRepository(ArrayList<T> repository) {

        this.repository = repository;

    }

    @Override
    public boolean has(T elem) {
        return this.repository.contains(elem);
    }

    @Override
    public T getById(Integer id) {
        for (T elem1 : repository) {
            if (elem1.getId() == id)
                return elem1;
        }
        return null;
    }

    @Override
    public boolean update(Integer id, T elem) {
        if (this.repository.contains(elem)) {
            this.repository.set(this.repository.indexOf(this.getById(id)), elem);
            return true;
        }
        return false;
    }

    @Override
    public Iterable<T> getAll() {
        return repository;
    }
}
