package unionfind;

public class WeightedQuickUnion {
  // instance vars
  int[] nodes;
  int[] sizes;
  int[] maxConnections;
  int[] minConnections;

  // constructors
  public WeightedQuickUnion(int size) {
    nodes = new int[size];
    sizes = new int[size];
    maxConnections = new int[size];
    minConnections = new int[size];
    for (int i = 0; i < nodes.length; i++) {
      nodes[i] = i;
      sizes[i] = 1;
      maxConnections[i] = i;
      minConnections[i] = i;
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
      updateRootData(firstRoot, secondRoot);
    }
    else {
      updateRootData(secondRoot, firstRoot);
    }
  }

  private void updateRootData(int rootA, int rootB) {
    nodes[rootA] = rootB;
    sizes[rootB] += sizes[rootA];
    if(maxConnections[rootA] > maxConnections[rootB]) {
      maxConnections[rootB] = maxConnections[rootA];
    }
    if(minConnections[rootA] < minConnections[rootB]) {
      minConnections[rootB] = minConnections[rootA];
    }
  }

  public boolean connected(int firstNode, int secondNode) {
    return root(firstNode) == root(secondNode);
  }

  public int findMax(int i) {
    return maxConnections[root(i)];
  }

  public int findMin(int i) {
    return minConnections[root(i)];
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
