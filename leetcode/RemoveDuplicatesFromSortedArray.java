package leet.code.practice.set;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

public class RemoveDuplicatesFromSortedArray {

  public static void main(String[] args) {

    System.out.println(removeDuplicates(new int[] {0, 0, 1, 1, 1, 2, 2, 3, 3, 4}));

  }

  /**
   * Given an integer array nums sorted in non-decreasing order, remove the duplicates in-place such
   * that each unique element appears only once. The relative order of the elements should be kept
   * the same. Then return the number of unique elements in nums.
   * 
   * @param numbers integer array
   * @return size of the array after all duplicates are removed;
   */
  public static int removeDuplicates(int[] numbers) {
    var asList = new ArrayList<Integer>();
    for (var number : numbers) {
      asList.add(number);
    }
    asList = (ArrayList<Integer>) asList.stream().distinct().sorted().collect(Collectors.toList());
    Arrays.fill(numbers, 0);
    for (var index = 0; index < asList.size(); ++index) {
      numbers[index] = asList.get(index);
    }
    return asList.size();
  }

}
