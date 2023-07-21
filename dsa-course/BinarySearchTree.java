package dsa.part.two;

import static java.util.Objects.isNull;
import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree {

  private Node root;

  public boolean areSibling(final int first, final int second) {
    if (isEmpty()) {
      return false;
    }
    return areSibling(root, first, second);
  }

  public boolean contains(int value) {
    if (isEmpty()) {
      return false;
    }
    return contains(root, value);
  }

  public int countLeaves() {
    if (isEmpty()) {
      return 0;
    }
    return countLeaves(root);
  }

  public boolean equals(final BinarySearchTree other) {
    if (isNull(other)) {
      return false;
    }
    return equals(root, other.root);
  }

  public boolean find(int value) {
    var current = root;
    while (!isNull(current)) {
      if (value < current.value) {
        current = current.leftChild;
      } else if (value > current.value) {
        current = current.rightChild;
      } else {
        return true;
      }
    }
    return false;
  }

  public int height() {
    if (isEmpty()) {
      return -1;
    }
    return height(root);
  }

  public void insert(int value) {
    final Node newNode = new Node(value);
    if (isEmpty()) {
      root = newNode;
      return;
    }
    var current = root;
    while (true) {
      if (value < current.value) {
        if (isNull(current.leftChild)) {
          current.leftChild = newNode;
          break;
        }
        current = current.leftChild;
      } else {
        if (isNull(current.rightChild)) {
          current.rightChild = newNode;
          break;
        }
        current = current.rightChild;
      }
    }
  }

  public boolean isBinarySearchTree() {
    return isBinarySearchTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
  }

  public int max() {
    if (isEmpty()) {
      throw new IllegalStateException("Tree is empty");
    }
    return max(root);
  }

  public int min() {
    if (isEmpty()) {
      throw new IllegalStateException("Tree is empty");
    }
    return min(root);
  }

  public void printAncestors(final int value) {
    if (isEmpty()) {
      return;
    }
    final var ancestors = new ArrayList<Integer>();
    collectAncestors(root, value, ancestors);
    System.out.println(ancestors);
  }

  public void printNodeAtDistance(final int distance) {
    final int height = height();
    if (distance > height) {
      throw new IllegalArgumentException(
          "K[%d] is greater than height[%d]".formatted(distance, height));
    }
    var nodesAtDistance = new ArrayList<Integer>();
    collectNodesAtDistance(root, distance, nodesAtDistance);
    System.out.println(nodesAtDistance);
  }

  public int size() {
    if (isEmpty()) {
      return 0;
    }
    var height = height();
    var nodesAtDistance = new ArrayList<Integer>();
    for (var level = 0; level <= height; ++level) {
      collectNodesAtDistance(root, level, nodesAtDistance);
    }
    return nodesAtDistance.size();
  }

  public void swapRoot() {
    var copy = root.leftChild;
    root.leftChild = root.rightChild;
    root.rightChild = copy;
  }

  @Override
  public String toString() {
    return "Tree=%s".formatted(root);
  }

  public void traverseInOrder() {
    traverseInOrder(root);
  }

  public void traverseLevelOrder() {
    var height = height();
    for (var level = 0; level <= height; ++level) {
      var nodesAtDistance = new ArrayList<Integer>();
      collectNodesAtDistance(root, level, nodesAtDistance);
      System.out.println(nodesAtDistance);
    }
  }

  public void traversePostOrder() {
    traversePostOrder(root);
  }

  public void traversePreOrder() {
    traversePreOrder(root);
  }

  private boolean areSibling(final Node node, final int first, final int second) {
    if (isLeaf(node)) {
      return false;
    }
    if (((first == node.leftChild.value) || (first == node.rightChild.value))
        && ((second == node.leftChild.value) || (second == node.rightChild.value))) {
      return true;
    }
    return areSibling(node.leftChild, first, second) || areSibling(node.rightChild, first, second);
  }

  private void collectAncestors(final Node node, final int value, List<Integer> ancestors) {
    if (!isNull(node)) {
      if (value > node.value) {
        ancestors.add(node.value);
        collectAncestors(node.rightChild, value, ancestors);
      } else if (value < node.value) {
        ancestors.add(node.value);
        collectAncestors(node.leftChild, value, ancestors);
      }
    }
  }

  private void collectNodesAtDistance(final Node node, final int distance,
      final List<Integer> nodesAtDistance) {
    if (distance == 0) {
      nodesAtDistance.add(node.value);
      return;
    }
    collectNodesAtDistance(node.leftChild, distance - 1, nodesAtDistance);
    collectNodesAtDistance(node.rightChild, distance - 1, nodesAtDistance);
  }

  private boolean contains(final Node node, final int value) {
    if (!isNull(node)) {
      if (value > node.value) {
        return contains(node.rightChild, value);
      } else if (value < node.value) {
        return contains(node.leftChild, value);
      } else {
        return true;
      }
    }
    return false;
  }

  private int countLeaves(Node node) {
    var count = 0;
    if (isLeaf(node)) {
      return ++count;
    }
    return countLeaves(node.leftChild) + countLeaves(node.rightChild);
  }

  private boolean equals(final Node from, final Node to) {
    if (isNull(from) && isNull(to)) {
      return true;
    }
    if (!isNull(from) && !isNull(to)) {
      return (from.value == to.value) && equals(from.leftChild, to.leftChild)
          && equals(from.rightChild, to.rightChild);
    }
    return false;
  }

  private int height(final Node node) {
    if (isLeaf(node)) {
      return 0;
    }
    return 1 + Math.max(height(node.leftChild), height(node.rightChild));
  }

  private boolean isBinarySearchTree(final Node node, int minimum, int maximum) {
    if (isEmpty()) {
      return true;
    }
    if ((minimum > node.value) || (node.value > maximum)) {
      return false;
    }

    if (isLeaf(node.leftChild) && isLeaf(node.rightChild)) {
      return (minimum <= node.value) && (node.value <= maximum);
    }
    return isBinarySearchTree(node.leftChild, minimum, node.value - 1)
        && isBinarySearchTree(node.rightChild, node.value + 1, maximum);
  }

  private boolean isEmpty() {
    return isNull(root);
  }

  private boolean isLeaf(final Node node) {
    return isNull(node.leftChild) && isNull(node.rightChild);
  }

  private int max(final Node node) {
    if (isLeaf(node)) {
      return node.value;
    }
    return max(node.rightChild);
  }

  private int min(final Node node) {
    if (isLeaf(node)) {
      return node.value;
    }
    var left = min(node.leftChild);
    var right = min(node.rightChild);
    return Math.min(node.value, Math.min(left, right));
  }

  private void traverseInOrder(final Node node) {
    if (isNull(node)) {
      return;
    }
    traverseInOrder(node.leftChild);
    System.out.println(node.value);
    traverseInOrder(node.rightChild);
  }

  private void traversePostOrder(final Node node) {
    if (isNull(node)) {
      return;
    }
    traversePostOrder(node.leftChild);
    traversePostOrder(node.rightChild);
    System.out.println(node.value);
  }

  private void traversePreOrder(final Node node) {
    if (isNull(node)) {
      return;
    }
    System.out.println(node.value);
    traversePreOrder(node.leftChild);
    traversePreOrder(node.rightChild);
  }

  private class Node {
    private Node leftChild;
    private Node rightChild;
    private int value;

    Node(final int value) {
      this.value = value;
    }

    @Override
    public String toString() {
      return "Node[value=%d, leftChild=%s, rightChild=%s]".formatted(value, leftChild, rightChild);
    }
  }
}
