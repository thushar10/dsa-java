package my.dsa.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TwoSum_001Test {

  @Test
  void retrunsValidResultsForPostive() {
    TwoSum_001 twoSum001 = new TwoSum_001();
    int[] ints = twoSum001.twoSumMap(new int[]{2, 7, 9, 11}, 9);
    assertTrue(ints[0] == 0 && ints[1] == 1);
    int[] ints2 = twoSum001.twoSumMap(new int[]{1, 2, 7, 9, 11}, 9);
    assertTrue(ints2[0] == 1 && ints2[1] == 2);

    int[] ints3 = twoSum001.twoSumMap(new int[]{1, 2, 7, 9, 11, 8}, 9);
    assertTrue(ints3[0] == 1 && ints3[1] == 2);
    assertTrue(ints3[2] == 0 && ints3[3] == 5);
    int[] ints4 = twoSum001.twoSumMap(new int[]{}, 9);
    assertTrue(ints4.length == 0);
  }

  @Test
  void retrunsValidResultsForNegative() {
    TwoSum_001 twoSum001 = new TwoSum_001();
    int[] ints = twoSum001.twoSumMap(new int[]{-2, 7, 9, 11}, 9);
    assertTrue(ints[0] == 0 && ints[1] == 3);
    int[] ints2 = twoSum001.twoSumMap(new int[]{1, 3, 7, 9, 11, -6, 15}, 9);
    assertTrue(ints2[0] == 5 && ints2[1] == 6);

    int[] ints3 = twoSum001.twoSumMap(new int[]{1, -2, -7, 9, 11, 8}, -9);
    assertTrue(ints3[0] == 1 && ints3[1] == 2);

    int[] ints4 = twoSum001.twoSumMap(new int[]{-6, -2, -7, 9, 11, 8, -3}, -9);
    assertTrue(ints4[0] == 1 && ints4[1] == 2);
    assertTrue(ints4[2] == 0 && ints4[3] == 6);

  }






}
