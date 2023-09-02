package leet.code.practice.set;

import java.util.HashMap;

public class MajorityElement {

  public static void main(String[] args) {
    System.out.println(majorityElement(new int[] {2, 2, 1, 1, 1, 2, 2}));

  }

  /**
   * he majority element is the element that appears more than n / 2 You may assume that the
   * majority element always exists in the array.
   * 
   * @param numbers integer array
   * @return majority element
   */
  public static int majorityElement(final int[] numbers) {
    if (numbers.length == 1) {
      return numbers[0];
    }
    final var frequencies = new HashMap<Integer, Integer>();
    var maxItem = 0;
    var maxOccurence = 0;
    for (var number : numbers) {
      if (frequencies.containsKey(number)) {
        frequencies.put(number, frequencies.get(number) + 1);
        final Integer frequency = frequencies.get(number);
        if (frequency > maxOccurence) {
          maxOccurence = frequency;
          maxItem = number;
        }
      } else {
        frequencies.put(number, 1);
      }
    }
    return maxItem;
  }

}
