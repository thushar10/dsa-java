package my.dsa.redo;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {

  public static void main(String[] args) {

    DailyTemperatures dailyTemperatures = new DailyTemperatures();
    int[] ints = dailyTemperatures.dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73});

    Arrays.stream(ints).forEach(System.out::println);

  }


  public int[] dailyTemperatures(int[] temperatures) {

    Deque<Integer> deque = new ArrayDeque<>();
    int [] ouput = new int[temperatures.length];

    deque.push(temperatures.length-1);
    for(int i = temperatures.length-2; i>=0; i--) {
      if(temperatures[i] > temperatures[deque.peek()]) {
       deque.pop();

       if(deque.isEmpty()) {
         ouput[i] = 0;
       }else {
         while (!deque.isEmpty()) {
           if(temperatures[i] < temperatures[deque.peek()]) {
             ouput[i] = deque.peek() - i;
             break;
           }else {
             deque.pop();
           }
         }
       }
        deque.push(i);
      }else {
        ouput[i] = deque.peek() - i;
        deque.push(i);
      }


    }

    return ouput;

  }
}
