import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {

    public static void main(String []args){
        System.out.println("ciao");

        String initial =
                "..x," +
                "...," +
                "...";

        final World world = new World(initial);
        System.out.println(world);




    }



}
