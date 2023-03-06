package com.example.javafxapp;

import com.example.Domain.*;
import com.example.Exception.RepositoryException;
import com.example.Repository.AppointmentRepository;
import com.example.Repository.DentistRepository;
import com.example.Repository.PatientRepository;
import com.example.Service.AppointmentService;
import com.example.Service.DentistService;
import com.example.Service.PatientService;
import com.example.Service.ServiceController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.util.List;
import java.util.Objects;


public class HelloController {


    private ServiceController serviceController;

    @FXML
    private Label patientlabel1;



    @FXML
    private TextField patient_id;

    @FXML
    private TextField patient_name;

    @FXML
    private TextField patient_age;

    @FXML
    private TextField patient_phone;

    @FXML
    private TextField patient_identification_number;


    @FXML
    private Label dentistlabel1;

    @FXML
    private TextField dentist_id;

    @FXML
    private TextField dentist_name;

    @FXML
    private TextField dentist_rating;


    @FXML
    private TextField patient_id2;

    @FXML
    private TextField patient_name2;

    @FXML
    private TextField patient_age2;

    @FXML
    private TextField patient_phone2;

    @FXML
    private TextField patient_identification_number2;


    @FXML
    private TextField dentist_id2;

    @FXML
    private TextField dentist_name2;

    @FXML
    private TextField dentist_rating2;


    @FXML
    private TextField appointment_id;

    @FXML
    private TextField appointment_date;

    @FXML
    private TextField appointment_duration;

    @FXML
    private TextField appointment_details;


    @FXML
    private TextField patient_id3;

    @FXML
    private TextField dentist_id3;

    @FXML
    private TextField appointment_id2;

    @FXML
    private Label appointmentsdeletelabel;



    @FXML
    private Label appointmentslabel;


    @FXML
    private Label sortlabel;


    public HelloController(){

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
        ServiceController serviceController= new ServiceController(appointmentService,dentistService,patientService);




        this.serviceController = serviceController;

    }



