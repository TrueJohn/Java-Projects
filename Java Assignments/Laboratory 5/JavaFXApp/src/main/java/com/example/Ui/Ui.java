package com.example.Ui;

import com.example.Domain.*;
import com.example.Exception.RepositoryException;
import com.example.Files.*;
import com.example.Repository.AppointmentRepository;
import com.example.Repository.DentistRepository;
import com.example.Repository.PatientRepository;
import com.example.Service.*;
import com.example.Tests.TestController;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Ui {

    private DentistService dentistservice;

    private AppointmentService appointmentService;
    private PatientService patientService;

    private final ServiceController serviceController;

    public Ui(AppointmentService appointmentService, DentistService dentistservice, PatientService patientservice, ServiceController serviceController) {
        this.appointmentService = appointmentService;
        this.dentistservice = dentistservice;
        this.patientService = patientservice;
        this.serviceController = serviceController;
    }


    public void addDentist() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input id: ");
        Integer id = sc.nextInt();
        System.out.print("Input name: ");
        String name = sc.next();
        System.out.print("Input rating: ");
        Double rating = sc.nextDouble();
        try {
            dentistservice.addDentist(id, name, rating);
        } catch (RepositoryException re) {
            System.out.println(re.getMessage());
        }
    }

    public void addPatient() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input id: ");
        Integer id = sc.nextInt();
        System.out.print("Input name: ");
        String name = sc.next();
        System.out.print("Input age: ");
        Integer age = sc.nextInt();
        System.out.print("Input personalIdentificationCode: ");
        String peronalIdentificationCode = sc.next();
        System.out.print("Input phonenumber: ");
        String phonenumber = sc.next();

        try {
            patientService.addPatient(id, name, age, peronalIdentificationCode, phonenumber);
        } catch (RepositoryException re) {
            System.out.println(re.getMessage());
        }
    }

    public void addAppointment() {

        Scanner sc = new Scanner(System.in);
        System.out.print("Input dentist id: ");
        Integer dentistid = sc.nextInt();
        System.out.print("Input dentist name: ");
        String dentistname = sc.next();
        System.out.print("Input dentist rating: ");
        Double dentistrating = sc.nextDouble();
        Dentist dentist = new Dentist(null, null, null);
        try {
            dentist = new Dentist(dentistname, dentistrating, dentistid);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }


        System.out.print("Input patient id: ");
        Integer patientid = sc.nextInt();
        System.out.print("Input patient name: ");
        String patientname = sc.next();
        System.out.print("Input patient age: ");
        Integer patientage = sc.nextInt();
        System.out.print("Input patient personalIdentificationCode: ");
        String patientperonalIdentificationCode = sc.next();
        System.out.print("Input patient phonenumber: ");
        String patientphonenumber = sc.next();

        Patient patient = new Patient(null, null, null, null, null);
        try {
            patient = new Patient(patientname, patientage, patientperonalIdentificationCode, patientphonenumber, patientid);

        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }

        System.out.print("Input apointment details: ");
        String appointmentdetails = sc.next();
        System.out.print("Input patient name: ");
        String appointmentdate = sc.next();
        System.out.print("Input patient age: ");
        Integer appointmentduration = sc.nextInt();
        System.out.print("Input patient personalIdentificationCode: ");
        Integer appointmentid = sc.nextInt();

        Appointment appointment = new Appointment(null, null, null, null, null, null);
        try {
            appointment = new Appointment(appointmentdetails, appointmentdate, appointmentduration, appointmentid, dentist, patient);
        } catch (RuntimeException re) {
            System.out.println(re.getMessage());
        }
    }


    public void printall() {

        Iterable<Dentist> iterated1 = dentistservice.getALL();
        Iterable<Patient> iterated2 = patientService.getALL();
        Iterable<Appointment> iterated3 = appointmentService.getALL();

        System.out.println("\nDentists:\n");
        for (Dentist dentist : iterated1) {
            System.out.println(dentist);
        }
        System.out.println("\nPatients:\n");
        for (Patient patient : iterated2) {
            System.out.println(patient);
        }
        System.out.println("\nAppointments:\n");
        for (Appointment appointment : iterated3) {
            System.out.println(appointment);
        }

    }


    public void showAppointments() {
        Iterable<Appointment> iterated = appointmentService.getALL();
        Iterator<Appointment> i = iterated.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public void showDentists() {

        Iterable<Dentist> iterated = dentistservice.getALL();
        Iterator<Dentist> i = iterated.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }

    public void showPatients() {
        Iterable<Patient> iterated = patientService.getALL();
        Iterator<Patient> i = iterated.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

    public ArrayList<Appointment> laterdate(String date) {
        var pred = new ArrayList<Appointment>();
        // Predicate<Appointment> laterdate= exp->exp.getDate().compareTo(date);
        // ((ArrayList<Appointment>)this.appointmentService.getALL()).stream().filter(laterdate).forEach(pred::add);
        return pred;
    }

    public void sortDentistbyName() {

        this.dentistservice.sortDentistsByName();

        Iterable<Dentist> iterated = dentistservice.getALL();
        Iterator<Dentist> i = iterated.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

    public void sortDentistbyRating() {

        this.dentistservice.sortDentistsByRating();

        Iterable<Dentist> iterated = dentistservice.getALL();
        Iterator<Dentist> i = iterated.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

    public void sortPatientbyName() {

        this.patientService.sortPatientByName();

        Iterable<Patient> iterated = patientService.getALL();
        Iterator<Patient> i = iterated.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

    public void sortAppointmentsbyDate() {

        this.appointmentService.sortAppointmentsByName();

        Iterable<Appointment> iterated = appointmentService.getALL();
        Iterator<Appointment> i = iterated.iterator();
        while (i.hasNext()) {
            System.out.println(i.next());
        }

    }

    public void deletePatientbyID() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input patient id: ");
        Integer patientid = sc.nextInt();

        Patient patient = null;
        try {
            patient = this.patientService.getById(patientid);
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }

        try {
            this.serviceController.removePatients(patient);
        } catch (RepositoryException re) {
            System.out.println(re.getMessage());
        }


    }

    public void deleteDentistbyID() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Input dentist id: ");
        Integer dentistid = sc.nextInt();

        Dentist dentist = null;
        try {
            dentist = this.dentistservice.getById(dentistid);

        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }
        try {
            this.serviceController.removeDentists(dentist);
        } catch (RepositoryException re) {
            System.out.println(re.getMessage());
        }


    }

    public void deleteAppointmentbyId() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Input appointmentId: ");
        Integer appointmentid = sc.nextInt();

        Appointment appointment = null;

        for (Appointment appointment1 : appointmentService.getALL()) {
            if (appointment1.getId().equals(appointmentid)) {
                appointment = appointment1;
                System.out.println(appointment);
                break;
            }
        }


        try {
            this.serviceController.removeAppointment(appointment);
        } catch (RepositoryException re) {
            System.out.println(re.getMessage());
        }

    }

    public void callTests() {
        TestController testController = new TestController();
        testController.setUp();

        testController.addPatients();
        testController.addDentists();
        testController.addAppointment();

        testController.getNumberOfPatients();
        testController.getNumberOfDentists();
        testController.getNumberOfAppointments();

        testController.hasPatient();
        testController.hasDentist();
        testController.hasAppointment();


        testController.removePatients();
        testController.removeDentists();
        testController.removeAppointment();

    }


    public void add_Patients_to_file_csv() {
        PatientRepositoryCSV patientRepositoryCSV = new PatientRepositoryCSV("LabHomework/SavedFiles/patients.csv");

        for (Patient patient : this.patientService.getALL())
            patientRepositoryCSV.add(patient);


    }

    public void load_Patients_from_file_csv() {

        PatientRepositoryCSV patientRepositoryCSV = new PatientRepositoryCSV("LabHomework/SavedFiles/patients.csv");

        patientRepositoryCSV.readFromFile();
        for (Patient patient : patientRepositoryCSV.getAll()) {
            System.out.println(patient);
        }


    }


    public void add_Dentists_to_file_csv() {
        DentistRepositoryCSV dentistRepositoryCSV = new DentistRepositoryCSV("LabHomework/SavedFiles/dentists.csv");

        for (Dentist dentist : this.dentistservice.getALL())
            dentistRepositoryCSV.add(dentist);


    }

    public void load_Dentists_from_file_csv() {

        DentistRepositoryCSV dentistRepositoryCSV = new DentistRepositoryCSV("LabHomework/SavedFiles/dentists.csv");

        dentistRepositoryCSV.readFromFile();
        for (Dentist dentist : dentistRepositoryCSV.getAll()) {
            System.out.println(dentist);
        }


    }

    public void add_Appointments_to_file_csv() {
        AppointmentsRepositoryCSV appointmentsRepositoryCSV = new AppointmentsRepositoryCSV("LabHomework/SavedFiles/appointments.csv");

        for (Appointment appointment : this.appointmentService.getALL())
            appointmentsRepositoryCSV.add(appointment);


    }

    public void load_Appointments_from_file_csv() {

        AppointmentsRepositoryCSV appointmentsRepositoryCSV = new AppointmentsRepositoryCSV("LabHomework/SavedFiles/appointments.csv");

        appointmentsRepositoryCSV.readFromFile();
        for (Appointment appointment : appointmentsRepositoryCSV.getAll()) {
            System.out.println(appointment);
        }


    }

    public void add_Patients_to_file_bin() {

        PatientRepositoryBinary patientRepositoryBinary = new PatientRepositoryBinary("LabHomework/SavedFiles/patients.bin");

        for (Patient patient : this.patientService.getALL())
            patientRepositoryBinary.add(patient);


    }

    public void load_Patients_from_file_bin() {
        PatientRepositoryBinary patientRepositoryBinary = new PatientRepositoryBinary("LabHomework/SavedFiles/patients.bin");
        patientRepositoryBinary.readFromFile();
        for (Patient patient : patientRepositoryBinary.getAll()) {
            System.out.println(patient);
        }
    }

    public void add_Dentists_to_file_bin() {
        DentistRepositoryBinary dentistRepositoryBinary = new DentistRepositoryBinary("LabHomework/SavedFiles/dentists.bin");

        for (Dentist dentist : this.dentistservice.getALL())
            dentistRepositoryBinary.add(dentist);


    }

    public void load_Dentists_from_file_bin() {

        DentistRepositoryBinary dentistRepositoryBinary = new DentistRepositoryBinary("LabHomework/SavedFiles/dentists.bin");
        dentistRepositoryBinary.readFromFile();
        for (Dentist dentist : dentistRepositoryBinary.getAll()) {
            System.out.println(dentist);
        }
    }

    public void add_Appointments_to_file_bin() {
        AppointmentsRepositoryBinary appointmentsRepositoryBinary = new AppointmentsRepositoryBinary("LabHomework/SavedFiles/appointments.bin");

        for (Appointment appointment : this.appointmentService.getALL())
            appointmentsRepositoryBinary.add(appointment);

    }

    public void load_Appointments_from_file_bin() {

        AppointmentsRepositoryBinary appointmentsRepositoryBinary = new AppointmentsRepositoryBinary("LabHomework/SavedFiles/appointments.bin");
        appointmentsRepositoryBinary.readFromFile();
        for (Appointment appointment : appointmentsRepositoryBinary.getAll()) {
            System.out.println(appointment);
        }
    }

    public void save_Patients_to_file_Properties() {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        repositoryLoader.loadConfig();

        System.out.println("Saving patients Mode:" + repositoryLoader.getRepositoryMode());

        if (repositoryLoader.getRepositoryMode().equals("binary")) {
            PatientRepositoryBinary patientRepositoryBinary = new PatientRepositoryBinary(repositoryLoader.getPatientsPath());
            patientRepositoryBinary.setRepository((ArrayList<Patient>) this.patientService.getALL());
            patientRepositoryBinary.writeToFile();

        } else if (repositoryLoader.getRepositoryMode().equals("csv")) {
            PatientRepositoryCSV patientRepositoryCSV = new PatientRepositoryCSV(repositoryLoader.getPatientsPath());
            patientRepositoryCSV.setRepository((ArrayList<Patient>) this.patientService.getALL());
            patientRepositoryCSV.writeToFile();

        }


    }

    public void load_Patients_from_file_Properties() {

        RepositoryLoader repositoryLoader = new RepositoryLoader();
        repositoryLoader.loadConfig();

        System.out.println("Loading patients Mode:" + repositoryLoader.getRepositoryMode());

        if (repositoryLoader.getRepositoryMode().equals("binary")) {
            PatientRepositoryBinary patientRepositoryBinary = new PatientRepositoryBinary(repositoryLoader.getPatientsPath());

            patientRepositoryBinary.readFromFile();

            PatientRepository patientRepository = new PatientRepository();
            patientRepository.setRepository((ArrayList<Patient>) patientRepositoryBinary.getAll());
            this.patientService = new PatientService(patientRepository);
            for (Patient patient : patientRepositoryBinary.getAll()) {
                System.out.println(patient);
            }

        } else if (repositoryLoader.getRepositoryMode().equals("csv")) {
            PatientRepositoryCSV patientRepositoryCSV = new PatientRepositoryCSV(repositoryLoader.getPatientsPath());

            patientRepositoryCSV.readFromFile();

            PatientRepository patientRepository = new PatientRepository();
            patientRepository.setRepository((ArrayList<Patient>) patientRepositoryCSV.getAll());
            this.patientService = new PatientService(patientRepository);
            for (Patient patient : patientRepositoryCSV.getAll()) {
                System.out.println(patient);
            }

        }
    }

    public void save_Dentists_to_file_Properties() {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        repositoryLoader.loadConfig();

        System.out.println("Saving dentists Mode:" + repositoryLoader.getRepositoryMode());

        if (repositoryLoader.getRepositoryMode().equals("binary")) {
            DentistRepositoryBinary dentistRepositoryBinary = new DentistRepositoryBinary(repositoryLoader.getDentistsPath());
            dentistRepositoryBinary.setRepository((ArrayList<Dentist>) this.dentistservice.getALL());
            dentistRepositoryBinary.writeToFile();

        } else if (repositoryLoader.getRepositoryMode().equals("csv")) {
            DentistRepositoryCSV dentistRepositoryCSV = new DentistRepositoryCSV(repositoryLoader.getDentistsPath());
            dentistRepositoryCSV.setRepository((ArrayList<Dentist>) this.dentistservice.getALL());
            dentistRepositoryCSV.writeToFile();

        }

    }

    public void load_Dentists_from_file_Properties() {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        repositoryLoader.loadConfig();

        System.out.println("Loading dentists Mode:" + repositoryLoader.getRepositoryMode());

        if (repositoryLoader.getRepositoryMode().equals("binary")) {
            DentistRepositoryBinary dentistRepositoryBinary = new DentistRepositoryBinary(repositoryLoader.getDentistsPath());

            dentistRepositoryBinary.readFromFile();

            DentistRepository dentistRepository = new DentistRepository();
            dentistRepository.setRepository((ArrayList<Dentist>) dentistRepositoryBinary.getAll());
            this.dentistservice = new DentistService(dentistRepository);
            for (Dentist dentist : dentistRepositoryBinary.getAll()) {
                System.out.println(dentist);
            }

        } else if (repositoryLoader.getRepositoryMode().equals("csv")) {
            DentistRepositoryCSV dentistRepositoryCSV = new DentistRepositoryCSV(repositoryLoader.getDentistsPath());

            dentistRepositoryCSV.readFromFile();

            DentistRepository dentistRepository = new DentistRepository();
            dentistRepository.setRepository((ArrayList<Dentist>) dentistRepositoryCSV.getAll());
            this.dentistservice = new DentistService(dentistRepository);
            for (Dentist dentist : dentistRepositoryCSV.getAll()) {
                System.out.println(dentist);
            }

        }

    }

    public void save_Appointments_to_file_Properties() {

        RepositoryLoader repositoryLoader = new RepositoryLoader();
        repositoryLoader.loadConfig();

        System.out.println("Saving appointments Mode:" + repositoryLoader.getRepositoryMode());

        if (repositoryLoader.getRepositoryMode().equals("binary")) {
            AppointmentsRepositoryBinary appointmentsRepositoryBinary = new AppointmentsRepositoryBinary(repositoryLoader.getAppointmentsPath());
            appointmentsRepositoryBinary.setRepository((ArrayList<Appointment>) this.appointmentService.getALL());
            appointmentsRepositoryBinary.writeToFile();

        } else if (repositoryLoader.getRepositoryMode().equals("csv")) {
            AppointmentsRepositoryCSV appointmentsRepositoryCSV = new AppointmentsRepositoryCSV(repositoryLoader.getAppointmentsPath());
            appointmentsRepositoryCSV.setRepository((ArrayList<Appointment>) this.appointmentService.getALL());
            appointmentsRepositoryCSV.writeToFile();

        }

    }

    public void load_Appointments_from_file_Properties() {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        repositoryLoader.loadConfig();

        System.out.println("Loading appointments Mode:" + repositoryLoader.getRepositoryMode());

        if (repositoryLoader.getRepositoryMode().equals("binary")) {
            AppointmentsRepositoryBinary appointmentsRepositoryBinary = new AppointmentsRepositoryBinary(repositoryLoader.getAppointmentsPath());

            appointmentsRepositoryBinary.readFromFile();

            AppointmentRepository appointmentRepository = new AppointmentRepository();
            appointmentRepository.setRepository((ArrayList<Appointment>) appointmentsRepositoryBinary.getAll());
            this.appointmentService = new AppointmentService(appointmentRepository);
            for (Appointment appointment : appointmentsRepositoryBinary.getAll()) {
                System.out.println(appointment);
            }

        } else if (repositoryLoader.getRepositoryMode().equals("csv")) {
            AppointmentsRepositoryCSV appointmentsRepositoryCSV = new AppointmentsRepositoryCSV(repositoryLoader.getAppointmentsPath());

            appointmentsRepositoryCSV.readFromFile();

            AppointmentRepository appointmentRepository = new AppointmentRepository();
            appointmentRepository.setRepository((ArrayList<Appointment>) appointmentsRepositoryCSV.getAll());
            this.appointmentService = new AppointmentService(appointmentRepository);
            for (Appointment appointment : appointmentsRepositoryCSV.getAll()) {
                System.out.println(appointment);
            }

        }

    }

    public void save_ALL_to_file_Properties() {

        RepositoryLoader repositoryLoader = new RepositoryLoader();
        repositoryLoader.loadConfig();

        System.out.println("Saving all to files Mode:" + repositoryLoader.getRepositoryMode());

        save_Patients_to_file_Properties();
        save_Dentists_to_file_Properties();
        save_Appointments_to_file_Properties();


    }

    public void load_ALL_from_file_Properties() {
        RepositoryLoader repositoryLoader = new RepositoryLoader();
        repositoryLoader.loadConfig();

        System.out.println("Loading all from files Mode:" + repositoryLoader.getRepositoryMode());

        load_Patients_from_file_Properties();
        load_Dentists_from_file_Properties();
        load_Appointments_from_file_Properties();

    }

    private void filterStream1() {

        System.out.println("Sorting appointment by dates...");
        List<Appointment> appointmentList = this.serviceController.getAppointments().stream().sorted(new CompareByDateAppointment()).toList();
        for (Appointment appointment : appointmentList) {
            System.out.println(appointment);

        }
    }

    private void filterStream2() {

        System.out.println("Sorting appointment by details...");
        List<Appointment> appointmentList = this.serviceController.getAppointments().stream().sorted(new CompareByDetailsAppointment()).toList();
        for (Appointment appointment : appointmentList) {
            System.out.println(appointment);

        }


    }

    private void filterStream3() {

        System.out.println("Sorting dentists by name...");
        List<Dentist> dentistList = this.serviceController.getDentists().stream().sorted(new CompareByNameDentist()).toList();
        for (Dentist dentist : dentistList) {
            System.out.println(dentist);

        }


    }

    private void filterStream4() {

        System.out.println("Sorting dentists by rating...");
        List<Dentist> dentistList = this.serviceController.getDentists().stream().sorted(new CompareByRatingDentist()).toList();
        for (Dentist dentist : dentistList) {
            System.out.println(dentist);

        }

    }

    private void filterStream5() {

        System.out.println("Sorting patients by name...");
        List<Patient> patientList = this.serviceController.getPatients().stream().sorted(new CompareByNamePatient()).toList();
        for (Patient patient : patientList) {
            System.out.println(patient);

        }

    }
    private void readfromDatabase()
    {
        PatientRepositoryDB patientRepositoryDB =new PatientRepositoryDB("jdbc:sqlite:LabHomework/SavedFiles/Database.db");
        DentistRepositoryDB dentistRepositoryDB =new DentistRepositoryDB("jdbc:sqlite:LabHomework/SavedFiles/Database.db");
        AppointmentRepositoryDB appointmentRepositoryDB =new AppointmentRepositoryDB("jdbc:sqlite:LabHomework/SavedFiles/Database.db");


    }
    private void writetoDatabase()
    {

        PatientRepositoryDB patientRepositoryDB = new PatientRepositoryDB("jdbc:sqlite:LabHomework/SavedFiles/Database.db");
        patientRepositoryDB.setRepository((ArrayList<Patient>) this.patientService.getALL());
        patientRepositoryDB.writeToFile();

        DentistRepositoryDB dentistRepositoryDB =new DentistRepositoryDB("jdbc:sqlite:LabHomework/SavedFiles/Database.db");
        dentistRepositoryDB.setRepository((ArrayList<Dentist>) this.dentistservice.getALL());
        dentistRepositoryDB.writeToFile();

        AppointmentRepositoryDB appointmentRepositoryDB =new AppointmentRepositoryDB("jdbc:sqlite:LabHomework/SavedFiles/Database.db");
        appointmentRepositoryDB.setRepository((ArrayList<Appointment>) this.appointmentService.getALL());
        appointmentRepositoryDB.writeToFile();


    }


    public void menu() {
        System.out.println("-------------");
        System.out.println("1.AddDentist\n2.AddPatient\n3.AddAppointment\n4.PrintALL\n5.DeletePatientByID");
        System.out.println("6.DeleteDentistByID\n7.DeleteAppointmentById\n8.ShowDentistsSortedByName");
        System.out.println("9.ShowDentistSortedByRating\n10.ShowPatientsSortedByName\n11.ShowAppointmentsSortedByDate");
        System.out.println("12.ShowPatients\n13.ShowDentists\n14.ShowAppointments\n15.CallTests\n16.SavePatientCSV");
        System.out.println("17.LoadPatientsCSV\n18.SaveDentistsCSV\n19.LoadDentistsCSV\n20.SaveAppointmentsCSV");
        System.out.println("21.LoadAppointmentsCSV\n22.SavePatientsBIN\n23.LoadPatientsBIN\n24.SaveDentistsBIN");
        System.out.println("25.LoadDentistsBIN\n26.SaveAppointmentsBIN\n27.LoadAppointmentsBIN");
        System.out.println("28.SavePatientsProperties\n29.LoadPatientsProperties\n30.SaveDentistsProperties");
        System.out.println("31.LoadDentistsProperties\n32.SaveAppointmentsProperties\n33.LoadAppointmentsProperties");
        System.out.println("34.SaveALLProperties\n35.LoadALLProperties");
        System.out.println("36.FilterStream1\n37.FilterStream2");
        System.out.println("38.FilterStream3\n39.FilterStream4");
        System.out.println("40.FilterStream5\n41.ReadFromDatabase");
        System.out.println("42.SaveToDatabase");
        System.out.println("43.Exit\n\n----------------");
    }


    public void main() {

        while (true) {
            menu();
            Scanner sc = new Scanner(System.in);
            System.out.println("Input your option:");

            int option = sc.nextInt();
            switch (option) {
                case 1 -> addDentist();
                case 2 -> addPatient();
                case 3 -> addAppointment();
                case 4 -> printall();
                case 5 -> deletePatientbyID();
                case 6 -> deleteDentistbyID();
                case 7 -> deleteAppointmentbyId();
                case 8 -> sortDentistbyName();
                case 9 -> sortDentistbyRating();
                case 10 -> sortPatientbyName();
                case 11 -> sortAppointmentsbyDate();
                case 12 -> showPatients();
                case 13 -> showDentists();
                case 14 -> showAppointments();
                case 15 -> callTests();
                case 16 -> add_Patients_to_file_csv();
                case 17 -> load_Patients_from_file_csv();
                case 18 -> add_Dentists_to_file_csv();
                case 19 -> load_Dentists_from_file_csv();
                case 20 -> add_Appointments_to_file_csv();
                case 21 -> load_Appointments_from_file_csv();
                case 22 -> add_Patients_to_file_bin();
                case 23 -> load_Patients_from_file_bin();
                case 24 -> add_Dentists_to_file_bin();
                case 25 -> load_Dentists_from_file_bin();
                case 26 -> add_Appointments_to_file_bin();
                case 27 -> load_Appointments_from_file_bin();
                case 28 -> save_Patients_to_file_Properties();
                case 29 -> load_Patients_from_file_Properties();
                case 30 -> save_Dentists_to_file_Properties();
                case 31 -> load_Dentists_from_file_Properties();
                case 32 -> save_Appointments_to_file_Properties();
                case 33 -> load_Appointments_from_file_Properties();
                case 34 -> save_ALL_to_file_Properties();
                case 35 -> load_ALL_from_file_Properties();
                case 36 -> filterStream1();
                case 37 -> filterStream2();
                case 38 -> filterStream3();
                case 39 -> filterStream4();
                case 40 -> filterStream5();
                case 41 ->readfromDatabase();
                case 42 ->writetoDatabase();


                case 43 -> {
                    System.out.println("Program stopped.");
                    return;
                }


            }

        }


    }


}
