package week.one;

import java.time.LocalDate;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 
 * @author Celestino Agudo
 *
 */
public class DayOfTheProgrammer {

  public static void main(String[] args) {
    int year = 1800;
    Map<Integer, Integer> monthsToDaysMapping = new LinkedHashMap<>();
    monthsToDaysMapping.put(1, 31);
    monthsToDaysMapping.put(2,
        ((year % 400) == 0) || (((year % 4) == 0) && ((year % 100) != 0)) ? 28 : 29);
    monthsToDaysMapping.put(3, 31);
    monthsToDaysMapping.put(4, 30);
    monthsToDaysMapping.put(5, 31);
    monthsToDaysMapping.put(6, 30);
    monthsToDaysMapping.put(7, 31);
    monthsToDaysMapping.put(8, 31);
    monthsToDaysMapping.put(9, 30);
    monthsToDaysMapping.put(10, 31);
    monthsToDaysMapping.put(11, 30);
    monthsToDaysMapping.put(12, 31);
    int twoFiftySixth = 256;
    int totalDays = 0;
    int month = 0;
    int day = 0;
    outer: for (Map.Entry<Integer, Integer> entry : monthsToDaysMapping.entrySet()) {
      totalDays += entry.getValue();
      if (totalDays == twoFiftySixth) {
        month = entry.getKey();
        day = entry.getValue();
      } else if (totalDays > twoFiftySixth) {
        totalDays -= entry.getValue();
        for (int counter = 0; counter < entry.getValue(); ++counter) {
          if (totalDays < twoFiftySixth) {
            ++totalDays;
          } else if (totalDays == twoFiftySixth) {
            month = entry.getKey();
            day = counter + 1;
            break outer;
          }
        }
      }
    }
    LocalDate localDate = LocalDate.of(year, month, day);
    System.out.println(localDate);
  }
}
