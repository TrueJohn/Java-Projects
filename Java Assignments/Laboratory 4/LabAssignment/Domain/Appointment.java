package LabAssignment.Domain;

import java.io.Serializable;
import java.util.Objects;

public class Appointment implements Identifiable<Integer>, Comparable<Appointment>, Serializable {

    private String details;
    private String date;
    private Integer duration;
    private Integer id;

    private Dentist dentist;

    private Patient patient;

    public Appointment(String details, String date, Integer duration, Integer id,Dentist dentist,Patient patient) {
        this.details = details;
        this.date = date;
        this.duration = duration;
        this.id = id;
        this.dentist=dentist;
        this.patient=patient;
    }

    @Override
    public String toString() {
        return "Appointment{" +
                "details='" + details + '\'' +
                ", date='" + date + '\'' +
                ", duration=" + duration +
                ", id=" + id +
                ", dentist=" + dentist +
                ", patient=" + patient +
                '}';
    }


    public Dentist getDentist() {
        return dentist;
    }

    public void setDentist(Dentist dentist) {
        this.dentist = dentist;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }




    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public int compareTo(Appointment appointment) {
        return this.details.compareTo(appointment.details);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Appointment that = (Appointment) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(details, date, duration, id, dentist, patient);
    }
}
