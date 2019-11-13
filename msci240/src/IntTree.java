
public class IntTree {
    private IntTreeNode root;

    public void add(int i, Integer value) {
        root = add(root, value, i);
    }
    
    public int size () {
    	return size(this.root);

    }
    
    private int size (IntTreeNode t) {
    	int size = 0;
    	if (t == null) {
    		return 0;
    	}else {
    		return size (t.left) + size(t.right) + 1;

    	}
    }

    private IntTreeNode add(IntTreeNode node, Integer value, int i) {
        if (i == 1) {
            node = new IntTreeNode(value);
        } else {
            int k = (int) Math.floor(Math.log(i) / Math.log(2)); // closest power of two exponent
            int diff = i - (int) Math.pow(2, k);
            if (diff < (int) Math.pow(2, k - 1)) {
                node.left = add(node.left, value, (int) Math.pow(2, k - 1) + diff);
            } else {
                node.right = add(node.right, value, diff);
            }
        }

        return node;
    }
    
    

    // TODO: add your methods here
}
