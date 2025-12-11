package my.dsa.redo;

public class LongestRepeating {

  public static void main(String[] args) {

    LongestRepeating longestRepeating = new LongestRepeating();
    int len = getLongestRepeatingLength("AABABBA", 1);
    System.out.println(len);

  }

  private static int getLongestRepeatingLength(String str, int k) {

    int left = 0;
    int maxLen = 0;
    int [] chars = new int[256];
    int maxFreqChar = 0;

    for(int right = 0; right< str.length(); right++) {

      char curr = str.charAt(right);
      chars[curr]++;
      maxFreqChar = Math.max(maxFreqChar, chars[curr]);

      while ((right - left + 1) - maxFreqChar > k) {
        chars[str.charAt(left)]--;
        left++;
      }

      maxLen = Math.max(maxLen, right - left + 1);


    }

    return maxLen;
  }


}
