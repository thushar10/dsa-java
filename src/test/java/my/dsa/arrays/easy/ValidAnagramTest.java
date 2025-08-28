package my.dsa.arrays.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidAnagramTest {

  @Test
  void returnsTrueForValidAnagrams() {
    ValidAnagram va = new ValidAnagram();
    assertTrue(va.validAnagram("silent", "listen"));
    assertTrue(va.validAnagram("anagram", "nagaram"));
    assertTrue(va.validAnagram("", "")); // empty strings are anagrams
  }

  @Test
  void returnsFalseForDifferentLettersSameLength() {
    ValidAnagram va = new ValidAnagram();
    assertFalse(va.validAnagram("abcd", "abce"));
  }

  @Test
  void returnsFalseForDifferentLengths() {
    ValidAnagram va = new ValidAnagram();
    assertFalse(va.validAnagram("abc", "ab"));
  }

  @Test
  void returnsFalseForSpecialCharacters() {
    ValidAnagram va = new ValidAnagram();
    assertFalse(va.validAnagram("silen!", "listen"));
  }

  @Test
  void returnsFalseForNonEnglishCharacters() {
    ValidAnagram va = new ValidAnagram();
    assertFalse(va.validAnagram("mañana", "aaamnñ"));
  }

  @Test
  void returnsTrueForUpperLower() {
    ValidAnagram va = new ValidAnagram();
    assertTrue(va.validAnagram("silEnt", "lIsten"));
  }

  @Test
  void multipleValidCases() {
    ValidAnagram va = new ValidAnagram();
    assertTrue(va.validAnagram("aabbcc", "baccab"));
    assertFalse(va.validAnagram("aabbccd", "baccab")); // one extra 'd'
  }
}
