import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WardrobeTest {
    /**
        The wardrobe elements sizes: 50cm, 75cm, 100cm, and 120cm.
        The wall total length of 250cm.

        Write a function that returns all combinations of wardrobe elements
        that exactly fill the wall.
     **/

    @Test
    public void combinationMatchSpace() {
        final Wardrobe wardrobe = new Wardrobe();

        assertEquals(true, wardrobe.matchWall(Arrays.asList(100, 50, 100)));
    }

    @Test
    public void combinationExceedSpace() {
        final Wardrobe wardrobe = new Wardrobe();

        assertEquals(false, wardrobe.matchWall(Arrays.asList(120, 50, 100)));
    }

    @Test
    public void permutate1Value() {
        List<List<Integer>> expectedPermutations = List.of(List.of(120));
        final Wardrobe wardrobe = new Wardrobe();

        List<List<Integer>> permutations = wardrobe.permutatePieces(List.of(120));

        assertEquals(expectedPermutations, permutations);
    }

    @Test
    public void permutate2Values() {
        List<List<Integer>> expectedPermutations = Arrays.asList(
                Arrays.asList(120,120),
                Arrays.asList(120,50),
                Arrays.asList(50,50)
        );
        final Wardrobe wardrobe = new Wardrobe();

        List<List<Integer>> permutations = wardrobe.permutatePieces(Arrays.asList(120, 50));

        assertEquals(expectedPermutations, permutations);
    }
}
