package my.dsa.redo;

import javax.swing.text.StyledEditorKit;
import java.util.*;

public class NextGreaterElement {

  public static void main(String[] args) {
    NextGreaterElement nextGreaterElement = new NextGreaterElement();

    int[] ints = nextGreaterElement.nextGreatest(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2});

    Arrays.stream(ints).forEach(e -> System.out.println(e));

  }

  public  int [] nextGreatest (int [] nums1, int [] nums2 ) {

    Deque<Integer> stack = new ArrayDeque<>();
    stack.push(nums2[0]);
    Map<Integer, Integer> map = new HashMap<>();
    for(int i =1; i< nums2.length; i++) {

      if(nums2[i] > stack.peek()) {
        int pop = stack.pop();
        stack.push(nums2[i]);
        map.put(pop, nums2[i]);
      } else {
        stack.push(nums2[i]);
      }


    }

    while (!stack.isEmpty()) {
      map.put(stack.pop(), -1);
    }


    int [] res = new int[nums1.length];
    for (int i =0; i< nums1.length; i++) {
      res[i] =  map.get(nums1[i]);
    }

    return res;
  }


}
