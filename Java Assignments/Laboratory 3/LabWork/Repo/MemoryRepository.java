package LabWork.Repo;
import LabWork.Domain.*;
import java.util.ArrayList;
import java.util.Comparator;


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
    public void sortbycriteria(Comparator c1)
    {
        this.repository.sort(c1);
    }

    @Override
    public Iterable<T> getAll() {
        return repository;
    }

    @Override
    public boolean searchelem(T elem)
    {
        return this.repository.contains(elem);
    }

    @Override
    public boolean update(Integer id,T newelem)
    {
        int i=0;
        for(T elem:this.repository) {
            if (elem.getId() == id) {
                repository.set(i,newelem);
                return true;
            }
            i++;
        }
        return false;


    }

}
