package week.one;

import java.util.Arrays;

/**
 * 
 * @author Celestino Agudo
 *
 */
public class NegativeNumbersInGrid {

  public static void main(String[] args) {
    Integer[][] inputs =
        new Integer[][] {{4, 3, 2, -1}, {3, 2, 1, -1}, {1, 1, -1, -2}, {-1, -1, -2, -3}};
    int negativeNumberCount = 0;
    for (Integer[] input : inputs) {
      negativeNumberCount += Arrays.asList(input).stream().filter(a -> a < 0).count();
    }
    System.out.print(negativeNumberCount);
  }
}
