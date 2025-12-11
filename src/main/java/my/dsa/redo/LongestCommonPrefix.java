package my.dsa.redo;


public class LongestCommonPrefix {

  public static void main(String[] args) {
    LongestCommonPrefix commonPreFix = new LongestCommonPrefix();
    String s = commonPreFix.commonPrefix(new String[]{"flower", "flow", "flight"});

    System.out.println(s);

  }

  public String commonPrefix (String [] arr) {
    String prefix = arr[0];

    outer : for (int i =1 ; i< arr.length; i++) {
      StringBuilder build = new StringBuilder();
      inner: for (int j =0; j<prefix.length(); j++) {

        if( arr[i].length() > j && arr[i].charAt(j) == prefix.charAt(j)) {

          build.append(prefix.charAt(j));
        }else {
          break;
        }

      }
      prefix = build.toString();

    }


    return prefix;
  }


}
