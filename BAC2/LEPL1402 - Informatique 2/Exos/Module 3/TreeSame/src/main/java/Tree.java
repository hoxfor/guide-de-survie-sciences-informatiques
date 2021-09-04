public class Tree {

    public Node root;

    public Tree(Node root) {
        this.root = root;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null) return false;
        if (o.getClass() != this.getClass()) return false;

        Tree toCompare = (Tree) o;

        if (toCompare.root == null && this.root == null) {
            return true;
        } else if (toCompare.root == null || this.root == null) {
            return false;
        } else if (toCompare.root.val == this.root.val) {
            return this.root.left.equals(toCompare.root.left) && this.root.right.equals(toCompare.root.right);
        }
        return false;
    }
}