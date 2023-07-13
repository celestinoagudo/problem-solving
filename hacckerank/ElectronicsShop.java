package week.two;

import java.util.Arrays;
import java.util.Collections;

/**
 * 
 * @author Celestino Agudo
 * @see https://www.hackerrank.com/challenges/electronics-shop/problem
 */
public class ElectronicsShop {

  public static void main(String[] args) {
    int keyboards[] = new int[] {4};
    int drives[] = new int[] {5};
    System.out.print(getMoneySpent(keyboards, drives, 5));
  }

  static int getMoneySpent(int[] keyboards, int[] drives, int b) {
    Integer[] keyboardsAsIntegerArr = new Integer[keyboards.length];
    Integer[] drivesAsIntegerArr = new Integer[drives.length];
    for (int counter = 0; counter < keyboards.length; ++counter) {
      keyboardsAsIntegerArr[counter] = keyboards[counter];
    }
    for (int counter = 0; counter < drives.length; ++counter) {
      drivesAsIntegerArr[counter] = drives[counter];
    }
    Arrays.sort(keyboardsAsIntegerArr, Collections.reverseOrder());
    Arrays.sort(drivesAsIntegerArr, Collections.reverseOrder());
    int max = -1;
    for (int counter = 0; counter < keyboardsAsIntegerArr.length; ++counter) {
      for (int counter2 = 0; counter2 < drivesAsIntegerArr.length; ++counter2) {
        int combination = keyboardsAsIntegerArr[counter] + drivesAsIntegerArr[counter2];
        if (combination == b) {
          max = combination;
          break;
        } else if ((combination > max) && (combination < b)) {
          max = combination;
          break;
        }
      }
    }
    return max;
  }
}
