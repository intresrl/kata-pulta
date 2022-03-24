import kotlin.collections.EmptyList;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Wardrobe {
    final int WALL_LENGTH = 250;

    boolean matchWall(List<Integer> pieces) {
        final int wardrobeLength = pieces.stream().mapToInt(Integer::intValue).sum();
        return wardrobeLength == WALL_LENGTH;
    }

    List<List<Integer>> permutatePieces(List<Integer> pieces) {
        List<List<Integer>> perms = new ArrayList<>();
        for(int i=0; i < pieces.size(); i++) {
            perms.add(perm(pieces, new ArrayList<>()));
        }
        return perms;
    }

    private List<Integer> perm(List<Integer> pieces, List<Integer> oldPerm) {
        if(pieces.size() == 0) {
            return oldPerm;
        }
        oldPerm.add(pieces.get(0));
        final List<Integer> newPieces = pieces.subList(1, pieces.size());

        return perm(newPieces, oldPerm);
    }

    public List<List<Integer>> getAllValidPermutations(List<Integer> pieces) {
        return permutatePieces(pieces).stream().filter(this::matchWall).collect(Collectors.toList());
    }

}




