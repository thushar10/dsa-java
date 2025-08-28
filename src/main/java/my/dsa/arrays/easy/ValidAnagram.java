package my.dsa.arrays.easy;

import java.util.Arrays;

public class ValidAnagram {

  public static void main(String[] args) {
    ValidAnagram validAnagram = new ValidAnagram();
    boolean va = validAnagram.validAnagram("mañana", "aaamnñ");
    System.out.println(va);
  }


  public boolean validAnagram(String s, String t) {
    int [] characterFreq = new int[26];

    if(s.length() != t.length()) {
      return false;
    }


    for(int i = 0; i<s.length(); i++) {
      boolean isUppercase = false;
      if(!isAsciiCharacter(s, i)) {
        return false;
      }
      if(Character.isUpperCase(s.charAt(i))) {
        isUppercase = true;
      }
      int at = s.charAt(i);

      int i1 = !isUppercase ? at - 'a' : at - 'A';
      characterFreq[i1] = characterFreq[i1] +1;
    }

    for(int i = 0; i<t.length(); i++) {
      boolean isUppercase = false;
      if(!isAsciiCharacter(t, i)) {
        return false;
      }
      if(Character.isUpperCase(t.charAt(i))) {
        isUppercase = true;
      }
      int at = t.charAt(i);

      int i1 = !isUppercase ? at - 'a' : at - 'A';
      characterFreq[i1] = characterFreq[i1] -1;
    }

    return Arrays.stream(characterFreq).noneMatch(i -> i!=0);
  }

  private static boolean isAsciiCharacter(String s, int i) {
    return (s.charAt(i) >= 'a' && s.charAt(i) <= 'z') || (s.charAt(i) >= 'A' && s.charAt(i) <= 'Z');
  }
}
