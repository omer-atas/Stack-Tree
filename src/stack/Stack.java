package stack;

import java.util.Arrays;

public class Stack {

  private Object[] dizi;
  private int ust;
  private int DEFAULT_INITIAL_CAPACITY = 2;

  public Stack(int size) {
    this.DEFAULT_INITIAL_CAPACITY = size;
    this.dizi = new Object[DEFAULT_INITIAL_CAPACITY];
    this.ust = 0;
  }

  public void push(Object e) {
    ensureCapacity();
    dizi[this.ust++] = e;
  }

  public Object pop() {
    if (!isEmpty()) {
      final Object poppedElement = dizi[this.ust-1];
      ust--;
      dizi = Arrays.copyOf(dizi, this.ust);
      return poppedElement;
    } else {
      System.out.println("Yığıt boş.");
      return -1;
    }
  }

  public void display() {

    if (isEmpty()) {
      System.out.println("Yığıt boş.");
    } else {
      System.out.println("Yığın içeriği:");
      for (int i = 0; i < ust; i++) {
        System.out.print(dizi[i] + " ");
      }
      System.out.println();
    }
  }

  private void ensureCapacity() {
    if (dizi.length == ust) dizi = Arrays.copyOf(dizi, 2 * ust + 1);
  }

  public Object top() {
    if (!isEmpty()) {
      return dizi[ust-1];
    } else {
      return -1;
    }
  }

  boolean isEmpty() {
    if (ust == -1) {
      return true;
    } else {
      return false;
    }
  }

  public boolean isFull() {
    if (ust == this.dizi.length ) {
      return true;
    } else {
      return false;
    }
  }
}
