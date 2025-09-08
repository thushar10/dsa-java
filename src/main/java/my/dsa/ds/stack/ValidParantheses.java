package my.dsa.ds.stack;

import java.util.*;

public class ValidParantheses {

  public static void main(String[] args) {
    ValidParantheses validParantheses = new ValidParantheses();
    boolean valid = validParantheses.isValid("({}([]))");
    System.out.println(valid);

  }

  public boolean isValid(String s) {

    Map<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put(']', '[');
    map.put('}', '{');
    Deque<Character> stack = new ArrayDeque<>();

    for(int i= 0; i< s.length(); i++) {
      Character ch = s.charAt(i);

      if(!map.containsKey(ch))
        stack.push(ch);
      else {
        if(!stack.isEmpty()) {
          Character peek = stack.peek();
          if(!peek.equals(map.get(ch))) {
            return false;
          }else {
            stack.pop();
          }
        }else {
          return false;
        }

      }
    }

    return stack.isEmpty();
  }
}
