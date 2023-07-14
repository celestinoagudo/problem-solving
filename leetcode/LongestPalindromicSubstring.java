package leet.code.practice.set;

import java.util.HashSet;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    var message = "Longest Palindromic Substring: ";
    System.out.println(message + getLongest("forgeeksskeegfor"));
    System.out.println(message + getLongest("forgeeksskeega"));
    System.out.println(message + getLongest("ageeksskeegfor"));
    System.out.println(message + getLongest("GeEks"));
    System.out.println(message + getLongest("dabcba"));
  }

  /**
   * Given a string str, the task is to find the longest substring which is a palindrome. Input: str
   * = “forgeeksskeegfor” Output: “geeksskeeg” Explanation: There are several possible palindromic
   * substrings like “kssk”, “ss”, “eeksskee” etc. But the substring “geeksskeeg” is the longest
   * among all.
   * 
   * @param input text
   * @return longest palindromic substring
   */
  private static String getLongest(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is not valid");
    }
    var substrings = new HashSet<String>();
    var palindromes = new HashSet<String>();
    for (var a = 0; a < input.length(); ++a) {
      for (var b = a + 1; b <= input.length(); ++b) {
        substrings.add(input.substring(a, b));
      }
    }
    validate(substrings, palindromes);
    return palindromes.stream().max((first, second) -> first.length() - second.length()).orElse("");
  }

  /**
   * utility method that checks whether substring is palindrome
   * 
   * @param substrings substrings set
   * @param palindromes container of valid palindromes
   */
  private static void validate(final HashSet<String> substrings,
      final HashSet<String> palindromes) {
    var start = 0;
    var end = 0;
    var isValid = true;
    for (var substring : substrings) {
      end = substring.length() - 1;
      while (start <= end) {
        if (Character.toLowerCase(substring.charAt(start)) != Character
            .toLowerCase(substring.charAt(end))) {
          isValid = false;
        }
        if (!isValid) {
          break;
        }
        ++start;
        --end;
      }
      if (isValid) {
        palindromes.add(substring);
      }
      start = 0;
      isValid = true;
    }
  }
}
