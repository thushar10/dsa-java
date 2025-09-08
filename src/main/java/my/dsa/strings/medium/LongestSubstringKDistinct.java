package my.dsa.strings.medium;

public class LongestSubstringKDistinct {


  public static void main(String[] args) {
    LongestSubstringKDistinct lskd = new LongestSubstringKDistinct();
    int count = lskd.getLongestSubstringLength("eceba", 2);

    System.out.println(count);
  }


  public int getLongestSubstringLength(String s, int k) {
    if (k == 0) return 0;

    int[] freq = new int[128]; // works for lowercase/uppercase ASCII
    int left = 0, distinct = 0, best = 0;

    for (int right = 0; right < s.length(); right++) {
      char ch = s.charAt(right);
      if (freq[ch] == 0) distinct++;  // new distinct
      freq[ch]++;                      // include ch

      // shrink until valid
      while (distinct > k) {
        char lc = s.charAt(left);
        freq[lc]--;
        if (freq[lc] == 0) distinct--; // only when it fully leaves
        left++;
      }

      best = Math.max(best, right - left + 1);
    }
    return best;
  }

}
