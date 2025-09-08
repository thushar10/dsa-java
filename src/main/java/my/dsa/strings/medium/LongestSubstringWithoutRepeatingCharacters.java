package my.dsa.strings.medium;

import my.dsa.arrays.easy.LongestCommonPreFix;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters {

  public static void main(String[] args) {
    LongestSubstringWithoutRepeatingCharacters longestSubstringWithoutRepeatingCharacters =  new LongestSubstringWithoutRepeatingCharacters();


    int sub = longestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("pwwpkew");
    System.out.println(sub);

  }




  //in this n2 solution , we are maintaining a seen array for all ascii chars
  //for every character , we iterate it again and at any point , we store that in a  seen array,
  // if seen, break, else best = current sequence between i and j is the longest one .

  // example on abcabcbb
  //we start from a and i is at a. mark a as seen
  // then we move j to b b is unseen, mark b as seen so set best as max of best and j-i+1 and move j to c.
  // c is unseen, mark c as seen , so we make best j-i+1 = 3 .
  // increment j, now j is 4 and letter is 'a'. its alreayd seen, so we increment i to 1. and start rescan from there.
  //so we are rescanning everything 2 times

  public int longestSubstringN3(String s) {

    if(s.length() == 0) {
      return 0;
    } else if (s.length() == 1) {
      return 1;
    }else {
      int best = 0;
      for(int i =0; i < s.length(); i++) {
        boolean seen [] = new boolean[256];
        for(int j = i; j< s.length(); j++) {
          int c = s.charAt(j);
          if(seen[c]) break;
          seen[c] = true;
          best = Math.max(best, j - i + 1);
        }
      }
      return best;
    }

  }



  public int lengthOfLongestSubstring(String s) {


    if(s.length() ==0) {
      return 0;
    }else if(s.length() == 1) {
      return 1;
    } else {

      int max = 1;

      Map<Character, Integer> map = new HashMap<>();
      int l =0;
      for(int r = 0; r< s.length(); r++) {
        Character ch = s.charAt(r);

        if(map.containsKey(ch) && map.get(ch) >= l) {
          l = map.get(ch) + 1;
        }
        map.put(ch, r);
        max = Math.max(max, r-l+1);

      }

      return max;
    }
  }
}
