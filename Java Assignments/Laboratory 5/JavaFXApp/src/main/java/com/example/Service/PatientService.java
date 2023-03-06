package com.example.Service;

import com.example.Domain.CompareByNamePatient;
import com.example.Domain.Patient;
import com.example.Exception.RepositoryException;
import com.example.Repository.PatientRepository;

import java.util.ArrayList;
import java.util.Iterator;

public class PatientService {

    private final PatientRepository patientRepository;

    public PatientService(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }

    public void addPatient(Integer id, String name, Integer age, String personalidentificationcode, String phonenumber) throws RepositoryException {
        Patient patient = new Patient(name, age, personalidentificationcode, phonenumber, id);

        if (!this.patientRepository.add(patient))
            throw new RepositoryException("Can not add patient");
    }

    public void sortPatientByName() {

        Iterable<Patient> iterated = this.getALL();
        Iterator<Patient> i = iterated.iterator();
        ArrayList<Patient> patients = new ArrayList<>();
        while (i.hasNext()) {
            patients.add(i.next());
        }
        patients.sort(new CompareByNamePatient());
        this.patientRepository.setRepository(patients);
    }

    public void deletePatient(Patient patient) throws RepositoryException {
        if (!this.patientRepository.delete(patient) )
            throw new RepositoryException("Can not remove patient details.");
    }

    public boolean contains(Patient patient) {
        return patientRepository.has(patient);
    }

    public Patient getById(Integer id) throws RepositoryException {
        return patientRepository.getById(id);

    }

    public void update(Integer id, Patient patient) {
        this.patientRepository.update(id, patient);
    }

    public Iterable<Patient> getALL() {
        return patientRepository.getAll();
    }


}
