package Repository;

import Domain.Identifiable;

import java.util.ArrayList;

public class MemoryRepository<T extends Identifiable> implements IRepository<T>{
    private ArrayList<T> repository;

    public MemoryRepository()
    {
        this.repository = new ArrayList<>();
    }

    public boolean add(T elem) {
        if(repository.contains(elem))
            return false;
        repository.add(elem);
            return true;
    }

    @Override
    public boolean delete(T elem) {
        if(!repository.contains(elem))
            return false;
        repository.remove(elem);
            return true;
    }

    @Override
    public void setrepo(ArrayList<T> repo){

          this.repository = repo;

    }

    @Override
    public Iterable<T> getAll() {
        return repository;
    }
}
