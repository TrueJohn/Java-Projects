package LabHomework.Validator;

import LabHomework.Domain.Appointment;
import LabHomework.Domain.Dentist;
import LabHomework.Domain.Patient;
import LabHomework.Exception.InvalidParametersException;

import java.util.regex.Pattern;

public class Validator {
    private static void validateName(String name) throws InvalidParametersException {
        if (name == null || name.equals(""))
            throw new InvalidParametersException("Name is null or empty");
        if (name.length() > 45)
            throw new InvalidParametersException("Name is too long");
    }

    private static void validatePhone(String phone) throws InvalidParametersException {
        if (phone == null || phone.equals(""))
            throw new InvalidParametersException("Phone is null or empty");
        if (phone.length() > 12)
            throw new InvalidParametersException("Phone is too long");
        if (!Pattern.matches("^\\d+$", phone))
            throw new InvalidParametersException("Phone is not valid");
    }

    private static void validateRating(Double rating) throws InvalidParametersException {
        if (rating == null)
            throw new InvalidParametersException("Rating is null or empty");

    }

    private static void validateAge(Integer age) throws InvalidParametersException {
        if (age == null)
            throw new InvalidParametersException("Age is null or empty");
        if (age < 0)
            throw new InvalidParametersException("Age can not be negative");
        if (age > 100)
            throw new InvalidParametersException("Age can not be over 100");

    }


    private static void validatePersonalIdentificationCode(String personalIdentificationCode) {
        if (personalIdentificationCode == null || personalIdentificationCode.equals(""))
            throw new InvalidParametersException("PersonalIdentificationCode is null or empty");
        if (personalIdentificationCode.length() > 13)
            throw new InvalidParametersException("PersonalIdentificationCode is too long , it must be 13 characters");
        if (personalIdentificationCode.length() < 13)
            throw new InvalidParametersException("PersonalIdentificationCode is too short , it must be 13 characters");

    }

    static public void check(Dentist d) throws InvalidParametersException {
        if (d == null)
            throw new InvalidParametersException("Dentist is null");
        validateName(d.getName());
        validateRating(d.getRating());

    }

    static public void check(Patient p) throws InvalidParametersException {
        if (p == null)
            throw new InvalidParametersException("Object is null");
        validateName(p.getName());
        validatePhone(p.getPhoneNumber());
        validatePersonalIdentificationCode(p.getPersonalIdentificationCode());
        validateAge(p.getAge());
    }


    static public void check(Appointment a) throws InvalidParametersException {
        if (a == null)
            throw new InvalidParametersException("Object is null");
    }
}
