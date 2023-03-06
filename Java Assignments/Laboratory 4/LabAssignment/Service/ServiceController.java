package LabAssignment.Service;

import LabAssignment.Domain.Appointment;
import LabAssignment.Domain.Dentist;
import LabAssignment.Domain.Patient;
import LabAssignment.Exception.RepositoryException;
import LabAssignment.Validator.Validator;
import LabAssignment.Exception.InvalidParametersException;

import java.util.ArrayList;

final public class ServiceController {

    public final AppointmentService appointmentService;
    public final DentistService dentistService;
    public final PatientService patientService;

    public ServiceController(AppointmentService appointmentService, DentistService dentistService, PatientService patientService) {
        this.appointmentService = appointmentService;
        this.dentistService = dentistService;
        this.patientService = patientService;
    }

    public Appointment addAppointment(Dentist dentist, Patient patient,Integer duration,Integer id, String date, String details) throws RepositoryException, InvalidParametersException {
        if (!dentistService.contains(dentist)|| !patientService.contains(patient))
            throw new RepositoryException("Dentist or patient not found");
        Appointment appointment = new Appointment(details,date,duration,id,dentist,patient);
        Validator.check(appointment);
        appointmentService.addAppointment(details,date,duration,id,dentist,patient);
        return appointment;
    }

    public void removeAppointment(Appointment appointment) throws RepositoryException {
        appointmentService.removeAppointment(appointment);
    }

    public void addDentists(Dentist... dentists) throws RepositoryException, InvalidParametersException {
        for (Dentist dentist : dentists) {
            Validator.check(dentist);
            dentistService.addDentist(dentist.getId(),dentist.getName(),dentist.getRating());
        }
    }

    public void addPatients(Patient... patients) throws RepositoryException, InvalidParametersException {
        for (Patient patient : patients) {
            Validator.check(patient);
            patientService.addPatient(patient.getId(),patient.getName(),patient.getAge(),patient.getPersonalIdentificationCode(),patient.getPhoneNumber());
        }
    }

    public void removeDentists(Dentist... dentists) throws RepositoryException {
        for (Dentist dentist : dentists) {
            dentistService.removeDentist(dentist);
            for (Appointment appointment : appointmentService.appointmentsOfDentist(dentist).getAll())
                appointmentService.removeAppointment(appointment);
        }
    }

    public void removePatients(Patient... patients) throws RepositoryException {
        for (Patient patient : patients) {
            patientService.deletePatient(patient);
            for (Appointment appointment : appointmentService.appointmentsOfPatient(patient).getAll())
                appointmentService.removeAppointment(appointment);
        }
    }

    public void updateDentist(Dentist dentist) throws RepositoryException, InvalidParametersException {
        Validator.check(dentist);
        dentistService.update(dentist.getId(),dentist);
    }

    public void updatePatient(Patient patient) throws RepositoryException, InvalidParametersException {
        Validator.check(patient);
        patientService.update(patient.getId(),patient);
    }

    public void updateAppointment(Appointment appointment) throws RepositoryException, InvalidParametersException {
        Validator.check(appointment);
        appointmentService.update(appointment.getId(),appointment);
    }



    public ArrayList<Dentist> getDentists() {
        return (ArrayList<Dentist>) dentistService.getALL();
    }

    public ArrayList<Patient> getPatients() {
        return (ArrayList<Patient>) patientService.getALL();
    }

    public ArrayList<Appointment> getAppointments() {
        return (ArrayList<Appointment>) appointmentService.getALL();
    }

    public Dentist getDentist(Integer id) throws RepositoryException {
        return dentistService.getById(id);
    }

    public Patient getPatient(Integer id) throws RepositoryException {
        return patientService.getById(id);
    }

    public Appointment getAppointment(Integer id) throws RepositoryException {
        return appointmentService.getById(id);
    }

    public boolean hasPatient(Patient patient) {
        return patientService.contains(patient);
    }

    public boolean hasDentist(Dentist dentist) {
        return dentistService.contains(dentist);
    }

    public boolean hasAppointment(Appointment appointment) {
        return appointmentService.contains(appointment) ;
    }

    public Integer getNumberOfAppointments() {
        return getAppointments().size();
    }

    public Integer getNumberOfDentists() {
        return getDentists().size();
    }

    public Integer getNumberOfPatients() {
        return getPatients().size();
    }

    public ArrayList<Appointment> appointmentsOfDentist(Dentist dentist) {
        return (ArrayList<Appointment>)(appointmentService.appointmentsOfDentist(dentist).getAll());
    }

    public ArrayList<Appointment> appointmentsOfPatient(Patient patient) {
        return (ArrayList<Appointment>)(appointmentService.appointmentsOfPatient(patient).getAll());
    }

}