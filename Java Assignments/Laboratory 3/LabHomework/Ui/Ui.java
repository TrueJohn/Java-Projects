package LabHomework.Ui;

import LabHomework.Domain.*;
import LabHomework.Exception.RepositoryException;
import LabHomework.Files.*;
import LabHomework.Service.AppointmentService;
import LabHomework.Service.DentistService;
import LabHomework.Service.PatientService;
import LabHomework.Service.RepositoryLoader;
import LabHomework.Tests.TestController;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.Iterator;
import java.util.Scanner;

public class Ui {

    private final DentistService dentistservice;

    private final AppointmentService appointmentService;
    private final PatientService patientService;

    public Ui(AppointmentService appointmentService, DentistService dentistservice, PatientService patientservice) {
        this.appointmentService = appointmentService;
        this.dentistservice = dentistservice;
        this.patientService = patientservice;
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

    public void deletePatient() {
        Scanner sc = new Scanner(System.in);
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

        try {
            this.patientService.deletePatient(patient);
        } catch (RepositoryException re) {
            System.out.println(re.getMessage());
        }


    }

    public void deleteDentist() {
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
        try {
            this.dentistservice.removeDentist(dentist);
        } catch (RepositoryException re) {
            System.out.println(re.getMessage());
        }


    }

    public void deleteAppointment() {

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
        try {
            this.appointmentService.removeAppointment(appointment);
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


    public void add_Patients_to_file_csv()
    {
        PatientRepositoryCSV patientRepositoryCSV=new PatientRepositoryCSV("LabHomework/SavedFiles/patients.csv");

        for(Patient patient:this.patientService.getALL())
            patientRepositoryCSV.add(patient);



    }

    public void load_Patients_from_file_csv()
    {

        PatientRepositoryCSV patientRepositoryCSV=new PatientRepositoryCSV("LabHomework/SavedFiles/patients.csv");

        patientRepositoryCSV.readFromFile();
        for (Patient patient:patientRepositoryCSV.getAll())
        {
            System.out.println(patient);
        }


    }



    public void add_Dentists_to_file_csv()
    {
        DentistRepositoryCSV dentistRepositoryCSV=new DentistRepositoryCSV("LabHomework/SavedFiles/dentists.csv");

        for(Dentist dentist:this.dentistservice.getALL())
            dentistRepositoryCSV.add(dentist);



    }

    public void load_Dentists_from_file_csv()
    {

        DentistRepositoryCSV dentistRepositoryCSV=new DentistRepositoryCSV("LabHomework/SavedFiles/dentists.csv");

        dentistRepositoryCSV.readFromFile();
        for (Dentist dentist:dentistRepositoryCSV.getAll())
        {
            System.out.println(dentist);
        }



    }
    public void add_Appointments_to_file_csv()
    {
        AppointmentsRepositoryCSV appointmentsRepositoryCSV=new AppointmentsRepositoryCSV("LabHomework/SavedFiles/appointments.csv");

        for(Appointment appointment:this.appointmentService.getALL())
            appointmentsRepositoryCSV.add(appointment);



    }

    public void load_Appointments_from_file_csv()
    {

        AppointmentsRepositoryCSV appointmentsRepositoryCSV=new AppointmentsRepositoryCSV("LabHomework/SavedFiles/appointments.csv");

        appointmentsRepositoryCSV.readFromFile();
        for (Appointment appointment:appointmentsRepositoryCSV.getAll())
        {
            System.out.println(appointment);
        }



    }
    public void add_Patients_to_file_bin()
    {

        PatientRepositoryBinary patientRepositoryBinary =new PatientRepositoryBinary("LabHomework/SavedFiles/patients.bin");

        for(Patient patient:this.patientService.getALL())
            patientRepositoryBinary.add(patient);


    }
    public void load_Patients_from_file_bin()
    {
        PatientRepositoryBinary patientRepositoryBinary =new PatientRepositoryBinary("LabHomework/SavedFiles/patients.bin");
        patientRepositoryBinary.readFromFile();
        for(Patient patient:patientRepositoryBinary.getAll())
        {
            System.out.println(patient);
        }
    }

    public void add_Dentists_to_file_bin()
    {
        DentistRepositoryBinary dentistRepositoryBinary =new DentistRepositoryBinary("LabHomework/SavedFiles/dentists.bin");

        for(Dentist dentist:this.dentistservice.getALL())
            dentistRepositoryBinary.add(dentist);


    }
    public void load_Dentists_from_file_bin()
    {

        DentistRepositoryBinary dentistRepositoryBinary =new DentistRepositoryBinary("LabHomework/SavedFiles/dentists.bin");
        dentistRepositoryBinary.readFromFile();
        for(Dentist dentist:dentistRepositoryBinary.getAll())
        {
            System.out.println(dentist);
        }
    }

    public void add_Appointments_to_file_bin()
    {
        AppointmentsRepositoryBinary appointmentsRepositoryBinary=new AppointmentsRepositoryBinary("LabHomework/SavedFiles/appointments.bin");

        for(Appointment appointment:this.appointmentService.getALL())
            appointmentsRepositoryBinary.add(appointment);

    }
    public void load_Appointments_from_file_bin()
    {

        AppointmentsRepositoryBinary appointmentsRepositoryBinary=new AppointmentsRepositoryBinary("LabHomework/SavedFiles/appointments.bin");
        appointmentsRepositoryBinary.readFromFile();
        for(Appointment appointment:appointmentsRepositoryBinary.getAll())
        {
            System.out.println(appointment);
        }
    }


    public void menu() {
        System.out.println("-------------");
        System.out.println("1.AddDentist\n2.AddPatient\n3.AddAppointment\n4.PrintALL\n5.DeleteDentist");
        System.out.println("6.DeletePatient\n7.DeleteAppointment\n8.ShowDentistsSortedByName");
        System.out.println("9.ShowDentistSortedByRating\n10.ShowPatientsSortedByName\n11.ShowAppointmentsSortedByDate");
        System.out.println("12.ShowPatients\n13.ShowDentists\n14.ShowAppointments\n15.CallTests\n16.SavePatientCSV");
        System.out.println("17.LoadPatientsCSV\n18.SaveDentistsCSV\n19.LoadDentistsCSV\n20.SaveAppointmentsCSV");
        System.out.println("21.LoadAppointmentsCSV\n22.SavePatientsBIN\n23.LoadPatientsBIN\n24.SaveDentistsBIN");
        System.out.println("25.LoadDentistsBIN\n26.SaveAppointmentsBIN\n27.LoadAppointmentsBIN");
        System.out.println("28.Exit\n\n----------------");
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
                case 5 -> deleteDentist();
                case 6 -> deletePatient();
                case 7 -> deleteAppointment();
                case 8 -> sortDentistbyName();
                case 9 -> sortDentistbyRating();
                case 10 -> sortPatientbyName();
                case 11 -> sortAppointmentsbyDate();
                case 12 -> showPatients();
                case 13 -> showDentists();
                case 14 -> showAppointments();
                case 15 -> callTests();
                case 16 ->add_Patients_to_file_csv();
                case 17 ->load_Patients_from_file_csv();
                case 18 ->add_Dentists_to_file_csv();
                case 19 ->load_Dentists_from_file_csv();
                case 20 ->add_Appointments_to_file_csv();
                case 21 ->load_Appointments_from_file_csv();
                case 22 ->add_Patients_to_file_bin();
                case 23 ->load_Patients_from_file_bin();
                case 24 ->add_Dentists_to_file_bin();
                case 25 ->load_Dentists_from_file_bin();
                case 26 ->add_Appointments_to_file_bin();
                case 27 ->load_Appointments_from_file_bin();
                case 28 -> {
                    System.out.println("Program stopped.");
                    return;
                }


            }

        }


    }


}
