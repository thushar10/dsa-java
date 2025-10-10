package my.dsa.binary;

public class BinarySearch {


  public static void main(String[] args) {

    BinarySearch bs = new BinarySearch();
    int search = bs.search(new int[]{-1, 0, 3, 5, 8, 9}, 9);
    System.out.println(search);

  }


  public int search(int[] nums, int target) {

    int lo = 0;
    int hi = nums.length -1;
    while( lo <= hi) {

      int mid = lo + ((hi - lo)/2);
      if(target == nums[mid]) {
        return mid;
      }else if(target > nums[mid]) {
        lo = mid + 1;
      }
      else {
        hi = mid - 1;
      }

    }
    return  -1;

  }
}
