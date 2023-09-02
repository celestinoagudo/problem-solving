package leet.code.practice.set;

import java.util.ArrayList;
import java.util.Arrays;

public class MergeSortedArray {
  public static void main(String[] args) {
    merge(new int[] {-1, 0, 0, 3, 3, 3, 0, 0, 0}, 6, new int[] {1, 2, 2}, 3);
  }

  /**
   * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two
   * integers m and n, representing the number of elements in nums1 and nums2 respectively. Merge
   * nums1 and nums2 into a single array sorted in non-decreasing order. The final sorted array
   * should not be returned by the function, but instead be stored inside the array nums1. To
   * accommodate this, nums1 has a length of m + n, where the first m elements denote the elements
   * that should be merged, and the last n elements are set to 0 and should be ignored. nums2 has a
   * length of n.
   * 
   * @param first integer array
   * @param firstElementsTotal first integer array number of elements
   * @param second integer array
   * @param secondElementsTotal second integer array number of elements
   */
  public static void merge(final int[] first, final int firstElementsTotal, final int[] second,
      final int secondElementsTotal) {
    final var merged = new ArrayList<Integer>();
    for (var element : Arrays.copyOfRange(first, 0, firstElementsTotal)) {
      merged.add(element);
    }
    for (var element : Arrays.copyOfRange(second, 0, secondElementsTotal)) {
      merged.add(element);
    }
    merged.sort((a, b) -> a - b);
    for (var index = 0; index < merged.size(); ++index) {
      first[index] = merged.get(index);
    }
  }
}
