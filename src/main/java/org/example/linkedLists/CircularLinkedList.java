package org.example.linkedLists;

public class CircularLinkedList<T> {
  private Node<T> tail = null;
  private int size = 0;

  public int getSize() {
    return size;
  }
  public boolean isEmpty(){return size == 0;}
  public T first(){
    if(isEmpty()) return null;
    return tail.getNext().getData();
  }

  public T last(){
    if(isEmpty()) return null;
    return tail.getData();
  }
}
