package dsa.part.one;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class HashTableExercises {

  public static void main(String[] args) {
    System.out
        .println("First non-repeating character: " + getFirstNonRepeatingCharacter("green apple"));
    System.out.println("First repeating character: " + getFirstRepeatingCharacter("gren apple"));
    System.out.println(
        "Most repeated number: " + getMostRepeatedNumber(new int[] {1, 2, 2, 3, 3, 3, 4, 4, 4, 4}));
    System.out.println("Pairs with difference [%d]: ".formatted(4)
        + countPairsWithDifference(new int[] {8, 12, 16, 4, 0, 20}, 4));
    System.out
        .println("Two Sum [%d]: ".formatted(6) + Arrays.toString(twoSum(new int[] {3, 2, 4}, 6)));
  }

  private static int countPairsWithDifference(final int[] numbers, final int difference) {
    final Set<Integer> distinct = Arrays.stream(numbers).boxed().collect(Collectors.toSet());
    return (int) distinct.stream().filter(element -> distinct.contains(element + difference))
        .count();
  }

  private static Character getFirstNonRepeatingCharacter(final String text) {
    if ((text == null) || text.isEmpty()) {
      throw new IllegalArgumentException("Text contains no value");
    }
    int[] histogram = new int[256];
    for (char character : text.toCharArray()) {
      histogram[character] = histogram[character] + 1;
    }
    for (char character : text.toCharArray()) {
      if (histogram[character] == 1) {
        return character;
      }
    }
    return null;
  }

  private static Character getFirstRepeatingCharacter(final String text) {
    if ((text == null) || text.isEmpty()) {
      throw new IllegalArgumentException("Text contains no value");
    }
    int[] histogram = new int[256];
    for (char character : text.toCharArray()) {
      if (histogram[character] == 1) {
        return character;
      }
      histogram[character] = histogram[character] + 1;
    }
    return null;
  }

  private static Integer getMostRepeatedNumber(final int[] numbers) {
    if ((numbers == null) || (numbers.length == 0)) {
      throw new IllegalArgumentException("No array elements");
    }
    final Map<Integer, Integer> frequencies = new HashMap<>();
    for (int number : numbers) {
      if (frequencies.containsKey(number)) {
        frequencies.put(number, frequencies.get(number) + 1);
      } else {
        frequencies.put(number, 1);
      }
    }
    return frequencies.entrySet().stream()
        .sorted((first, second) -> second.getValue() - first.getValue()).findFirst()
        .map(entry -> entry.getKey()).orElse(null);
  }

  private static int[] twoSum(final int[] numbers, final int summation) {
    Map<Integer, Integer> mappings = new HashMap<>();
    for (var index = 0; index < numbers.length; ++index) {
      int complement = summation - numbers[index];
      if (mappings.containsKey(complement)) {
        return new int[] {mappings.get(complement), index};
      } else {
        mappings.put(numbers[index], index);
      }
    }
    return new int[] {};
  }
}
