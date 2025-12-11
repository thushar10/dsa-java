package my.dsa.stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class PrintNUsingStack {

  public static void main(String[] args) {

    print(10, 1);

    System.out.println(sum(5));
    System.out.println(sumStack(5));
  }

  public static void print(int n, int offset) {
    if(n > 0) {
      System.out.println(offset);
      print(n -1, ++offset);
    }
  }

  public static int sum(int n) {
    if (n <= 0) {
      return 0; // Base case
    } else {
      // The "unfinished addition" is here: n + [result of sum(n-1)]
      return n + sum(n - 1);
    }
  }

  public static int sumStack(int n) {

    Deque<Integer> stack = new ArrayDeque<>();

    for (int i = 1; i<=n; i++) {
      stack.push(i);
    }

    int sum = 0;

    while (!stack.isEmpty()) {
      sum += stack.pop();
    }

   return sum;
  }

  public static void printStack(int n) {

    Deque<Integer> deque = new ArrayDeque<>();



  }


}
