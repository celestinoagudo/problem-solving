package leet.code.practice.set;

import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicatesFromSortedArrayII {

  public static void main(String[] args) {
    System.out.println(removeDuplicates(new int[] {0, 0, 1, 1, 1, 1, 2, 3, 3}));
  }

  /**
   * Given an integer array numbers sorted in non-decreasing order, remove some duplicates in-place
   * such that each unique element appears at most twice. The relative order of the elements should
   * be kept the same.
   * 
   * @param numbers integer array
   * @return number of elements in the array after removing duplicates > 2
   */
  public static int removeDuplicates(final int[] numbers) {
    final var frequences = new HashMap<Integer, Integer>();
    var filtered = new int[numbers.length];
    var counter = 0;
    for (var number : numbers) {
      final Integer occurence = frequences.get(number);
      if (frequences.containsKey(number)) {
        if (occurence.intValue() < 2) {
          filtered[counter++] = number;
        }
        frequences.put(number, occurence + 1);
      } else {
        frequences.put(number, 1);
        filtered[counter++] = number;
      }
    }
    Arrays.fill(numbers, 0);
    System.arraycopy(filtered, 0, numbers, 0, numbers.length);
    return counter;
  }



}
