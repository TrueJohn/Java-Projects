package LabHomework.Files;

import LabHomework.Domain.Appointment;
import LabHomework.Domain.Dentist;
import LabHomework.Domain.Patient;

import java.io.*;
import java.util.ArrayList;


public class AppointmentsRepositoryCSV extends FilesRepository<Appointment> {

    public AppointmentsRepositoryCSV(String fileName) {
        super(fileName);
    }

    @Override
    public void readFromFile() {
        ArrayList<Appointment> repository = new ArrayList<>();
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader(fileName));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] elements = line.split(",");
                if (elements.length != 12)
                    continue;
                Dentist dentist = new Dentist(elements[4].strip(), Double.parseDouble(elements[5].strip()), Integer.parseInt(elements[6].strip()));
                Patient patient = new Patient(elements[7].strip(), Integer.parseInt(elements[8].strip()), elements[9].strip(), elements[10].strip(), Integer.parseInt(elements[11].strip()));
                Appointment appointment = new Appointment(elements[0].strip(), elements[1].strip(), Integer.parseInt(elements[2].strip()), Integer.parseInt(elements[3].strip()), dentist, patient);
                repository.add(appointment);
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
            for (Appointment appointment : this.getAll()) {
                bufferedWriter.write(appointment.getDetails() + " , " + appointment.getDate() + " , " + appointment.getDuration() + " , " + appointment.getId() + " , "
                        + appointment.getDentist().getName() + " , " + appointment.getDentist().getRating() + " , " + appointment.getDentist().getId() + " , "
                        + appointment.getPatient().getName() + " , " + appointment.getPatient().getAge() + " , " + appointment.getPatient().getPersonalIdentificationCode() + " , "
                        + appointment.getPatient().getPhoneNumber() + " , " + appointment.getPatient().getId());
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