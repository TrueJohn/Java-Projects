package LabHomework.Files;

import LabHomework.Domain.Appointment;

import java.io.*;
import java.util.ArrayList;


public class AppointmentsRepositoryBinary extends FilesRepository<Appointment> {
    public AppointmentsRepositoryBinary(String fileName) {
        super(fileName);
    }

    @Override
    public void readFromFile() {
        var repository = new ArrayList<Appointment>();
        try (var in = new ObjectInputStream(new FileInputStream(this.fileName))) {
            var appointments = (ArrayList<Appointment>) in.readObject();
            repository.addAll(appointments);
            this.setRepository(repository);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile() {
        var appointments = new ArrayList<Appointment>();
        appointments = (ArrayList<Appointment>) this.getAll();
        try (var out = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            out.writeObject(appointments);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
