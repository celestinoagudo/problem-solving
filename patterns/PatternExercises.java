package dsa.pattern;

public class PatternExercises {

  public static void main(String[] args) {
    var n = 15;
    rightTriangleStar(n);
    pyramid(n);
    diamond(n);
    downwardTriangle(n);
    mirroredRightTriangleStar(n);
    reversePyramid(n);
    rightDownMirrorStarPattern(n);
    rightPascalTriangle(n);
    leftTrianglePascal(n);
  }

  private static void diamond(int n) {
    System.out.println("Diamond\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 0; b < (n - a); ++b) {
        System.out.print(" ");
      }
      for (var c = 1; c <= a; ++c) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (var a = n - 1; a >= 0; --a) {
      for (var b = 0; b < (n - a); ++b) {
        System.out.print(" ");
      }
      for (var c = 1; c <= a; ++c) {
        System.out.print("* ");
      }
      System.out.println();
    }
  }

  private static void downwardTriangle(int n) {
    System.out.println("Downward Triangle\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 0; b <= (n - a); ++b) {
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void leftTrianglePascal(int n) {
    System.out.println("Left Triangle Pascal\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 1; b <= (n - a); ++b) {
        System.out.print("  ");
      }
      for (var c = 0; c < a; ++c) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (var a = 1; a <= (n - 1); ++a) {
      for (var b = 0; b < a; ++b) {
        System.out.print("  ");
      }
      for (var b = 0; b <= ((n - 1) - a); ++b) {
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void mirroredRightTriangleStar(int n) {
    System.out.println("Mirrored Right Triangle Star\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 1; b <= (n - a); ++b) {
        System.out.print("  ");
      }
      for (var c = 1; c <= a; ++c) {
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void pyramid(int n) {
    System.out.println("Pyramid\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 0; b < (n - a); ++b) {
        System.out.print(" ");
      }
      for (var c = 1; c <= a; ++c) {
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void reversePyramid(int n) {
    System.out.println("Reverse Pyramid\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 1; b <= (a - 1); ++b) {
        System.out.print(" ");
      }
      for (var c = 0; c <= (n - a); ++c) {
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void rightDownMirrorStarPattern(int n) {
    System.out.println("Right Down Mirror Star Pattern\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 1; b < a; ++b) {
        System.out.print("  ");
      }
      for (var c = 0; c <= (n - a); ++c) {
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void rightPascalTriangle(int n) {
    System.out.println("Right Pascal Triangle\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 0; b < a; ++b) {
        System.out.print("* ");
      }
      System.out.println();
    }
    for (var a = 1; a <= (n - 1); ++a) {
      for (var b = 0; b < (n - a); ++b) {
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }

  private static void rightTriangleStar(int n) {
    System.out.println("Right Triangle Star\n");
    for (var a = 1; a <= n; ++a) {
      for (var b = 1; b <= a; ++b) {
        System.out.print("* ");
      }
      System.out.println();
    }
    System.out.println();
  }
}
