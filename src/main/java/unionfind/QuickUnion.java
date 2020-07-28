package unionfind;

public class QuickUnion {
  // instance vars
  int[] nodes;

  // constructors
  public QuickUnion(int size) {
    nodes = new int[size];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = i;
    }
  }

  // getters and setters
  public int[] getNodes() {
    return nodes;
  }

  // business methods
  public void union(int firstNode, int secondNode) {
    int firstRoot = root(firstNode);
    int secondRoot = root(secondNode);
    nodes[firstRoot] = nodes[secondRoot];
  }

  public boolean find(int firstNode, int secondNode) {
    return root(firstNode) == root(secondNode);
  }

  // private helpers
  private int root(int idx) {
    if (nodes[idx] == idx) {
      return idx;
    }
    return root(nodes[idx]);
  }
}
