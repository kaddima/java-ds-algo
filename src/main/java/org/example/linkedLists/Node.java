package org.example.linkedLists;

public class Node<T> {
  private T data;
  private Node next;

  public Node(T d, Node<T> n) {
    data = d;
    next = n;
  }

  public T getData() {
    return data;
  }

  public Node<T> getNext() {
    return next;
  }

  public void setNext(Node<T> n) {
    next = n;
  }
}

