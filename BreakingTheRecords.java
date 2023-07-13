package week.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Celestino Agudo
 *
 */
public class BreakingTheRecords {

  public static void main(String[] args) {
    List<Integer> scores = new ArrayList<Integer>();
    scores.add(3);
    scores.add(4);
    scores.add(21);
    scores.add(36);
    scores.add(10);
    scores.add(28);
    scores.add(35);
    scores.add(5);
    scores.add(24);
    scores.add(42);
    int numberOfTimesMinRecordIsBroken = 0;
    int numberOfTimesMaxRecordIsBroken = 0;
    int min = scores.get(0);
    int max = scores.get(0);
    for (int score : scores) {
      if (score < min) {
        ++numberOfTimesMinRecordIsBroken;
        min = score;
      } else if (score > max) {
        ++numberOfTimesMaxRecordIsBroken;
        max = score;
      }
    }
    System.out.println(numberOfTimesMaxRecordIsBroken);
    System.out.println(numberOfTimesMinRecordIsBroken);
  }
}
