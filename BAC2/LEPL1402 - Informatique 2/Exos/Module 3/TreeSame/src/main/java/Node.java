public class Node {

    public int val;
    public Node left;
    public Node right;

    public Node(int val){
        this.val = val;
    }

    public boolean isLeaf(){
        return this.left == null && this.right == null;
    }

    @Override
    public boolean equals(Object o){
        if (o.getClass() != this.getClass()) return false;
        Node toCompare = (Node) o;

        if (toCompare.isLeaf() && this.isLeaf()) {
            return toCompare.val == this.val;
        }

        if (toCompare.left == null && toCompare.right == null) {
            if (this.left == null && this.right == null) {
                return true;
            } else if (this.left == null || this.right == null) {
                return false;
            }
        } else if (toCompare.val == this.val) {
            return this.left.equals(toCompare.left) && this.right.equals(toCompare.right);
        }
        return false;
    }
}