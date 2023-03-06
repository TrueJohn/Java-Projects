import java.util.Collection;
import java.util.Collections;

public class Main {

    public static void main(String[] args) {

        GameStore store1=new GameStore();

        Game game1=new Game("Doom",20.5,"1999");
        Game game2=new Game("StarCraft",10.9,"2000");
        Game game3=new Game("Counter Strike",15.5,"2005");
        Game game4=new Game("Call of Duty",17.6,"2005");

        store1.add_game(game1);
        store1.add_game(game2);
        store1.add_game(game3);
        store1.add_game(game4);

        System.out.println(store1);
        System.out.println('\n');

        Collections.sort(store1.getList_of_Games());

        System.out.println(store1);
        System.out.println('\n');

        System.out.println("The most expensive game is:");
        System.out.println(store1.most_expensive_game());

        System.out.println("The games from the year 2005 are:");
        System.out.println(store1.filter_games_by_year("2000"));




    }


}