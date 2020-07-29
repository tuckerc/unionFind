package com.chaseatucker.connectednetwork;

import com.google.common.base.Objects;
import com.google.common.collect.ImmutableSet;

import java.util.HashSet;
import java.util.Set;

public class ConnectedNetwork<T extends Comparable<T>> {
  // instance vars
  private Set<Node<T>> nodes;

  // constructors
  public ConnectedNetwork() {
    this.nodes = new HashSet<>();
  }

  // getters and setters
  public Set<Node<T>> getNodes() {
    return ImmutableSet.copyOf(nodes);
  }

  // business methods

  // overrides
  @Override
  public String toString() {
    return "ConnectedNetwork{" + "nodes=" + nodes + '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ConnectedNetwork<?> that = (ConnectedNetwork<?>) o;
    return Objects.equal(nodes, that.nodes);
  }

  @Override
  public int hashCode() {
    return Objects.hashCode(nodes);
  }
}
