package week.two;

public class CountingValleys {

  public static int countingValleys(int steps, String path) {
    int seaLevel = 0;
    int currentLevel = seaLevel;
    int counter = 0;
    for (char direction : path.toCharArray()) {
      if (direction == 'D') {
        currentLevel -= 1;
        if (currentLevel == seaLevel) {
          counter += 1;
        }
      } else {
        currentLevel += 1;
        if (currentLevel == seaLevel) {
          counter += 1;
        }
      }
    }
    return counter - 1;
  }

  public static void main(String[] args) {
    String input = "UDDDUDUU";
    System.out.println(countingValleys(input.length(), input));
  }
}
