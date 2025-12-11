package my.dsa.redo;

public class MinRotatedArray {

  public static void main(String[] args) {
    MinRotatedArray minRotatedArray= new MinRotatedArray();


    int min = findMinInRotatedArray(new int [] {4, 5, 6, 7, 0, 1, 2});
    int minDup = findMinInRotatedArrayWithDuplicates(new int [] {2, 2, 2, 0, 1, 2});
    System.out.println(min);
    System.out.println(minDup);
  }

  private static int findMinInRotatedArrayWithDuplicates(int[] ints) {

    int lo = 0;
    int hi = ints.length -1;

    while (lo < hi) {
      int mid = lo + ((hi - lo) /2);

      if(ints [mid] > ints[hi]) {
        lo = mid + 1;
      }else if (ints [mid] < ints[hi]) {
        hi = mid;
      }else {
        hi --;
      }

    }

    return lo;
  }

  private static int findMinInRotatedArray(int[] ints) {

    int lo = 0;
    int hi = ints.length -1;

    while (lo < hi) {
      int mid = lo + ((hi - lo)/2);
      if(ints[mid] > ints[hi]) {
        lo = mid +1;
      }else {
        hi = mid;
      }
    }

    return lo;
  }
}
