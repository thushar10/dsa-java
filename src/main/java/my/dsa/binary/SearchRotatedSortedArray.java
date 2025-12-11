package my.dsa.binary;

public class SearchRotatedSortedArray {

  public static void main(String[] args) {
    SearchRotatedSortedArray searchRotatedSortedArray = new SearchRotatedSortedArray();
    int search = searchRotatedSortedArray.findMinWithDuplicates(new int[]{2,2,2,0,1,2});

    System.out.println(search);
  }

  public int searchWithoutDupliacates(int[] nums) {

    int lo = 0;
    int hi = nums.length -1;

    while (lo < hi) {
      int mid = lo + ((hi - lo)/2);
      if(nums[mid] > nums[hi]) { // not sorted
        lo = mid +1;
      }else {
         hi= mid;
      }
    }


    return hi;
  }


  public int findMinWithDuplicates(int[] nums) {
    int lo = 0;
    int hi = nums.length - 1;

    while (lo < hi) {
      int mid = lo + (hi - lo) / 2;

      if (nums[mid] > nums[hi]) {
        // pivot is in the right half
        lo = mid + 1;
      } else if(nums[mid] < nums[hi]) {
        // pivot is in the left half (including mid)
        hi = mid;
      }else {
        hi--;
      }
    }

    return lo; // lo == hi, pivot index
  }


}
