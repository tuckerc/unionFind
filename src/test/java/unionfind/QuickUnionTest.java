package unionfind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickUnionTest {

  QuickUnion qu;

  @Before
  public void setUp() {
    qu = new QuickUnion(10);
    qu.union(1, 2);
    qu.union(3, 4);
    qu.union(5, 6);
    qu.union(7, 8);
    qu.union(3, 8);
    qu.union(0, 9);
    qu.union(9, 5);
  }

  @Test
  public void unionTest() {
    assertArrayEquals(new int[] {9, 2, 2, 4, 8, 6, 6, 8, 8, 6}, qu.getNodes());
  }

  @Test
  public void trueFindTest() {
    assertTrue(qu.find(1, 2));
    assertTrue(qu.find(3, 4));
    assertTrue(qu.find(0, 5));
    assertTrue(qu.find(8, 3));
    assertTrue(qu.find(9, 0));
  }

  @Test
  public void falseFindTest() {
    assertFalse(qu.find(0, 1));
    assertFalse(qu.find(3, 5));
    assertFalse(qu.find(7, 6));
    assertFalse(qu.find(9, 1));
  }
}
