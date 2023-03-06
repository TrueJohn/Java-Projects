package Repository;

import java.util.ArrayList;

public interface IRepository<T> {
    boolean add(T elem);

    boolean delete(T elem);

    void setrepo(ArrayList<T> repo);

     Iterable<T> getAll();
}
