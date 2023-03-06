package LabHomework.Tests;

import LabHomework.Domain.Appointment;
import LabHomework.Domain.Dentist;
import LabHomework.Domain.Patient;
import LabHomework.Exception.InvalidParametersException;
import LabHomework.Exception.RepositoryException;
import LabHomework.Repository.AppointmentRepository;
import LabHomework.Repository.DentistRepository;
import LabHomework.Repository.PatientRepository;
import LabHomework.Service.AppointmentService;
import LabHomework.Service.DentistService;
import LabHomework.Service.PatientService;
import LabHomework.Service.ServiceController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class TestController {
    ServiceController controller;


    @BeforeEach
    public void setUp() {


        var patientService = new PatientService(new PatientRepository());
        var dentistService = new DentistService(new DentistRepository());
        var appointmentService = new AppointmentService(new AppointmentRepository());
        controller = new ServiceController(appointmentService, dentistService, patientService);
    }

    @Test
    public void addAppointment() {
        var dentist = new Dentist("Johnny", 8.0, 1);
        var patient = new Patient("Mona", 20, "1234567890123", "07123456", 1);
        try {
            controller.addDentists(dentist);
            controller.addPatients(patient);
            controller.addAppointment(dentist, patient, 2, 1, "20.11.2022", "no additional details");
        } catch (Exception e) {
            assert false;
        }

    }

    @Test
    public void removeAppointment() {
        var dentist = new Dentist("Johnny", 8.0, 1);
        var patient = new Patient("Mona", 20, "1234567890123", "07123456", 1);
        try {
            controller.addDentists(dentist);
            controller.addPatients(patient);
            controller.addAppointment(dentist, patient, 2, 1, "20.11.2022", "no additional details");
        } catch (Exception e) {
            assert false;
        }
        assert controller.getAppointments().size() == 1;
        try {
            controller.removeAppointment(controller.getAppointments().get(0));
        } catch (Exception e) {
            assert false;
        }
        assert controller.getAppointments().size() == 0;

    }

    @Test
    public void addDentists() {
        var dentist = new Dentist("Johnny", 8.0, 1);
        try {
            controller.addDentists(dentist);
            assert true;
        } catch (RepositoryException e) {
            assert false;
        }
        try {
            controller.addDentists(dentist);
            assert false;
        } catch (RepositoryException e) {
            assert true;
        }
        var dentist2 = new Dentist("Mark", 9.0, 2);
        try {
            controller.addDentists(dentist2);
            assert true;
        } catch (InvalidParametersException e) {
            assert true;
        } catch (RepositoryException e) {
            assert false;
        }
    }

    @Test
    public void addPatients() {
        var patient1 = new Patient("Alex", 23, "0001230000123", "07121234", 1);
        try {
            controller.addPatients(patient1);
            assert true;
        } catch (RepositoryException e) {
            assert false;
        }
        try {
            controller.addPatients(patient1);
            assert false;
        } catch (RepositoryException e) {
            assert true;
        }
        var patient2 = new Patient("Felix", 20, "1231231230123", "0712345", 2);
        try {
            controller.addPatients(patient2);
            assert true;
        } catch (InvalidParametersException e) {
            assert true;
        } catch (RepositoryException e) {
            assert false;
        }
    }

    @Test
    public void removeDentists() {
        Patient patient = new Patient("Alex", 23, "0001230000123", "07121234", 1);
        Dentist dentist = new Dentist("Johnny", 8.0, 1);
        Appointment appointment = new Appointment("no details ", "21.11.2022", 2, 1, dentist, patient);
        try {
            controller.addDentists(dentist);
            controller.addPatients(patient);
            controller.addAppointment(dentist, patient, 2, 1, "21.11.2022", "no details");
            controller.removeDentists(dentist);
            assert true;
        } catch (RepositoryException e) {
            assert false;
        }
        assert !controller.getAppointments().contains(appointment);
    }

    @Test
    public void removePatients() {
        Patient patient = new Patient("Alex", 23, "0001230000123", "07121234", 1);
        Dentist dentist = new Dentist("Johnny", 8.0, 1);
        try {
            controller.addDentists(dentist);
            controller.addPatients(patient);
            controller.addAppointment(dentist, patient, 2, 1, "21.11.2022", "no details");
            controller.removePatients(patient);
            assert true;
        } catch (RepositoryException e) {
            assert false;
        }


    }

    @Test
    public void hasPatient() {
        Patient patient = new Patient("Alex", 23, "0001230000123", "07121234", 1);
        try {
            controller.addPatients(patient);
            assert controller.hasPatient(patient);
        } catch (RepositoryException e) {
            assert false;
        }

    }

    @Test
    public void hasDentist() {
        Dentist dentist = new Dentist("Johnny", 8.0, 1);
        try {
            controller.addDentists(dentist);
            assert controller.hasDentist(dentist);
        } catch (RepositoryException e) {
            assert false;
        }

    }

    @Test
    public void hasAppointment() {
        Patient patient = new Patient("Alex", 23, "0001230000123", "07121234", 1);
        Dentist dentist = new Dentist("Johnny", 8.0, 1);
        Appointment appointment = new Appointment("no details ", "21.11.2022", 2, 1, dentist, patient);

        try {
            controller.addAppointment(dentist, patient, 2, 1, "21.11.2022", "no details");

        } catch (RepositoryException e) {
            assert true;
        }

    }

    @Test
    public void getNumberOfAppointments() {
        assert controller.getNumberOfAppointments() == 0;
    }

    @Test
    public void getNumberOfDentists() {
        assert controller.getNumberOfDentists() == 0;
    }

    @Test
    public void getNumberOfPatients() {
        assert controller.getNumberOfPatients() == 0;
    }

}