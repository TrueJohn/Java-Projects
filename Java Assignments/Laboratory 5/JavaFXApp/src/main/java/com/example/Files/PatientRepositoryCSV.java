package com.example.Files;


import com.example.Domain.Patient;

import java.io.*;
import java.util.ArrayList;

public class PatientRepositoryCSV extends FilesRepository<Patient> {

    public PatientRepositoryCSV(String fileName) {
        super(fileName);
    }

    @Override
    public void readFromFile() {
        ArrayList<Patient> repository = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split(",");
                if (elements.length != 5)
                    continue;
                Patient patient = new Patient(elements[0].strip(), Integer.parseInt(elements[1].strip()), elements[2].strip(), elements[3].strip(), Integer.parseInt(elements[4].strip()));
                repository.add(patient);
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
            for (Patient patient : this.getAll()) {
                bufferedWriter.write(patient.getName() + " , " + patient.getAge() + " , " + patient.getPhoneNumber() + " , " +
                        patient.getPersonalIdentificationCode() + " , " + patient.getId());
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