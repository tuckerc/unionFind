package unionfind;

public class WeightedQuickUnion {
  // instance vars
  int[] nodes;
  int[] sizes;

  // constructors
  public WeightedQuickUnion(int size) {
    nodes = new int[size];
    sizes = new int[size];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = i;
      sizes[i] = 1;
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
    if(sizes[firstRoot] < sizes[secondRoot]) {
      nodes[firstRoot] = secondRoot;
      sizes[secondRoot] += sizes[firstRoot];
    }
    else {
      nodes[secondRoot] = firstRoot;
      sizes[firstRoot] += sizes[secondRoot];
    }
  }

  public boolean find(int firstNode, int secondNode) {
    return root(firstNode) == root(secondNode);
  }

  // private helpers
  private int root(int idx) {
    if (nodes[idx] == idx) {
      return idx;
    }
    // compress the path
    nodes[idx] = nodes[nodes[idx]];
    return root(nodes[idx]);
  }
}
