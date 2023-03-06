package Domain;

public class Dentist implements Identifiable<Integer>,Comparable<Dentist>{

    private String name;
    private Double rating;
    private Integer id;

    public Dentist(String name, Double rating, Integer id) {
        this.name = name;
        this.rating = rating;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public Double getRating() {
        return rating;
    }


    @Override
    public Integer getId() {
        return this.id;
    }
     public void setId(Integer id) {
        this.id = id;
    }
    /*
    public void setName(String name) {
        this.name = name;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }
    */


    @Override
    public String toString() {
        return "Dentist{" +
                "name='" + name + '\'' +
                ", rating=" + rating +
                ", id=" + id +
                '}';
    }

    @Override
    public int compareTo(Dentist o) {
        return 0;
    }
}
