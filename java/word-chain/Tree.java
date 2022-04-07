import java.util.ArrayList;
import java.util.List;

public class Tree {
    private final Node root;

    public Node getRoot() {
        return root;
    }

    public Tree(String rootData) {
        this.root = new Node(rootData);
        root.setData(rootData);
        root.setChildren(new ArrayList<>());
    }

}
