import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameOfLife {

    public static void main(String[] args) {
        System.out.println("ciao");

        String initial = """
                   .*.
                   .*.
                   .*.""";

        final World world = new World(initial);
        System.out.println(world);
        System.out.println();
        System.out.println(world.nextWorld());

    }


}
