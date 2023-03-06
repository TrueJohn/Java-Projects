package com.example.Domain;

import java.util.Comparator;

public class CompareByNamePatient implements Comparator<Patient> {
    public int compare(Patient p1, Patient p2) {
        return p1.getName().compareTo(p2.getName());
    }
}