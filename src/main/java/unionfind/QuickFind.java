package unionfind;

public class QuickFind {
    // instance vars
    int[] nodes;

    // constructors
    public QuickFind(int size) {
        nodes = new int[size];
        for(int i = 0; i < nodes.length; i++) {
            nodes[i] = i;
        }
    }

    // accessor methods
    public int[] getNodes() {
        return nodes;
    }

    // business methods
    public void union(int firstNode, int secondNode) {
        int oldVal = nodes[secondNode];
        int newVal = nodes[firstNode];
        for(int i = 0; i < nodes.length; i++) {
            if(nodes[i] == oldVal) {
                nodes[i] = newVal;
            }
        }
    }

    public boolean find(int firstNode, int secondNode) {
        return nodes[firstNode] == nodes[secondNode];
    }
}
