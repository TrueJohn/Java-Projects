package Domain;

import java.util.Comparator;

public class CompareByNameDentist implements Comparator<Dentist> {
    public int compare(Dentist d1, Dentist d2) {
        return d1.getName().compareTo(d2.getName());
    }
}