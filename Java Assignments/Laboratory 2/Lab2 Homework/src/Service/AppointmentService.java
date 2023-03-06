package Service;

import Domain.*;
import Repository.AppointmentRepository;
import Exception.RepositoryException;

import java.util.ArrayList;
import java.util.Iterator;

public class AppointmentService {

    private AppointmentRepository repo;

    public AppointmentService(AppointmentRepository repo) {
        this.repo = repo;
    }

    public void addAppointment(String details, String date, Integer duration, Integer id, Dentist dentist, Patient patient) throws RepositoryException
    {
        Appointment appointment=new Appointment(details,date,duration,id,dentist,patient);

        if(!this.repo.add(appointment))
            throw new RepositoryException("Error can not add appointment!");

    }
    public void sortAppointmentsByName()
    {

        Iterable<Appointment> iterated = this.getALL();
        Iterator<Appointment> i = iterated.iterator();
        ArrayList<Appointment> appointments = new ArrayList<>();
        while (i.hasNext()) {
            appointments.add(i.next());
        }
        appointments.sort(new CompareByDateAppointment());
        this.repo.setrepo(appointments);
    }
    public void removeAppointment(Appointment appointment) throws RepositoryException
    {
        if(!this.repo.delete(appointment))
            throw  new RepositoryException("Error can not remove appointment");
    }

    public Iterable<Appointment> getALL()
    {
        return repo.getAll();
    }




}
