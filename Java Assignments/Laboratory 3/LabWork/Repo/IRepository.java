package LabWork.Repo;

import java.util.ArrayList;
import java.util.Comparator;

public interface IRepository<T> {
    boolean add(T elem);

    boolean delete(T elem);

    void setrepo(ArrayList<T> repo);

    void sortbycriteria(Comparator c1);

    boolean searchelem(T elem);

    boolean update(Integer id,T newelem);

    Iterable<T> getAll();
}
