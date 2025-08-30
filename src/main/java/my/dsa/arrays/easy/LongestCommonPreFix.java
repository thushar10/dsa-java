package my.dsa.arrays.easy;

public class LongestCommonPreFix {

  public String longestCommonPrefix(String[] strs) {

    String commonPrefix = "";

      if(strs.length == 0) {
        return "";
      }else if(strs.length == 1) {
        return strs[0];
      }else {

        String firstWord = strs[0];
        for(int i= 0; i< firstWord.length(); i++) {
          int count = 0;
          for(int j = 1; j< strs.length; j++) {
            if(strs[j].startsWith(firstWord.substring(0, i))) {
              count ++;
            }
          }
          if(count == strs.length-1) {
            commonPrefix = firstWord.substring(0, i);
          }

        }


      }

    return commonPrefix;
  }


  public String longestCommonPrefixBest(String[] strs) {

    String prefix = "";

    if(strs.length == 0) {
      return "";
    }else if(strs.length == 1) {
      return strs[0];
    }else {

      prefix = strs[0];
      for(int i =1; i< strs.length; i++) {
        while(!strs[i].startsWith(prefix)) {
          prefix = prefix.substring(0, prefix.length()-1);
          if (prefix.isEmpty()) return "";
        }

      }
    }

    return prefix;
  }


}
