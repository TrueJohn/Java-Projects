package LabAssignment.Repository;

import LabAssignment.Domain.Appointment;
import LabAssignment.Domain.Dentist;
import LabAssignment.Domain.Patient;


public class AppointmentRepository extends MemoryRepository<Appointment> {

    boolean patientHasAppointment(Patient patient)
    {
        for (Appointment appointment: this.getAll())
        {
            if(appointment.getPatient()==patient)
                return true;
        }
        return false;
    }

    boolean dentistHasAppointment(Dentist dentist)
    {

        for (Appointment appointment: this.getAll())
        {
            if(appointment.getDentist()==dentist)
                return true;
        }
        return false;
    }

    public AppointmentRepository appointmentsOfDentist(Dentist dentist)
    {
        AppointmentRepository appointmentRepository1=new AppointmentRepository();
        for(Appointment appointment:this.getAll())
            if(appointment.getDentist().equals(dentist))
                appointmentRepository1.add(appointment);

        return appointmentRepository1;

    }

    public AppointmentRepository appointmentsOfPatient(Patient patient)
    {
        AppointmentRepository appointmentRepository1=new AppointmentRepository();
        for(Appointment appointment:this.getAll())
            if(appointment.getPatient().equals(patient))
                appointmentRepository1.add(appointment);

        return appointmentRepository1;

    }


}
