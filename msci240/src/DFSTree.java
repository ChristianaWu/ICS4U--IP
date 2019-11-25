
import java.util.LinkedList;
import java.util.List;

public class DFSTree {
    private DFSTreeNode root;
    private IntGraphList n;    
    // TODO: add your constructor here
    public DFSTree (IntGraphList n, int vertex) throws IllegalArgumentException{
    	this.root = new DFSTreeNode (vertex);
    	this.n = n;
    }
    
    /**
     * This method returns a String representation of the tree. For empty trees, the method returns "()". For leaf
     * nodes, the method returns the data at that node in brackets. For branch nodes, it returns a parenthesized String
     * that has these elements, separated by commas: the data at the node, a string representation of the subtree at
     * each child node.
     *
     * For example, if a variable tree stores a reference to this tree:
     *
     *               +---+
     *               | 2 |
     *               +---+
     *            /    |    \
     *      +---+    +---+    +---+
     *      | 8 |    | 3 |    | 1 |
     *      +---+    +---+    +---+
     *        |              /     \
     *      +---+        +---+     +---+
     *      | 0 |        | 7 |     | 6 |
     *      +---+        +---+     +---+
     *                     |         |
     *                   +---+     +---+
     *                   | 4 |     | 9 |
     *                   +---+     +---+
     * 
     *
     * A call to tree.toString() would return:
     *
     * "(2, (8, (0)), (3), (1, (7, (4)), (6, (9))))"
     *
     * @return a String representation of this DFSTree
     */
    @Override
    public String toString() {
        return toString(root);
    }

    /**
     * Recursive helper for the toString method.
     *
     * @param node
     *            the root of the subtree
     * @return a String representation of this subtree
     */
    private String toString(DFSTreeNode node) {
        if (node == null) {
            return "()";
        } else if (!node.hasChildren()) {
            return String.format("(%d)", node.getVertex());
        } else {
            List<String> list = new LinkedList<String>();
            for (DFSTreeNode child : node.getChildren()) {
                list.add(toString(child));
            }
            return String.format("(%d, %s)", node.getVertex(), String.join(", ", list));
        }
    }
}
