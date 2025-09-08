package my.dsa.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LongestCommonPrefixTest {


  @Test
  public void longestCommonPrefixTest() {
    LongestCommonPreFix longestCommonPreFix = new LongestCommonPreFix();
    assertEquals("fl", longestCommonPreFix.longestCommonPrefix(new String [] {"flower", "flow", "flight"}));
    assertEquals("", longestCommonPreFix.longestCommonPrefix(new String [] {"dog","racecar","car"}));

    assertEquals("fl", longestCommonPreFix.longestCommonPrefixBest(new String [] {"flower", "flow", "flight"}));
    assertEquals("", longestCommonPreFix.longestCommonPrefixBest(new String [] {"dog","racecar","car"}));
  }

  @Test
  public void longestCommonPrefixTestEmpty() {
    LongestCommonPreFix longestCommonPreFix = new LongestCommonPreFix();
    assertEquals("", longestCommonPreFix.longestCommonPrefix(new String [] {}));
    assertEquals("", longestCommonPreFix.longestCommonPrefixBest(new String [] {}));


  }

  @Test
  public void longestCommonPrefixTestOneWord() {
    LongestCommonPreFix longestCommonPreFix = new LongestCommonPreFix();
    assertEquals("flower", longestCommonPreFix.longestCommonPrefix(new String [] {"flower"}));
    assertEquals("flower", longestCommonPreFix.longestCommonPrefixBest(new String [] {"flower"}));


  }
}
