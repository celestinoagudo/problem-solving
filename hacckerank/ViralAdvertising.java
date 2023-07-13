package week.three;

import java.util.HashMap;
import java.util.Map;

/**
 * https://www.hackerrank.com/challenges/strange-advertising/problem
 * 
 * @author Celestino Agudo
 *
 */

public class ViralAdvertising {
  public static void main(String[] args) {
    System.out.println(viralAdvertising(5));

  }

  public static int viralAdvertising(int n) {
    int day = 1;
    int initialNumberOfPeopleShared = 5;
    Map<Integer, Integer> cumulative = new HashMap<>();
    int liked = 0;
    while (day <= n) {
      if (day == 1) {
        liked = Math.floorDiv(initialNumberOfPeopleShared, 2);
        cumulative.put(day, liked);
        ++day;
        continue;
      }
      initialNumberOfPeopleShared = liked * 3;
      liked = Math.floorDiv(initialNumberOfPeopleShared, 2);
      cumulative.put(day, liked);
      ++day;
    }
    return cumulative.values().stream().reduce(0, (a, b) -> a + b);
  }
}
