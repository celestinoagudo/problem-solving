package leet.code.practice.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class WordBreak {

  public static void main(String[] args) {
    final String[] dictionary = new String[] {"mobile", "samsung", "sam", "sung", "man", "mango",
        "icecream", "and", "go", "i", "like", "ice", "cream"};
    System.out.println(canBeSegmented("ilikesamsung", dictionary));
    System.out.println(canBeSegmented("iiiiiiii", dictionary));
    System.out.println(canBeSegmented("ilikelikeimangoiii", dictionary));
    System.out.println(canBeSegmented("samsungandmango", dictionary));
    System.out.println(canBeSegmented("samsungandmangok", dictionary));
    System.out
        .println(canBeSegmented("catsandog", new String[] {"cats", "dog", "sand", "and", "cat"}));
    System.out.println(canBeSegmented("applepenapple", new String[] {"apple", "pen"}));
  }

  /**
   * Given a string s and a dictionary of words dict, determine if s can be segmented into a
   * space-separated sequence of one or more dictionary words. For example, given s = "leetcode",
   * dict = ["leet", "code"]. Return true because "leetcode" can be segmented as "leet code".
   * 
   * @param input text to check if can be segmented
   * @param dictionary list of words
   * @return if can be segmented
   */
  private static boolean canBeSegmented(final String input, final String[] dictionary) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    var substrings = new ArrayList<String>();
    var dictionaryAsList = Arrays.asList(dictionary);
    for (var a = 0; a < input.length(); ++a) {
      for (var b = a + 1; b <= input.length(); ++b) {
        var substring = input.substring(a, b);
        if (dictionaryAsList.contains(substring)) {
          a += substring.length();
          substrings.add(substring);
        }
      }
    }
    final String collected = substrings.stream().collect(Collectors.joining());
    return input.equals(collected);
  }
}
