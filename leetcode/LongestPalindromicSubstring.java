package leet.code.practice.set;

public class LongestPalindromicSubstring {

  public static void main(String[] args) {
    var message = "Longest Palindromic Substring: ";
    System.out.println(message + getLongest("forgeeksskeegfor"));
    System.out.println(message + getLongest("forgeeksskeega"));
    System.out.println(message + getLongest("ageeksskeegfor"));
    System.out.println(message + getLongest("geeks"));
    System.out.println(message + getLongest("dabcba"));
    System.out.println(message + getLongest("abb"));
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
    if ((input == null) || input.isEmpty() || (input.length() == 1)) {
      return input;
    }
    final var asBuilder = new StringBuilder(input);
    if (input.equals(asBuilder.reverse().toString())) {
      return input;
    }
    var longest = "";
    var maximum = 0;
    for (var start = 0; start < input.length(); ++start) {
      for (var end = start + 1; end <= input.length(); ++end) {
        final String substring = input.substring(start, end);
        var reversed = (new StringBuilder(substring)).reverse();
        if (!input.contains(reversed.toString())) {
          break;
        }
        if (substring.equals(reversed.toString()) && (substring.length() > maximum)) {
          longest = substring;
          maximum = substring.length();
        }

      }
    }
    return longest;
  }
}
