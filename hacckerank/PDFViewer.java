package week.three;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 * @author Celestino Agudo https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
 *
 */
public class PDFViewer {

  public static int designerPdfViewer(List<Integer> h, String word) {
    final Map<String, Integer> mappings = new HashMap<>();
    h.forEach(height -> {
      int counter = 0;
      for (char current = 'a'; (current <= 'z') && (counter < h.size()); ++current, ++counter) {
        mappings.put(String.valueOf(current), h.get(counter));
      }
    });
    List<Integer> heights = new ArrayList<>();
    for (char chr : word.toCharArray()) {
      heights.add(mappings.get(String.valueOf(chr)));
    }
    Collections.sort(heights, (a, b) -> b - a);
    return heights.get(0) * word.length();
  }

  public static void main(String[] args) {
    List<Integer> h = new ArrayList<>();
    h.add(1);
    h.add(3);
    h.add(1);
    h.add(3);
    h.add(1);
    h.add(4);
    h.add(1);
    h.add(3);
    h.add(2);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    h.add(5);
    System.out.println(designerPdfViewer(h, "abc"));
  }

}
