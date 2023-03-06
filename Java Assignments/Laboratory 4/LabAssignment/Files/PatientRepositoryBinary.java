package LabAssignment.Files;


import LabAssignment.Domain.Patient;

import java.io.*;
import java.util.ArrayList;

public class PatientRepositoryBinary extends FilesRepository<Patient> {
    public PatientRepositoryBinary(String fileName) {
        super(fileName);
    }

    @Override
    public void readFromFile() {
        var repository = new ArrayList<Patient>();
        try (var in = new ObjectInputStream(new FileInputStream(this.fileName))) {
            var patients = (ArrayList<Patient>) in.readObject();
            repository.addAll(patients);
            this.setRepository(repository);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void writeToFile() {
        var patients = new ArrayList<Patient>();
        patients = (ArrayList<Patient>) this.getAll();
        try (var out = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            out.writeObject(patients);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
