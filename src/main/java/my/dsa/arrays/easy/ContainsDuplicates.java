package my.dsa.arrays.easy;

import java.util.Arrays;
import java.util.HashSet;

public class ContainsDuplicates {

  public static void main(String[] args) {
    ContainsDuplicates containsDuplicates = new ContainsDuplicates();
    boolean containsDuplicate = containsDuplicates.containsDuplicate(new int[]{1,2,3,4,2});
    boolean containsDuplicate1 = containsDuplicates.containsDuplicateSort(new int[]{1,2,3,4,2});
    System.out.println(containsDuplicate);

    System.out.println(containsDuplicate1);
  }


  //this is usually the exected solution if they talk about space complexity the solution would be to sort it and check neighbours
  public boolean containsDuplicate(int[] nums) {

    if(nums.length == 0 ) {
      return false;
    }
    HashSet<Integer> set = new HashSet<>();
    for(int i= 0; i<nums.length; i++) {
      if(set.contains(nums[i])) {
        return true;
      }else {
        set.add(nums[i]);
      }
    }
    return false;
  }


  private boolean containsDuplicateSort(int [] nums) {
    Arrays.sort(nums);

    for (int i=0; i<nums.length; i++) {
      if( i!= nums.length -1 && nums[i] == nums[i+1]) {
        return true;
      }
    }
    return false;

  }

}
