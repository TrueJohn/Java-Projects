package LabHomework.Service;

import LabHomework.Domain.CompareByNameDentist;
import LabHomework.Domain.CompareByRatingDentist;
import LabHomework.Domain.Dentist;
import LabHomework.Exception.RepositoryException;
import LabHomework.Repository.DentistRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class DentistService {

    private final DentistRepository dentistRepository;

    public DentistService(DentistRepository dentistRepository) {
        this.dentistRepository = dentistRepository;
    }

    public void addDentist(Integer id, String name, Double rating) throws RepositoryException {
        Dentist dentist = new Dentist(name, rating, id);
        if (!this.dentistRepository.add(dentist))
            throw new RepositoryException("Can not add Dentist details");
    }

    public void sortDentistsByName() {

        Iterable<Dentist> iterated = this.getALL();
        Iterator<Dentist> i = iterated.iterator();
        ArrayList<Dentist> dentists = new ArrayList<>();
        while (i.hasNext()) {
            dentists.add(i.next());
        }
        dentists.sort(new CompareByNameDentist());
        this.dentistRepository.setRepository(dentists);
    }

    public void sortDentistsByRating() {

        Iterable<Dentist> iterated = this.getALL();
        Iterator<Dentist> i = iterated.iterator();
        ArrayList<Dentist> dentists = new ArrayList<>();
        while (i.hasNext()) {
            dentists.add(i.next());
        }
        dentists.sort(new CompareByRatingDentist());
        this.dentistRepository.setRepository(dentists);
    }

    public void removeDentist(Dentist dentist) throws RepositoryException {
        if (!this.dentistRepository.delete(dentist))
            throw new RepositoryException("Can not remove Dentist details.");
    }

    public boolean contains(Dentist dentist) {
        return dentistRepository.has(dentist);
    }

    public Dentist getById(Integer id) throws RepositoryException {
        return dentistRepository.getById(id);

    }

    public void update(Integer id, Dentist dentist) {
        this.dentistRepository.update(id, dentist);
    }

    public Iterable<Dentist> getALL() {
        return dentistRepository.getAll();
    }


}
