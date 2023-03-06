package com.example.Domain;

import java.util.Comparator;

public class CompareByDateAppointment implements Comparator<Appointment> {

    public int compare(Appointment a1, Appointment a2) {
        return a1.getDate().compareTo(a2.getDate());
    }
}

