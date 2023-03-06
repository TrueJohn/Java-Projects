package LabHomework;

import LabHomework.Domain.*;
import LabHomework.Repository.*;
import LabHomework.Service.*;
import LabHomework.Ui.*;




public class Main {
    public static void main(String[] args) {

        System.out.println("\n\nApp made by Suciu Ioan-Mihail group 822");

        Dentist dentist1 = new Dentist("Johnny", 9.5, 1);
        Dentist dentist2 = new Dentist("Nicolas", 8.3, 2);
        Dentist dentist3 = new Dentist("Alexandra", 9.9, 3);
        Dentist dentist4 = new Dentist("Maria", 9.0, 4);
        Dentist dentist5 = new Dentist("Stephen", 8.7, 5);

        DentistRepository dentistRepository = new DentistRepository();
        try {
            dentistRepository.add(dentist1);
            dentistRepository.add(dentist2);
            dentistRepository.add(dentist3);
            dentistRepository.add(dentist4);
            dentistRepository.add(dentist5);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }

        Patient patient1 = new Patient("Alexander", 20, "111", "0712345671", 101);
        Patient patient2 = new Patient("Ana", 21, "112", "0712345672", 102);
        Patient patient3 = new Patient("Mark", 20, "113", "0712345673", 103);
        Patient patient4 = new Patient("Felix", 25, "114", "0712345674", 104);
        Patient patient5 = new Patient("Robert", 30, "115", "0712345675", 105);

        PatientRepository patientRepository = new PatientRepository();

        try {
            patientRepository.add(patient1);
            patientRepository.add(patient2);
            patientRepository.add(patient3);
            patientRepository.add(patient4);
            patientRepository.add(patient5);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }

        PatientService patientService = new PatientService(patientRepository);

        DentistService dentistService = new DentistService(dentistRepository);

        Appointment appointment1 = new Appointment("Detail 1", "08.11.2022", 2, 10001, dentist1, patient1);
        Appointment appointment2 = new Appointment("Detail 2", "10.12.2022", 3, 10002, dentist2, patient2);
        Appointment appointment3 = new Appointment("Detail 3", "05.04.2022", 1, 10003, dentist3, patient3);
        Appointment appointment4 = new Appointment("Detail 4", "11.11.2023", 4, 10004, dentist3, patient4);
        Appointment appointment5 = new Appointment("Detail 5", "11.11.2023", 4, 10004, dentist4, patient1);

        AppointmentRepository appointmentRepository = new AppointmentRepository();

        try {
            appointmentRepository.add(appointment1);
            appointmentRepository.add(appointment2);
            appointmentRepository.add(appointment3);
            appointmentRepository.add(appointment4);
            appointmentRepository.add(appointment5);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());

        }


        AppointmentService appointmentService = new AppointmentService(appointmentRepository);

        Ui ui = new Ui(appointmentService,dentistService, patientService);

        ui.main();

    }
}