    @FXML
    protected void onHelloButtonClick1() {


            Integer patient_id = Integer.parseInt(this.patient_id.getText());
            String patient_name=this.patient_name.getText();
            Integer patient_age = Integer.parseInt(this.patient_age.getText());
            String patient_phone=this.patient_phone.getText();
            String patient_identification_numnber=this.patient_identification_number.getText();


        try {
            this.serviceController.patientService.addPatient(patient_id,patient_name,patient_age,patient_identification_numnber,patient_phone);

        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    protected void onHelloButtonClick2() {


        Iterable<Patient> iterated = this.serviceController.patientService.getALL();

        String s="";
        for (Patient patient : iterated) {

            s=s+patient+"\n";

        }
        patientlabel1.setText(s);

    }

    @FXML
    protected void onHelloButtonClick3() {


        Integer dentist_id = Integer.parseInt(this.dentist_id.getText());
        String dentist_name=this.dentist_name.getText();
        Double dentist_rating=Double.parseDouble(this.dentist_rating.getText());


        try {
            this.serviceController.dentistService.addDentist(dentist_id,dentist_name,dentist_rating);

        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }

    }


    @FXML
    protected void onHelloButtonClick4() {


        Iterable<Dentist> iterated = this.serviceController.dentistService.getALL();

        String s="";
        for (Dentist dentist : iterated) {

            s=s+dentist+"\n";

        }
        dentistlabel1.setText(s);

    }

    @FXML
    protected void addappointmentsclick() {


        Integer patient_id = Integer.parseInt(this.patient_id2.getText());
        String patient_name=this.patient_name2.getText();
        Integer patient_age = Integer.parseInt(this.patient_age2.getText());
        String patient_phone=this.patient_phone2.getText();
        String patient_identification_number=this.patient_identification_number2.getText();



        Patient patient=new Patient(patient_name, patient_age, patient_identification_number, patient_phone, patient_id);





        Integer dentist_id = Integer.parseInt(this.dentist_id2.getText());
        String dentist_name=this.dentist_name2.getText();
        Double dentist_rating=Double.parseDouble(this.dentist_rating2.getText());



        Dentist dentist=new Dentist(dentist_name, dentist_rating, dentist_id);




        Integer appointment_id = Integer.parseInt(this.appointment_id.getText());
        String appointment_date=this.appointment_date.getText();
        Integer appointment_duration=Integer.parseInt(this.appointment_duration.getText());
        String appointment_details=this.appointment_details.getText();


        try {
            this.serviceController.appointmentService.addAppointment(appointment_details,appointment_date,appointment_duration,appointment_id,dentist,patient);
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }


    }


    @FXML
    protected void showappointmentsclick() {


        Iterable<Appointment> iterated = this.serviceController.appointmentService.getALL();

        String s="";
        for (Appointment appointment : iterated) {

            s=s+appointment+"\n";

        }
        appointmentslabel.setText(s);

    }




    @FXML
    protected void onClickSort1() {


        String s="";

        List<Appointment> appointmentList = this.serviceController.getAppointments().stream().sorted(new CompareByDateAppointment()).toList();
        for (Appointment appointment : appointmentList) {
            s=s+appointment+"\n";

        }

        sortlabel.setText(s);

    }
    @FXML
    protected void onClickSort2() {


        String s="";

        List<Appointment> appointmentList = this.serviceController.getAppointments().stream().sorted(new CompareByDetailsAppointment()).toList();
        for (Appointment appointment : appointmentList) {
            s=s+appointment+"\n";

        }

        sortlabel.setText(s);
    }
    @FXML
    protected void onClickSort3() {


        String s="";

        List<Dentist> dentistList = this.serviceController.getDentists().stream().sorted(new CompareByNameDentist()).toList();
        for (Dentist dentist : dentistList) {
            s=s+dentist+"\n";

        }

        sortlabel.setText(s);

    }

    @FXML
    protected void onClickSort4() {


        String s="";

        List<Dentist> dentistList = this.serviceController.getDentists().stream().sorted(new CompareByRatingDentist()).toList();
        for (Dentist dentist : dentistList) {
            s=s+dentist+"\n";

        }

        sortlabel.setText(s);

    }

    @FXML
    protected void onClickSort5() {


        String s="";

        List<Patient> patientList = this.serviceController.getPatients().stream().sorted(new CompareByNamePatient()).toList();
        for (Patient patient : patientList) {
            s=s+patient+"\n";

        }

        sortlabel.setText(s);

    }


    @FXML
    protected void showappointmentsclickdelete() {


        Iterable<Appointment> iterated = this.serviceController.appointmentService.getALL();

        String s="";
        for (Appointment appointment : iterated) {

            s=s+appointment+"\n";

        }
        appointmentsdeletelabel.setText(s);

    }

    @FXML
    protected void showdentistclickdelete() {


        Iterable<Dentist> iterated = this.serviceController.dentistService.getALL();

        String s="";
        for (Dentist dentist : iterated) {

            s=s+dentist+"\n";

        }
        appointmentsdeletelabel.setText(s);

    }

    @FXML
    protected void showpatientclickdelete() {


        Iterable<Patient> iterated = this.serviceController.patientService.getALL();

        String s="";
        for (Patient patient : iterated) {

            s=s+patient+"\n";

        }
        appointmentsdeletelabel.setText(s);

    }

    @FXML
    protected void deletepatientbyId() {

        Integer patient_id = Integer.parseInt(this.patient_id3.getText());
        try {
            this.serviceController.patientService.deletePatient(this.serviceController.getPatient(patient_id));
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    protected void deletedentistbyId() {

        Integer dentist_id = Integer.parseInt(this.dentist_id3.getText());
        try {
            this.serviceController.dentistService.removeDentist(this.serviceController.getDentist(dentist_id));
        } catch (RepositoryException e) {
            throw new RuntimeException(e);
        }


    }
    @FXML
    protected void deleteappointmentbyId() {

        Integer appointment_id = Integer.parseInt(this.appointment_id2.getText());

        Iterable<Appointment> appointments= this.serviceController.appointmentService.getALL();
        AppointmentRepository appointmentRepository=new AppointmentRepository();
        for(Appointment appointment:appointments)
            if(!Objects.equals(appointment.getId(), appointment_id))
                appointmentRepository.add(appointment);




        AppointmentService appointmentService =new AppointmentService(appointmentRepository);
        this.serviceController.appointmentService=appointmentService;




    }



}