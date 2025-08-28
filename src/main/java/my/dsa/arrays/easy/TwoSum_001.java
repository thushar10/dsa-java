package my.dsa.arrays.easy;

import java.util.*;

public class TwoSum_001 {

  public static void main(String[] args) {
    TwoSum_001 twoSum001 = new TwoSum_001();
    int [] nums = {2, 7, 11, 15};
    int[] ints1 = twoSum001.twoSumN2(nums, 9);
    int[] ints2 = twoSum001.twoSumMap(nums, 9);
    int [] ints = twoSum001.twoSumAllPairs(nums, 9);
    List<Integer> list = Arrays.stream(ints).boxed().toList();
    System.out.println(list);
  }


  public int [] twoSumN2(int [] nums, int target ) {
    List<Integer> indexes = new ArrayList<>();
    for (int i =0; i< nums.length; i++) {
      for (int j = i+1; j< nums.length; j++) {
        if(nums[i] + nums[j] == target) {
          indexes.add(i);
          indexes.add(j);
        } else {
          continue;
        }
      }
    }

    return indexes.stream()
      .mapToInt(Integer::intValue)
      .toArray();

  }

  public int[] twoSumMap(int [] nums, int target) {

    Map<Integer, Integer> map = new HashMap<>();
    List<Integer> indexes = new ArrayList<>();
    for (int i = 0; i< nums.length; i++) {

      if(map.containsKey(nums[i])) {
        indexes.add(map.get(nums[i]));
        indexes.add(i);
      }else {
        map.put(target - nums[i], i);
      }
    }

    return indexes.stream()
      .mapToInt(Integer::intValue)
      .toArray();
  }


  public int[] twoSumAllPairs(int[] nums, int target) {
    List<Integer> indexes = new ArrayList<>();
    int i = 0, j = nums.length - 1;
    while (i < j) {
      long sum = (long) nums[i] + nums[j];
      if (sum == target) {
        indexes.add(i);
        indexes.add(j);
        //result.add(new int[]{i, j});
        i++;
        j--;
      } else if (sum > target) {
        j--;
      } else {
        i++;
      }
    }
    return indexes.stream()
      .mapToInt(Integer::intValue)
      .toArray();
  }
}
