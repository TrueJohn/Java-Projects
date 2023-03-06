package LabWork;

import LabWork.Domain.*;
import LabWork.Repo.*;

import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        GameRepo gameRepo = new GameRepo();

        Game game1 = new Game(1,"Doom", 20.5, "1999");
        Game game2 = new Game(2,"StarCraft", 10.9, "2000");
        Game game3 = new Game(3,"Counter Strike", 15.5, "2005");
        Game game4 = new Game(4,"Call of Duty", 17.6, "2005");
        Game game5 = new Game(5,"Need for Speed", 19.9, "2009");

        gameRepo.add(game1);
        gameRepo.add(game2);
        gameRepo.add(game3);
        gameRepo.add(game4);
        gameRepo.add(game5);

        System.out.println("Initial repo:\n");
        System.out.println(gameRepo.getAll());
        System.out.println('\n');

        CompareByName cmp = new CompareByName();

        gameRepo.sortbycriteria(cmp);
        System.out.println("Sorting repo by Game name:\n");
        System.out.println(gameRepo.getAll());
        System.out.println('\n');

        System.out.println("\n----------------------\n");
        System.out.println("Check if the an element is in the Repository:");

        Game game6 = new Game(6,"Need for Speed", 19.9, "2009");
        Game game7 = new Game(7,"Plants vs zombies", 10.0, "2006");

        System.out.println(game6 + "is it in the repository:");
        System.out.println(gameRepo.searchelem(game6));

        System.out.println(game7 + "is it in the repository:");
        System.out.println(gameRepo.searchelem(game7));

        System.out.println("\n\n----------------------\n\n");

        gameRepo.delete(game1);

        System.out.println("Repo after deleting \n"+game1+"\n");
        System.out.println(gameRepo.getAll());


        Game game8 = new Game(8,"Darkest Dungeon", 20.0, "2014");

        System.out.println("--------------------\nModify element with id 2:\n");
        System.out.println(game2);
        System.out.println("\nWith:\n");
        System.out.println(game8);

        gameRepo.update(2,game8);

        System.out.println(gameRepo.getAll());



    }


}