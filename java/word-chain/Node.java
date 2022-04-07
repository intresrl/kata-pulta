import java.util.List;

public class Node {
    private String data;
    private Node parent;
    private List<Node> children;

    public void setData(String data) {
        this.data = data;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

    public String getData() {
        return data;
    }

    public Node getParent() {
        return parent;
    }

    public List<Node> getChildren() {
        return children;
    }

    public void setChildren(List<Node> children) {
        this.children = children;
    }

    public Node(String data) {
        this.data = data;
    }

    public void addChild(Node child) {
        child.parent = this;
        this.children.add(child);
    }
}
