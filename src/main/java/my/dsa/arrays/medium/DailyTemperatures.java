package my.dsa.arrays.medium;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class DailyTemperatures {

  public static void main(String[] args) {
    DailyTemperatures dailyTemperatures = new DailyTemperatures();
    dailyTemperatures.dailyTemperatures(new int [] {73,74,75,71,69,72,76,73});
  }


  public int[] dailyTemperatures(int[] T) {
    int n = T.length;
    int[] ans = new int[n];
    Deque<Integer> stack = new ArrayDeque<>(); // holds indices, temps decreasing

    for (int i = 0; i < n; i++) {
      while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
        int j = stack.pop();      // index waiting for a warmer day
        ans[j] = i - j;           // distance to next warmer day
      }
      stack.push(i);                // push current index
    }
    return ans; // leftover indices have 0 by default (no warmer day)
  }

}
