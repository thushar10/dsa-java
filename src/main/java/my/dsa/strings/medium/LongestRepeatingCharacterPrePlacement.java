package my.dsa.strings.medium;

import my.dsa.arrays.easy.LongestCommonPreFix;

public class LongestRepeatingCharacterPrePlacement {

  public static void main(String[] args) {

    LongestRepeatingCharacterPrePlacement lrcp = new LongestRepeatingCharacterPrePlacement();
    lrcp.characterReplacement("ABAB", 2);
  }


  public int characterReplacement(String s, int k) {

    int max = 0;

    int maxFreq = 0;
    int [] charArr = new int[26];
    int l = 0;
    for(int r = 0; r< s.length(); r++) {
      int ch = s.charAt(r);
      charArr[ch - 'A'] = charArr[ch-'A'] +1;

      maxFreq = Math.max(maxFreq, charArr[ch - 'A']);

      while((r - l +1) - maxFreq > k) {
        charArr[s.charAt(l) - 'A']--;// = charArr[left - 'A']--;
        l++;
      }

      max = Math.max(max, (r-l+1));

    }


    return max;
  }

}
