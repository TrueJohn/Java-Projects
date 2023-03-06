package Domain;

public class Patient implements Identifiable<Integer>, Comparable<Patient> {
    private String name;

    private Integer age;

    private String personalidentificationcode;
    private String phonenumber;

    private Integer id;

    /*
    public void setName(String name) {
        this.name = name;
    }



    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
*/
    public String getName() {
        return name;
    }
/*
    public String getPhonenumber() {
        return phonenumber;
    }
*/
    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return this.id;
    }



    public Patient(String name,Integer age,String personalidentificationcode ,String phonenumber,Integer id) {
        this.id = id;
        this.name = name;
        this.phonenumber = phonenumber;
        this.age=age;
        this.personalidentificationcode=personalidentificationcode;
    }

    /*
    public Integer getAge() {
        return age;
    }

    public String getPersonalidentificationcode() {
        return personalidentificationcode;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setPersonalidentificationcode(String personalidentificationcode) {
        this.personalidentificationcode = personalidentificationcode;
    }
*/
    @Override
    public String toString() {
        return "Patient{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", personalidentificationcode='" + personalidentificationcode + '\'' +
                ", phonenumber='" + phonenumber + '\'' +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Patient p1) {
        return this.name.compareTo(p1.name);
    }
}
