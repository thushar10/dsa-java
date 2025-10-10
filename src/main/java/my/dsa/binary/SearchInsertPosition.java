package my.dsa.binary;

public class SearchInsertPosition {

  public static void main(String[] args) {

    SearchInsertPosition searchInsertPosition = new SearchInsertPosition();
    int i = searchInsertPosition.searchInsert(new int[]{1, 3, 5, 6}, 7);
    System.out.println(i);
  }


  public int searchInsert(int[] nums, int target) {

    int lo = 0;
    int hi = nums.length;

    while (lo < hi) {

      int mid = lo + ((hi - lo)/2);

      if(nums[mid] == target) {
        return mid;
      }
      if(nums[mid] >= target) {
        hi = mid;
      }else {
        lo = mid +1;
      }

    }
    return lo;

  }
}
