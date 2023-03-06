package LabHomework.Repository;

import java.util.ArrayList;

public interface IRepository<T> {
    boolean add(T elem);

    boolean delete(T elem);

    void setRepository(ArrayList<T> repo);

    boolean has(T elem);

    boolean update(Integer id, T elem);

    T getById(Integer id);

    Iterable<T> getAll();
}
