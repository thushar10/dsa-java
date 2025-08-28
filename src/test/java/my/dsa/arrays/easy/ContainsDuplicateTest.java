package my.dsa.arrays.easy;

import org.junit.jupiter.api.Test;

import java.awt.event.ContainerAdapter;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ContainsDuplicateTest {


  @Test
  public void containsDuplicateTest() {
    ContainsDuplicates containsDuplicates = new ContainsDuplicates();
    assertTrue(containsDuplicates.containsDuplicate(new int [] {1, 2, 3, 1}));
    assertTrue(containsDuplicates.containsDuplicate(new int [] {1, 1, 2, 3, 1}));
    assertFalse(containsDuplicates.containsDuplicate(new int [] {1, 2, 3, 4, 5}));
    assertFalse(containsDuplicates.containsDuplicate(new int [] {}));
  }


}
