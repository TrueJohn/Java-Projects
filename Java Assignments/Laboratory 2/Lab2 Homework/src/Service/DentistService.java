package Service;
import Domain.*;
import Repository.DentistRepository;
import Exception.RepositoryException;

import java.util.ArrayList;
import java.util.Iterator;

public class DentistService {

    private final DentistRepository repo;

    public DentistService(DentistRepository repo) {
        this.repo = repo;
    }

    public void addDentist(Integer id,String name,Double rating) throws RepositoryException
    {
        Dentist dentist=new Dentist(name, rating, id);
        if(!this.repo.add(dentist))
            throw new RepositoryException("Can not add Dentist details");
    }

    public void sortDentistsByName()
    {

        Iterable<Dentist> iterated = this.getALL();
        Iterator<Dentist> i = iterated.iterator();
        ArrayList<Dentist> dentists = new ArrayList<>();
        while (i.hasNext()) {
            dentists.add(i.next());
        }
        dentists.sort(new CompareByNameDentist());
        this.repo.setrepo(dentists);
    }

    public void sortDentistsByRating()
    {

        Iterable<Dentist> iterated = this.getALL();
        Iterator<Dentist> i = iterated.iterator();
        ArrayList<Dentist> dentists = new ArrayList<>();
        while (i.hasNext()) {
            dentists.add(i.next());
        }
        dentists.sort(new CompareByRatingDentist());
        this.repo.setrepo(dentists);
    }

    public void removeDentist(Dentist dentist) throws RepositoryException
    {
        if(!this.repo.delete(dentist))
            throw new RepositoryException("Can not remove Dentist details.");
    }

    public Iterable<Dentist> getALL()
    {
        return repo.getAll();
    }




}
