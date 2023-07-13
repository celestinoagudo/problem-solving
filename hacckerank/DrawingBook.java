package week.two;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Celestino Agudo
 * @see https://www.hackerrank.com/challenges/drawing-book/problem
 */

public class DrawingBook {

  public static void main(String[] args) {
    System.out.println(pageCount(5, 4));

  }

  public static int pageCount(int n, int p) {
    List<Integer> pages = new ArrayList<Integer>();
    for (int counter = 0; counter < (n + 1); ++counter) {
      pages.add(counter);
    }
    int maxPagesPerFlip = 2;
    int numBerOfFlipsFromStart = 0;
    int numBerOfFlipsFromEnd = 0;
    int current = 0;
    while (current < pages.size()) {
      if (pages.subList(current, current + maxPagesPerFlip).contains(p)) {
        numBerOfFlipsFromStart += 1;
        break;
      } else {
        numBerOfFlipsFromStart += 1;
      }
      current += maxPagesPerFlip;
    }
    current = pages.size() - maxPagesPerFlip;
    while (current < pages.size()) {
      if (pages.subList(current, current + maxPagesPerFlip).contains(p)) {
        numBerOfFlipsFromEnd += 1;
        break;
      } else {
        numBerOfFlipsFromEnd += 1;
      }
      current -= maxPagesPerFlip;
    }
    numBerOfFlipsFromStart -= 1;
    numBerOfFlipsFromEnd -= 1;
    return Math.min(numBerOfFlipsFromStart, numBerOfFlipsFromEnd);
  }
}
