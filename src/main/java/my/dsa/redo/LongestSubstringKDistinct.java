package my.dsa.redo;

public class LongestSubstringKDistinct {

  public static void main(String[] args) {
    LongestSubstringKDistinct n = new LongestSubstringKDistinct();
    int len = n.getLongestSubstringLength("nikita", 3);

    System.out.println(len);
  }

  public int getLongestSubstringLength(String s, int k) {

    int [] arr = new int[128];
    int l = 0;
    //arr[s.charAt(l)]++;
    int distinctCount = 0;
    int max = 0;

    for(int r = 0; r< s.length(); r++) {
      if(arr[s.charAt(r)] == 0) {

        distinctCount++;
      }

      while (distinctCount >k) {
        arr[s.charAt(l)]--;
        if(arr[s.charAt(l)] == 0) {
          distinctCount --;
        }
        l++;
      }
      arr[s.charAt(r)]++;

      max = Math.max(r - l+1, max);



    }


    return max;
  }
}
