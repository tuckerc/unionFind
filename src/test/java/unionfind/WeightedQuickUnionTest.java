package unionfind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class WeightedQuickUnionTest {

  WeightedQuickUnion qu;

  @Before
  public void setUp() {
    qu = new WeightedQuickUnion(10);
    qu.union(1, 2);
    qu.union(3, 4);
    qu.union(5, 6);
    qu.union(7, 8);
    qu.union(3, 8);
    qu.union(0, 9);
    qu.union(9, 5);
    qu.union(2, 8);
  }

  @Test
  public void unionTest() {
    assertArrayEquals(new int[] {0, 3, 1, 3, 3, 0, 5, 3, 3, 0}, qu.getNodes());
  }

  @Test
  public void trueConnectionsTest() {
    assertTrue(qu.connected(1, 2));
    assertTrue(qu.connected(3, 4));
    assertTrue(qu.connected(0, 5));
    assertTrue(qu.connected(8, 3));
    assertTrue(qu.connected(9, 0));
  }

  @Test
  public void falseConnectionsTest() {
    assertFalse(qu.connected(0, 1));
    assertFalse(qu.connected(3, 5));
    assertFalse(qu.connected(7, 6));
    assertFalse(qu.connected(9, 1));
  }

  @Test
  public void findMaxHappyTest() {
    assertEquals(9, qu.findMax(0));
    assertEquals(9, qu.findMax(6));
    assertEquals(8, qu.findMax(3));
  }

  @Test
  public void findMaxFailTest() {
    assertNotEquals(6, qu.findMax(6));
    assertNotEquals(4, qu.findMax(2));
    assertNotEquals(3, qu.findMax(3));
  }

  @Test
  public void findMinHappyTest() {
    assertEquals(0, qu.findMin(0));
    assertEquals(1, qu.findMin(3));
    assertEquals(0, qu.findMin(6));
    assertEquals(1, qu.findMin(2));
  }

  @Test
  public void findMinFailTest() {
    assertNotEquals(6, qu.findMin(6));
    assertNotEquals(4, qu.findMin(2));
    assertNotEquals(3, qu.findMin(3));
  }
}
