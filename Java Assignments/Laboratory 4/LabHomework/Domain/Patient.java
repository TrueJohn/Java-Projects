package LabHomework.Domain;

import java.io.Serializable;
import java.util.Objects;

public class Patient implements Identifiable<Integer>, Comparable<Patient>, Serializable {

    private String name;

    private Integer age;

    private String personalIdentificationCode;
    private String phoneNumber;

    private Integer id;


    public void setName(String name) {
        this.name = name;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }


    public Patient(String name, Integer age, String personalIdentificationCode, String phoneNumber, Integer id) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.age = age;
        this.personalIdentificationCode = personalIdentificationCode;
    }


    public Integer getAge() {
        return age;
    }

    public String getPersonalIdentificationCode() {
        return personalIdentificationCode;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPersonalIdentificationCode(String personalIdentificationCode) {
        this.personalIdentificationCode = personalIdentificationCode;
    }

    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", personalIdentificationCode='" + personalIdentificationCode + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Patient patient = (Patient) o;
        return Objects.equals(name, patient.name) && Objects.equals(age, patient.age) && Objects.equals(personalIdentificationCode, patient.personalIdentificationCode) && Objects.equals(phoneNumber, patient.phoneNumber) && Objects.equals(id, patient.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, personalIdentificationCode, phoneNumber, id);
    }

    @Override
    public int compareTo(Patient p1) {
        return this.name.compareTo(p1.name);
    }
}
