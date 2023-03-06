package com.example.Files;

import com.example.Domain.Dentist;

import java.io.*;
import java.util.ArrayList;

public class DentistRepositoryBinary extends FilesRepository<Dentist> {
    public DentistRepositoryBinary(String fileName) {
        super(fileName);
    }

    @Override
    public void readFromFile() {
        var repository = new ArrayList<Dentist>();
        try (var in = new ObjectInputStream(new FileInputStream(this.fileName))) {
            var dentists = (ArrayList<Dentist>) in.readObject();
            repository.addAll(dentists);
            this.setRepository(repository);
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void writeToFile() {
        var dentists = new ArrayList<Dentist>();
        dentists = (ArrayList<Dentist>) this.getAll();
        try (var out = new ObjectOutputStream(new FileOutputStream(this.fileName))) {
            out.writeObject(dentists);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
