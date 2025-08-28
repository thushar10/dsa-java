package my.dsa.arrays.medium;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class GroupAnagramTest {


  @Test
  public void testGroupAnagram() {

    GroupAnagram groupAnagram = new GroupAnagram();
    List<List<String>> groupedAnagramsFreq = groupAnagram.groupedAnagramsFreq(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    assertEquals(3, groupedAnagramsFreq.size());

  }

}
