package week.two;

public class CatsAndMouse {

  public static void main(String[] args) {
    System.out.println(catAndMouse(2, 5, 4));

  }

  // Complete the catAndMouse function below.
  static String catAndMouse(int x, int y, int z) {
    int catAsDistanceFromTheMouse = 0;
    int catBsDistanceFromTheMouse = 0;
    catAsDistanceFromTheMouse = (x > z) ? x - z : z - x;
    catBsDistanceFromTheMouse = (y > z) ? y - z : z - y;
    if (catAsDistanceFromTheMouse == catBsDistanceFromTheMouse) {
      return "Mouse C";
    }
    return catAsDistanceFromTheMouse == catBsDistanceFromTheMouse ? "Mouse C"
        : catAsDistanceFromTheMouse < catBsDistanceFromTheMouse ? "Cat A" : "Cat B";
  }
}
