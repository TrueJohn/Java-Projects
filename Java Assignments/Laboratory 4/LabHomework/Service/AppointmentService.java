package LabHomework.Service;

import LabHomework.Domain.Appointment;
import LabHomework.Domain.CompareByDateAppointment;
import LabHomework.Domain.Dentist;
import LabHomework.Domain.Patient;
import LabHomework.Exception.RepositoryException;
import LabHomework.Repository.AppointmentRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Consumer;

public class AppointmentService {

    private AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    public void addAppointment(String details, String date, Integer duration, Integer id, Dentist dentist, Patient patient) throws RepositoryException {
        Appointment appointment = new Appointment(details, date, duration, id, dentist, patient);

        if (!this.appointmentRepository.add(appointment))
            throw new RepositoryException("Error can not add appointment!");

    }

    public void sortAppointmentsByName() {

        Iterable<Appointment> iterated = this.getALL();
        Iterator<Appointment> i = iterated.iterator();
        ArrayList<Appointment> appointments = new ArrayList<>();
        while (i.hasNext()) {
            appointments.add(i.next());
        }
        appointments.sort(new CompareByDateAppointment());
        this.appointmentRepository.setRepository(appointments);
    }

    public void removeAppointment(Appointment appointment) throws RepositoryException {
        if (!this.appointmentRepository.delete(appointment))
            throw new RepositoryException("Error can not remove appointment");
    }

    public boolean contains(Appointment appointment) {
        return appointmentRepository.has(appointment);
    }


    public AppointmentRepository appointmentsOfDentist(Dentist dentist) {
        return appointmentRepository.appointmentsOfDentist(dentist);
    }

    public AppointmentRepository appointmentsOfPatient(Patient patient) {
        return appointmentRepository.appointmentsOfPatient(patient);
    }

    public Appointment getById(Integer id) throws RepositoryException {
        return appointmentRepository.getById(id);

    }

    public void update(Integer id, Appointment appointment) {
        this.appointmentRepository.update(id, appointment);
    }

    public Iterable<Appointment> getALL() {
        return appointmentRepository.getAll();
    }

    public void consumerinterface() {
        Consumer<AppointmentService> display = out -> System.out.println(out.toString());
        display.accept(this);
    }
}
