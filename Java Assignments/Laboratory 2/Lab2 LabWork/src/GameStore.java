import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GameStore implements Iterable<Game>{
    List<Game> List_of_Games;


    public GameStore()
    {
        List_of_Games=new ArrayList<>();
    }

    public void add_game(Game g1){
        this.List_of_Games.add(g1);
    }

    public GameStore(List<Game> list_of_Games) {
        List_of_Games = list_of_Games;
    }

    public List<Game> getList_of_Games() {
        return List_of_Games;
    }

    public void setList_of_Games(List<Game> list_of_Games) {
        List_of_Games = list_of_Games;
    }

    public Game most_expensive_game()
    {
        Double max=0.0;
        Game game=new Game();
        for(Game g1:List_of_Games)
            if(g1.price>max)
            {
                max=g1.price;
                game=g1;
            }
        return game;
    }

    public List<Game> filter_games_by_year(String year)
    {
        List<Game> temp_list=new ArrayList<>();
        for(Game g1:this.List_of_Games)
            if(g1.launch_date.equals(year))
                temp_list.add(g1);

        return temp_list;

    }

    @Override
    public String toString() {
        return "GameStore{\n" +
                "List_of_Games=\n" + List_of_Games +
                '}';
    }

    @Override
    public Iterator<Game> iterator() {
       return List_of_Games.iterator();
    }
}
