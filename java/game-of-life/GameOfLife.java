public class GameOfLife {

    public static void main(String[] args) {
        System.out.println("ciao");

        String initial = """
                   .*.
                   .*.
                   .*.""";

        final World world = new World(initial);
        System.out.println(world);
        System.out.println("\n---NEXT---\n");
        System.out.println(world.nextWorld());

    }


}
