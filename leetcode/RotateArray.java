package leet.code.practice.set;

import java.util.Arrays;

public class RotateArray {
  public static void main(String[] args) {
    System.out
        .println("Rotated: " + Arrays.toString(rotateArray(new int[] {1, 2, 3, 4, 5, 6, 7}, 3)));
  }

  /**
   * Problem: Rotate an array of n elements to the right by k steps. For example, with n = 7 and k =
   * 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4]
   * 
   * @param input array to be rotated
   * @param steps number of rotations
   * @return rotated array
   */
  private static int[] rotateArray(int[] input, int steps) {
    final int inputLength = input.length;
    int[] rotated = new int[inputLength];
    for (var index = 0; index < inputLength; ++index) {
      var position = 0;
      if ((index + steps) >= inputLength) {
        position = (index + steps) - inputLength;
      } else {
        position = (index + steps);
      }
      rotated[position] = input[index];
    }
    return rotated;
  }
}
