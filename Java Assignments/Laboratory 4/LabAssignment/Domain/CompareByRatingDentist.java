package LabAssignment.Domain;

import java.util.Comparator;

public class CompareByRatingDentist implements Comparator<Dentist> {
    public int compare(Dentist d1, Dentist d2) {
        return d1.getRating().compareTo(d2.getRating());
    }
}