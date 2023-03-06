package com.example.Domain;

import java.util.Comparator;

public class CompareByDetailsAppointment implements Comparator<Appointment> {

    public int compare(Appointment a1, Appointment a2) {
        return a1.getDetails().compareTo(a2.getDetails());
    }
}
