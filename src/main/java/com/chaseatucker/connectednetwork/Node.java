package com.chaseatucker.connectednetwork;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableList;

import java.util.Collections;
import java.util.PriorityQueue;

public class Node<T extends Comparable<T>> {
  // instance vars
  private T root;
  private PriorityQueue<T> connections;

  // constructors
  public Node(T root) {
    this.root = root;
    // pq is now a max heap
    this.connections = new PriorityQueue<>(Collections.reverseOrder());
  }

  // getters and setters
  public T getRoot() {
    return root;
  }

  public void setRoot(T root) throws NullRootException {
    if (root == null) {
      throw new NullRootException("Root cannot be null!");
    }
    this.root = root;
  }

  public ImmutableList<T> getConnections() {
    return ImmutableList.copyOf(connections);
  }

  public void setConnections(PriorityQueue<T> connections) throws NullConnectionsException {
    if (connections == null) {
      throw new NullConnectionsException("Connections Priority Queue cannot be null!");
    }
    this.connections = connections;
  }

  // overrides
  @Override
  public String toString() {
    return "Node{" + "root=" + root + ", connections=" + connections + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Node<?> node = (Node<?>) o;
    return Objects.equal(root, node.root) && Objects.equal(connections, node.connections);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(root, connections);
  }
}
