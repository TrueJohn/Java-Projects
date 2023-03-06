package LabWork.Domain;

import java.util.Objects;

public class Game implements Identifiable<Integer>,Comparable<Game>{
    String name;
    Double price;
    String launch_date;

    Integer id;

    public Game()
    {
        this.name="";
        this.price=0.0;
        this.launch_date="";
        this.id=null;

    }


    public Game(Integer id,String name, Double price, String launch_date) {
        this.name = name;
        this.price = price;
        this.launch_date = launch_date;
        this.id=id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setLaunch_date(String launch_date) {
        this.launch_date = launch_date;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public String getLaunch_date() {
        return launch_date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Game game = (Game) o;
        return Objects.equals(name, game.name) && Objects.equals(price, game.price) && Objects.equals(launch_date, game.launch_date);
    }

    @Override
    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return " Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", launch_date='" + launch_date + '\'' +
                '}'+'\n';
    }

    @Override
    public int compareTo(Game o) {

        return this.price.compareTo(o.price);

    }
}