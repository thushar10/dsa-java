package my.dsa.binary;

public class UpperLowerBound {
  public static void main(String[] args) {

    UpperLowerBound upperLowerBound = new UpperLowerBound();
    int[] ints = upperLowerBound.searchRange(new int[]{5, 7, 8, 8, 8, 8, 8, 9, 10}, 8);

    System.out.println("Start : "+ints[0] + ", End : "+ints [1]);
  }

  public int[] searchRange(int[] nums, int target) {

    //lower bound
    int lo = 0;
    int hi = nums.length; // half interval [lo, hi)

    while(lo < hi) {
      int mid = lo + ((hi - lo)/2);

      if(nums[mid] >= target) {
        hi = mid;
      }else {
        lo = mid + 1;
      }
    }
    int start = lo;
    if(start == nums.length || nums[start] != target) {
      return new int[] {-1, -1};
    }

    lo = 0;
    hi = nums.length;

    while(lo < hi) {
      int mid = lo + ((hi - lo)/2);

      if(nums[mid] > target) {
        hi = mid;
      } else {
        lo = mid +1;
      }
    }

    int end = hi -1;


    return new int [] {start, end};
  }


}
