package week.one;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Celestino Agudo
 *
 */
public class MigratoryBirds {

  public static void main(String[] args) {
    List<Integer> arr = new ArrayList<>();
    arr.add(1);
    arr.add(2);
    arr.add(3);
    arr.add(4);
    arr.add(5);
    arr.add(4);
    arr.add(3);
    arr.add(2);
    arr.add(1);
    arr.add(3);
    arr.add(4);
    Collections.sort(arr, (a, b) -> a - b);
    final Map<Integer, Integer> typeAndItsOccurrence = new LinkedHashMap<>();
    arr.forEach(element -> {
      if (typeAndItsOccurrence.containsKey(element)) {
        typeAndItsOccurrence.put(element, typeAndItsOccurrence.get(element) + 1);
      } else {
        typeAndItsOccurrence.put(element, 1);
      }
    });
    int typeWithMostOccurrence = 0;
    int occurences = 0;
    for (Map.Entry<Integer, Integer> entry : typeAndItsOccurrence.entrySet()) {
      System.out.println(entry);
      Integer key = entry.getKey();
      Integer value = entry.getValue();
      if ((value > 1) && (value > occurences)) {
        occurences = value;
        typeWithMostOccurrence = key;
      }
    }
    System.out.println(typeWithMostOccurrence);
  }
}
