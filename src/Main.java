import bst.BinarySearchTree;
import stack.Stack;


/*
    BST tree example

          45
       /     \
      10      90
     /  \    /
    7   12  50

*/

public class Main {

    public static void main(String[] args) {
        binarySearchTreeExample();
//        stackExample();

    }

    private static void stackExample() {
        Stack y = new Stack(2);
        y.push(5);
        y.display();

        y.push(7);
        y.display();

        System.out.println("Yığıtın en üstünde bulunan eleman : " + y.top());
        System.out.println("Yığıt dolu mu ? : " + y.isFull());

        y.push(8);
        y.display();

        y.push(2);
        y.display();

        y.push(4);
        y.display();

        y.push(10);
        y.display();

        final Object poppedElement = y.pop();
        System.out.println("Çıkarılan eleman: "+ poppedElement);
        y.display();

        System.out.println("Yığıtın en üstünde bulunan eleman : " + y.top());

        y.push((11));
        y.display();

        System.out.println("Yığıtın en üstünde bulunan eleman : " + y.top());
    }

    private static void binarySearchTreeExample() {
        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(45);
        tree.insert(10);
        tree.insert(7);
        tree.insert(12);
        tree.insert(90);
        tree.insert(50);

        System.out.println("\nBiggest element in the tree : " + tree.maxValue());

        System.out.println("\nBST (Left-root-right) :");
        tree.inorderTraversal();

        System.out.println("\nValue 12 with no children is deleted from the tree :");
        tree.delete(12);
        tree.inorderTraversal();

        System.out.println("\nThe value 90, which has only one child, is deleted from the tree: ");
        tree.delete(90);
        tree.inorderTraversal();

        System.out.println("\nThe value 45 with two children is deleted from the tree: ");
        tree.delete(45);
        tree.inorderTraversal();

        boolean search = tree.search(50);
        System.out.println("\nIs the value 50 present in the BST tree? : " + search);
        search = tree.search(12);
        System.out.println("\nDoes the value 12 exist in the BST tree? : " + search);



    }
}
