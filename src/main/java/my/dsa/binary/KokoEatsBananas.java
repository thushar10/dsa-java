package my.dsa.binary;

import java.util.Arrays;
import java.util.OptionalInt;

public class KokoEatsBananas {

  public static void main(String[] args) {
    KokoEatsBananas kokoEatsBananas = new KokoEatsBananas();
    int i = kokoEatsBananas.minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6);
    System.out.println(i);
  }

  public int minEatingSpeed(int[] piles, int h) {

    //find max in the array.
    int max = Arrays.stream(piles).max().getAsInt();

    int [] arr = new int [max];
    for (int i = 0; i< max; i++) {
      arr[i] = i+1;
    }

    int lo = 0;
    int hi = arr.length -1;

    while (lo < hi) {
      int mid = lo + ((hi - lo)/2);

      int k = arr[mid];
      //compute h for k
      int sumH = 0;
      for (int i = 0; i < piles.length; i++) {
        sumH+= (piles[i])%k == 0 ? (piles[i])/k : ((piles[i])/k)+1 ;
      }
      if(sumH> h) {
        lo = mid + 1;
      }else {
        hi = mid;
      }

    }


    return hi+1;
  }
}
