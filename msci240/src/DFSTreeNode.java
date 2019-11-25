

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DFSTreeNode {
    private int vertex;
    private ArrayList<DFSTreeNode> children;
    private IntGraphList n;

    public DFSTreeNode(int vertex) {
        this.vertex = vertex;
        this.children = new ArrayList<DFSTreeNode>();
    }
    

    
    public DFSTreeNode addChild(int u) {
        DFSTreeNode node = new DFSTreeNode(u);
        children.add(node);
        return node;
    }

    public DFSTreeNode getChild(int i) {
        return children.get(i);
    }
    

    public List<DFSTreeNode> getChildren() {
        return Collections.unmodifiableList(children);
    }

    public boolean hasChildren() {
        return !children.isEmpty();
    }

    public int getVertex() {
        return vertex;
    }
}
