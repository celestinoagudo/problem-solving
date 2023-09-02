package leet.code.practice.set;

import java.util.ArrayList;
import java.util.Arrays;

public class RemoveElement {

  public static void main(String[] args) {
    System.out.println(removeElement(new int[] {3, 2, 2, 3}, 3));
  }

  /**
   * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
   * The order of the elements may be changed. Then return the number of elements in nums which are
   * not equal to val. Change the array nums such that the first k elements of nums contain the
   * elements which are not equal to val. The remaining elements of nums are not important as well
   * as the size of nums.
   * 
   * @param numbers integer array
   * @param valueToRemove element to remove from the array
   * @return size after removing the target element
   */
  public static int removeElement(final int[] numbers, final int valueToRemove) {
    final var filtered = new ArrayList<Integer>();
    for (var number : numbers) {
      if (valueToRemove != number) {
        filtered.add(number);
      }
    }
    filtered.sort((first, second) -> first - second);
    Arrays.fill(numbers, 0);
    for (var index = 0; index < filtered.size(); ++index) {
      numbers[index] = filtered.get(index);
    }
    return filtered.size();
  }
}
