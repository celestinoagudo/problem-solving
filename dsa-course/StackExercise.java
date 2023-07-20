package dsa.part.one;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Set;

public class StackExercise {

  public static void main(String[] args) {
    System.out.println("Reversed : " + reverse("This is just a test"));
    System.out.println("Is Balanced : " + isExpressionBalanced("(([1] + <2>)) [a] test {<>}"));
  }

  private static boolean isExpressionBalanced(final String expression) {
    if ((expression == null) || expression.isEmpty()) {
      throw new IllegalStateException("Expression is empty");
    }
    final Set<Character> openingCharacters = Set.of('(', '[', '{', '<');
    final Set<Character> closingCharacters = Set.of(')', ']', '}', '>');
    final Deque<Character> delimiters = new ArrayDeque<>();
    for (final Character character : expression.toCharArray()) {
      if (openingCharacters.contains(character)) {
        delimiters.push(character);
      }
      if (closingCharacters.contains(character)) {
        if (delimiters.isEmpty()) {
          return false;
        }
        final Character popped = delimiters.pop();
        if (isNotMatching(character, popped)) {
          return false;
        }
      }
    }
    return delimiters.isEmpty();
  }

  private static boolean isNotMatching(final Character closing, final Character opening) {
    return (closing.equals(')') && !opening.equals('('))
        || ((closing.equals(']') && !opening.equals('['))
            || (closing.equals('}') && !opening.equals('{'))
            || (closing.equals('>') && !opening.equals('<')));
  }

  private static String reverse(final String text) {
    final var characters = new ArrayDeque<>();
    for (var character : text.toCharArray()) {
      characters.push(character);
    }
    var reversed = new StringBuilder();
    while (!characters.isEmpty()) {
      reversed.append(String.valueOf(characters.pop()));
    }
    return reversed.toString();
  }

}
