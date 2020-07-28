package unionfind;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class QuickFindTest {

  QuickFind qf;

  @Before
  public void setUp() {
    qf = new QuickFind(10);
    qf.union(1, 2);
    qf.union(3, 4);
    qf.union(5, 6);
    qf.union(7, 8);
    qf.union(3, 8);
    qf.union(0, 9);
    qf.union(9, 5);
  }

  @Test
  public void unionTest() {
    assertArrayEquals(new int[] {0, 1, 1, 3, 3, 0, 0, 3, 3, 0}, qf.getNodes());
  }

  @Test
  public void trueFindTest() {
    assertTrue(qf.find(1, 2));
    assertTrue(qf.find(3, 4));
    assertTrue(qf.find(0, 5));
    assertTrue(qf.find(8, 3));
    assertTrue(qf.find(9, 0));
  }

  @Test
  public void falseFindTest() {
    assertFalse(qf.find(0, 1));
    assertFalse(qf.find(3, 5));
    assertFalse(qf.find(7, 6));
    assertFalse(qf.find(9, 1));
  }
}
