package my.dsa.redo;

public class LongestKMostDistinct {


  public static void main(String[] args) {
    LongestKMostDistinct longestKMostDistinct = new LongestKMostDistinct();

    int len = longestKMostDistinct.longestKMostDistinct("abbbbbbc", 2);
    System.out.println(len);

  }

  int longestKMostDistinct(String str, int k) {

    int left = 0;
    int distinctCount = 0;
    int [] characters = new int[256];
    int max = 0;

    for(int right = 0; right < str.length(); right++) {

      if(characters[str.charAt(right)] == 0) {
        distinctCount++;
      }
      characters[str.charAt(right)]++;

      while (distinctCount > k) {

        characters[str.charAt(left)]--;

        if(characters[str.charAt(left)] == 0) {
          distinctCount--;
        }
        left++;

      }

      max = Math.max(right - left +1, max);



    }



    return max;
  }


}
