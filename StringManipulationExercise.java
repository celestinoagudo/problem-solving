package dsa.part.three;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StringManipulationExercise {

  public static void main(String[] args) {
    System.out.println("Number of vowels: " + getNumberOfVowels("hello"));
    System.out.println("Reverse a String: " + reverseString("blue"));
    System.out
        .println("Reverse words in the sentence: " + reverseOrderOfWords("Trees are beautiful"));
    System.out.println("Check if rotation: " + checkIfRotation("ABCD", "DABC"));
    System.out.println("Remove duplicate : " + removeDuplicate("Hellooo!!"));
    System.out.println("Most Repeated Character : " + mostRepeatedChar("Hellooo!!"));
    System.out
        .println("Most Repeated Character (via array): " + mostRepeatedCharViaArray("Hellooo!!"));
    System.out.println("Capitalize : " + capitalize("  TREES    are        beautiful  "));
    System.out.println("Check if anagram : " + checkIfAnagram("abcd", "adbc"));
    System.out
        .println("Check if anagram (via histogram): " + checkIfAnagramViaHistogram("abcd", "adbc"));
    System.out.println("Check if palindrome : " + checkIfPalindrome("abbA"));
    System.out
        .println("Check if palindrome (via pointers): " + checkIfPalindromeViaPointers("abbA"));
  }

  private static String capitalize(final String input) {
    if (((input == null) || input.isBlank())) {
      throw new IllegalArgumentException("Input is invalid");
    }
    return Arrays.asList(input.replaceAll(" +", " ").split(" ")).stream()
        .filter(word -> !word.isBlank()).collect(Collectors.toList()).stream().map(word -> {
          var asString = word;
          var transformed = new StringBuilder(asString.toLowerCase());
          transformed.replace(0, 1, asString.substring(0, 1).toUpperCase());
          return transformed.toString();
        }).collect(Collectors.joining(" "));
  }

  private static boolean checkIfAnagram(final String first, final String second) {
    if ((first == null) || (second == null) || first.isBlank() || second.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    if (first.length() != second.length()) {
      return false;
    }
    var firstAsArray = first.toLowerCase().toCharArray();
    var secondAsArray = second.toLowerCase().toCharArray();
    Arrays.sort(firstAsArray);
    Arrays.sort(secondAsArray);
    return Arrays.equals(firstAsArray, secondAsArray);
  }

  private static boolean checkIfAnagramViaHistogram(final String first, final String second) {
    if ((first == null) || (second == null) || first.isBlank() || second.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    if (first.length() != second.length()) {
      return false;
    }
    final int asciiSize = 256;
    int[] frequencies = new int[asciiSize];
    for (var index = 0; index < first.length(); ++index) {
      frequencies[first.charAt(index)]++;
      frequencies[second.charAt(index)]--;
    }
    for (var frequency : frequencies) {
      if (frequency != 0) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkIfPalindrome(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    var middle = input.length() / 2;
    if ((input.length() % 2) == 0) {
      var first = input.substring(0, middle);
      var second = new StringBuilder(input.substring(middle));
      return first.equalsIgnoreCase(second.reverse().toString());
    } else {
      var first = input.substring(0, middle);
      var second = new StringBuilder(input.substring(middle + 1));
      return first.equalsIgnoreCase(second.reverse().toString());
    }
  }

  private static boolean checkIfPalindromeViaPointers(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    var transformed = input.toLowerCase();
    var left = 0;
    var right = transformed.length() - 1;
    while (left < right) {
      if (transformed.charAt(left++) != transformed.charAt(right--)) {
        return false;
      }
    }
    return true;
  }

  private static boolean checkIfRotation(final String input, final String rotation) {
    if ((input == null) || (rotation == null) || input.isBlank() || rotation.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    if (input.length() != rotation.length()) {
      return false;
    }
    var stringBuffer = new StringBuilder(input);
    stringBuffer.append(input);
    return stringBuffer.toString().contains(rotation);
  }

  private static int getNumberOfVowels(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    int count = 0;
    var vowels = Set.of('a', 'e', 'i', 'o', 'u');
    for (var letter : input.toLowerCase().toCharArray()) {
      if (vowels.contains(letter)) {
        ++count;
      }
    }
    return count;
  }

  private static Character mostRepeatedChar(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    final Map<Character, Integer> frequencies = new HashMap<>();
    for (var character : input.toCharArray()) {
      if (frequencies.containsKey(character)) {
        var value = frequencies.get(character) + 1;
        frequencies.put(character, value);
      } else {
        frequencies.put(character, 1);
      }
    }
    return frequencies.entrySet().stream()
        .max((first, second) -> first.getValue() - second.getValue()).map(entry -> entry.getKey())
        .orElse(null);
  }

  private static Character mostRepeatedCharViaArray(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    final var asciiSize = 256;
    var frequencies = new int[asciiSize];
    for (var index = 0; index < input.length(); ++index) {
      frequencies[input.charAt(index)]++;
    }
    int indexOfMaxOccurence = 0;
    int maxValue = 0;
    for (var index = 0; index < frequencies.length; ++index) {
      if (frequencies[index] > maxValue) {
        maxValue = frequencies[index];
        indexOfMaxOccurence = index;
      }
    }
    return (char) indexOfMaxOccurence;
  }

  private static String removeDuplicate(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    return Arrays.asList(input.split("")).stream().distinct().collect(Collectors.joining());
  }

  private static String reverseOrderOfWords(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    var sentenceAsArray = input.split(" ");
    var reversed = new String[sentenceAsArray.length];
    for (int a = sentenceAsArray.length - 1, index = 0; a >= 0; --a, ++index) {
      reversed[index] = sentenceAsArray[a];
    }
    return Arrays.asList(reversed).stream().collect(Collectors.joining(" "));
  }

  private static String reverseString(final String input) {
    if ((input == null) || input.isBlank()) {
      throw new IllegalArgumentException("Input is invalid");
    }
    var reversed = new char[input.length()];
    for (int a = input.length() - 1, index = 0; a >= 0; --a, ++index) {
      reversed[index] = input.charAt(a);
    }
    return new String(reversed);
  }
}
