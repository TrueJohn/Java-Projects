package Service;
import Domain.Appointment;
import Domain.CompareByDateAppointment;
import Domain.CompareByNamePatient;
import Domain.Patient;
import Repository.PatientRepository;
import Exception.RepositoryException;

import java.util.ArrayList;
import java.util.Iterator;

public class PatientService {

    private final PatientRepository repo;

    public PatientService(PatientRepository repo) {
        this.repo = repo;
    }

    public void addPatient(Integer id,String name,Integer age,String personalidentificationcode,String phonenumber) throws RepositoryException
    {
        Patient patient=new Patient(name,age,personalidentificationcode,phonenumber,id);

        if(!this.repo.add(patient))
            throw new RepositoryException("Can not add patient");
    }

    public void sortPatientByName()
    {

        Iterable<Patient> iterated = this.getALL();
        Iterator<Patient> i = iterated.iterator();
        ArrayList<Patient> patients = new ArrayList<>();
        while (i.hasNext()) {
            patients.add(i.next());
        }
        patients.sort(new CompareByNamePatient());
        this.repo.setrepo(patients);
    }
    public void deletePatient(Patient patient)throws RepositoryException
    {
        if(!this.repo.delete(patient))
            throw new RepositoryException("Can not remove patient details.");
    }

    public Iterable<Patient> getALL()
    {
        return repo.getAll();
    }




}
