package bst;

public class BinarySearchTree {

  private BSTNode root;

  public BinarySearchTree() {
    root = null;
  }

  public boolean search(int key) {
    return search(root, key);
  }

  private boolean search(BSTNode root, int key) {
    if (root == null || root.value == key) {
      return root != null;
    }

    if (key < root.value) {
      return search(root.left, key);
    } else {
      return search(root.right, key);
    }
  }

  public void insert(int key) {
    root = insert(root, key);
  }

  private BSTNode insert(BSTNode root, int key) {
    if (root == null) {
      root = new BSTNode(key);
      return root;
    }

    if (key < root.value) {
      root.left = insert(root.left, key);
    } else if (key > root.value) {
      root.right = insert(root.right, key);
    }

    return root;
  }

  public void delete(int key) {
    root = delete(root, key);
  }

  private BSTNode delete(BSTNode root, int key) {
    if (root == null) {
      return root;
    }

    if (key < root.value) {
      root.left = delete(root.left, key);
    } else if (key > root.value) {
      root.right = delete(root.right, key);
    } else {
      // Case 1 :  Node with no child
      if (root.left == null && root.right == null) {
        return null;
      }

      // Case 2 : Node with only one child
      else if (root.left == null) {
        return root.right;
      } else if (root.right == null) {
        return root.left;
      }

      // Case 3 : Node with two children
      else {
        root.value = minValue(root.right);
        root.right = delete(root.right, root.value);
      }
    }

    return root;
  }

  private int minValue(BSTNode root) {
    int minValue = root.value;

    while (root.left != null) {
      minValue = root.left.value;
      root = root.left;
    }
    return minValue;
  }

  public int maxValue() {
    BSTNode current = root;
    while (current.right != null)
      current = current.right;

    return current.value;
  }

  private void inorderTraversal(BSTNode root) {
    if (root != null) {
      inorderTraversal(root.left);
      System.out.print(root.value + " ");
      inorderTraversal(root.right);
    }
  }

  public void inorderTraversal() {
    inorderTraversal(root);
    System.out.println();
  }
}
