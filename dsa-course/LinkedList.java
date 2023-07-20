package dsa.part.one;

import static java.util.Objects.isNull;
import java.util.NoSuchElementException;

public class LinkedList {
  private Node first;

  private Node last;
  private int size;

  public void addFirst(int item) {
    var node = new Node(item);
    if (isEmpty()) {
      first = last = node;
    } else {
      node.next = first;
      first = node;
    }

    size++;
  }

  public void addLast(int item) {
    var node = new Node(item);
    if (isEmpty()) {
      first = last = node;
    } else {
      last.next = node;
      last = node;
    }

    size++;
  }

  public boolean contains(int item) {
    return indexOf(item) != -1;
  }

  public int getKthFromTheEnd(int k) {
    if (isEmpty()) {
      throw new IllegalStateException("LinkedList is empty");
    }
    var distance = k - 1;
    var current = first;
    var next = first;
    while (distance > 0) {
      next = next.next;
      if (isNull(next)) {
        throw new IllegalArgumentException(
            "value of K [%d] exceeds the number of elements in the linked list".formatted(k));
      }
      --distance;
    }
    while (next != last) {
      current = current.next;
      next = next.next;
    }
    return current.value;
  }

  public boolean hasLoop() {
    var slow = first;
    var fast = first;
    while ((fast != null) && (fast.next != null)) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  public int indexOf(int item) {
    int index = 0;
    var current = first;
    while (current != null) {
      if (current.value == item) {
        return index;
      }
      current = current.next;
      index++;
    }
    return -1;
  }

  public void printMiddle() {
    if (isEmpty()) {
      throw new IllegalStateException();
    }
    var firstPointer = first;
    var secondPointer = first;
    while ((secondPointer.next != last) && (secondPointer.next.next != last)) {
      firstPointer = firstPointer.next;
      secondPointer = secondPointer.next.next;
    }
    if (secondPointer == last) {
      System.out.println(firstPointer.value);
    } else {
      System.out.println("%d,%d".formatted(firstPointer.value, firstPointer.next.value));
    }
  }

  public void removeFirst() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (first == last) {
      first = last = null;
    } else {
      var second = first.next;
      first.next = null;
      first = second;
    }

    size--;
  }

  public void removeLast() {
    if (isEmpty()) {
      throw new NoSuchElementException();
    }

    if (first == last) {
      first = last = null;
    } else {
      var previous = getPrevious(last);
      last = previous;
      last.next = null;
    }

    size--;
  }

  public void reverse() {
    if (isEmpty()) {
      return;
    }
    var previous = first;
    var current = previous.next;
    while (current != null) {
      var next = current.next;
      current.next = previous;
      previous = current;
      current = next;
    }
    last = first;
    last.next = null;
    first = previous;
  }

  public int size() {
    return size;
  }

  public int[] toArray() {
    int[] array = new int[size];
    var current = first;
    var index = 0;
    while (current != null) {
      array[index++] = current.value;
      current = current.next;
    }

    return array;
  }

  private Node getPrevious(Node node) {
    var current = first;
    while (current != null) {
      if (current.next == node) {
        return current;
      }
      current = current.next;
    }
    return null;
  }

  private boolean isEmpty() {
    return first == null;
  }

  private class Node {
    private Node next;
    private int value;

    public Node(int value) {
      this.value = value;
    }
  }
}
