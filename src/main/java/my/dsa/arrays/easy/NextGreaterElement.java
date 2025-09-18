package my.dsa.arrays.easy;

import java.util.*;

public class NextGreaterElement {

  public static void main(String[] args) {
    NextGreaterElement nextGreaterElement = new NextGreaterElement();

    Arrays.stream(nextGreaterElement.nextGreaterElement(new int [] {1,3,5,2,4}, new int [] {6,5,4,3,2,1,7})).forEach(e -> System.out.print(e+", "));


  }


  public int[] nextGreaterElementBrute(int[] nums1, int[] nums2) {

    //[4, 1, 2]
    //[1, 3, 4, 2]
    // [-1 ]
    int [] res = new int[nums1.length];
    for(int i =0; i< nums1.length; i++) {

      outer : for(int j = 0; j< nums2.length; j++) {

        //search for number nums1 [i] in nums 2 and get that index
        //start iterating from that point j to the end.
        //keep checking if the current number being iterated is > number at j
        //if greater, break outer for loop
        //else go until end and set -1 for i.

        if(nums1[i] == nums2[j]) {
          int k = j;
          while(k <=nums2.length-1) {
            int curr = nums2[k];
            if(curr > nums2[j]) {
              res[i] = curr;
              break outer;
            }
            if(k == nums2.length -1) {
              res[i] = -1;
              break outer;

            }
            k++;

          }

        }
      }

    }


    return res;
  }


  public int[] nextGreaterElementMap(int[] nums1, int[] nums2) {

    //[4, 1, 2]
    //[1, 3, 4, 2]
    // [-1 ]
    Map<Integer, Integer> map = new HashMap<>();
    for(int i =0; i<nums2.length; i++) {
      map.put(nums2[i], i);
    }

    int [] res = new int[nums1.length];
    for(int i =0; i< nums1.length; i++) {

      //outer : for(int j = 0; j< nums2.length; j++) {

        //search for number nums1 [i] in nums 2 and get that index
        //start iterating from that point j to the end.
        //keep checking if the current number being iterated is > number at j
        //if greater, break outer for loop
        //else go until end and set -1 for i.

      int j = map.get(nums1[i]);
        if(nums1[i] == nums2[j]) {
          int k = j;
          while(k <=nums2.length-1) {
            int curr = nums2[k];
            if(curr > nums2[j]) {
              res[i] = curr;
              break;
            }
            if(k == nums2.length -1) {
              res[i] = -1;
              break;

            }
            k++;

          }

        }
      //}

    }


    return res;
  }

  public int[] nextGreaterElement(int[] nums1, int[] nums2) {

    int [] res = new int[nums1.length];
    Deque<Integer> deque = new ArrayDeque<>();
    Map<Integer, Integer> nextGreater = new HashMap<>();
    deque.push(nums2[0]);

    for(int i =1; i<nums2.length; i++) {

      //nums2 = [6,5,4,3,2,1,7]
      //nums1 = [1,3,5,2,4] (subset of nums2, all values unique)

      if(!deque.isEmpty() && nums2[i] <= deque.peek()) {
        deque.push(nums2[i]);

      }else {
        int curr = nums2[i];
        while (!deque.isEmpty() && curr > deque.peek()) {
            Integer top = deque.pop();
            nextGreater.put(top, curr);
        }
        deque.push(curr);
      }


    }

    deque.forEach(e -> nextGreater.put(e, -1));

    for(int i = 0; i<nums1.length; i++) {
      res[i] = nextGreater.get(nums1[i]);
    }

    return res;
  }
}
