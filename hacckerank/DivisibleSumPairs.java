package week.one;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Celestino Agudo
 *
 */
public class DivisibleSumPairs {

  public static void main(String[] args) {
    List<Integer> ar = new ArrayList<Integer>();
    ar.add(1);
    ar.add(3);
    ar.add(2);
    ar.add(6);
    ar.add(1);
    ar.add(2);
    int k = 3;
    List<Integer> subList = new ArrayList<Integer>();
    int numberOfPairs = 0;
    for (int counter = 0; counter < ar.size(); ++counter) {
      for (int counter2 = counter + 1; counter2 < ar.size(); ++counter2) {
        subList.add(ar.get(counter));
        subList.add(ar.get(counter2));
        Integer sum = subList.stream().reduce((a, b) -> a + b).get();
        if ((sum % k) == 0) {
          ++numberOfPairs;
          System.out.println(subList);
        }
        subList.clear();
      }
    }
    System.out.println(numberOfPairs);
  }
}
