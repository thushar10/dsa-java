package my.dsa.redo;

public class LowerUpperBound {


  public static void main(String[] args) {
    LowerUpperBound lowerUpperBound = new LowerUpperBound();
    int[] ints = lowerUpperBound.lowerUpper(new int[]{1, 3, 5, 5, 7, 9}, 5);

    System.out.println("lower bound is "+ints[0]+" and upper bound is "+ints[1]);

  }



  private int [] lowerUpper(int [] arr, int target) {

    int lo = 0;
    int hi = arr.length -1;

    while (lo < hi) {

      int mid = lo +((hi - lo)/2);
      if(arr[mid] < target) {
        lo =  mid +1;
      }else {
        hi = mid;
      }
    }

    int lower = hi;

    if(arr[hi] != target) {
      return new int [] {-1, -1};
    }

    lo = 0;
    hi = arr.length -1;

    while (lo < hi) {

      int mid = lo +((hi - lo + 1)/2);
      if(arr[mid] > target) {
        hi =  mid -1;
      }else {
        lo = mid;
      }
    }

    int higher = lo;


    return new int [] {lower, higher};
  }
}
