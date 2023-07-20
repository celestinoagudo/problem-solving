package dsa.part.one;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;

public class QueueExercises {
  public static void main(String[] args) {
    Queue<Integer> integers = new ArrayDeque<>();
    integers.add(10);
    integers.add(20);
    integers.add(30);
    integers.add(40);
    integers.add(50);
    System.out.println("Before reversing: " + integers);
    reverseQueue(integers);
    System.out.println("After reversing: " + integers);
    reverseFirstKElements(integers, 3);
    System.out.println("After reversing first %d elements: ".formatted(3) + integers);
  }

  public static void reverseFirstKElements(final Queue<Integer> integers, final int k) {
    Deque<Integer> elements = new ArrayDeque<>();
    Queue<Integer> reversed = new ArrayDeque<>();
    for (var a = 0; a < k; ++a) {
      elements.push(integers.remove());
    }
    while (!elements.isEmpty()) {
      reversed.add(elements.pop());
    }
    while (!integers.isEmpty()) {
      reversed.add(integers.remove());
    }
    while (!reversed.isEmpty()) {
      integers.add(reversed.remove());
    }
  }

  public static void reverseQueue(final Queue<Integer> integers) {
    Deque<Integer> elements = new ArrayDeque<>();
    while (!integers.isEmpty()) {
      elements.push(integers.remove());
    }
    while (!elements.isEmpty()) {
      integers.add(elements.pop());
    }
  }
}
