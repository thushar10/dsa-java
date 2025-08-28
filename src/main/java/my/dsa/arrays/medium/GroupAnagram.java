package my.dsa.arrays.medium;

import java.util.*;
import java.util.stream.Stream;

public class GroupAnagram {

  public static void main(String[] args) {
    GroupAnagram groupAnagram = new GroupAnagram();

    List<List<String>> lists = groupAnagram.groupedAnagramsSort(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

    List<List<String>> lists1 = groupAnagram.groupedAnagramsFreq(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});

    lists.forEach(System.out::print);
    System.out.println("");
    lists1.forEach(System.out::print);


  }


  List<List<String>> groupedAnagramsSort(String[] strs) {

    Map<String, List<String>> grouped = new HashMap<>();
    for(int i =0; i<strs.length; i++) {
      char [] arr = strs[i].toCharArray();
      Arrays.sort(arr);

      String key = new String(arr); // canonical form

      if(grouped.containsKey(key)) {
        List<String> strings = grouped.get(key);
        strings.add(strs[i]);
        grouped.put(key, strings);
      }else {
        List<String> list = new ArrayList<>();
        list.add(strs[i]);
        grouped.put(key, list);
      }

    }
    return grouped.values().stream().toList();
  }

  List<List<String>> groupedAnagramsFreq(String[] strs) {

    Map<String, List<String>> grouped = new HashMap<>();
    for(int i =0; i<strs.length; i++) {

      int [] freq = new int[26];
      for(int j =0; j<strs[i].length(); j++) {
        int at = strs[i].charAt(j);
        freq[at - 'a'] = freq[at - 'a']+1;
      }

      StringBuilder sb = new StringBuilder();
      for(int j =0; j<freq.length; j++) {
        sb.append("#").append(freq[j]);
      }
      String key = sb.toString();//canonical form


      grouped.computeIfAbsent(key, k -> new ArrayList<>()).add(strs[i]);
//      if(grouped.containsKey(key)) {
//        List<String> strings = grouped.get(key);
//        strings.add(strs[i]);
//        grouped.put(key, strings);
//      }else {
//        List<String> list = new ArrayList<>();
//        list.add(strs[i]);
//        grouped.put(key, list);
//      }

    }
    return grouped.values().stream().toList();
  }
}
