package com.example.Files;

import com.example.Domain.Dentist;

import java.io.*;
import java.util.ArrayList;


public class DentistRepositoryCSV extends FilesRepository<Dentist> {

    public DentistRepositoryCSV(String fileName) {
        super(fileName);
    }

    @Override
    public void readFromFile() {
        ArrayList<Dentist> repository = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split(",");
                if (elements.length != 3)
                    continue;
                Dentist dentist = new Dentist(elements[0].strip(), Double.parseDouble(elements[1].strip()), Integer.parseInt(elements[2].strip()));
                repository.add(dentist);
            }
            this.setRepository(repository);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null)
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    System.out.println("Error while closing the file " + e);
                }
        }
    }

    @Override
    public void writeToFile() {
        BufferedWriter bufferedWriter = null;
        try {
            bufferedWriter = new BufferedWriter(new FileWriter(this.fileName));
            for (Dentist dentist : this.getAll()) {
                bufferedWriter.write(dentist.getName() + " , " + dentist.getRating() + " , " + dentist.getId());
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert bufferedWriter != null;
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}