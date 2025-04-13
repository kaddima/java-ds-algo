package org.example.linkedLists;

public class SinglyLinkedList<T> {
  private static class Node<T> {
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

  private Node<T> head = null;
  private Node<T> tail = null;
  private int size = 0;

  public SinglyLinkedList() {
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return size == 0;
  }

  public T getFirst() {
    if (isEmpty()) return null;
    return head.getData();
  }

  public T getLast() {
    if (isEmpty()) return null;
    return tail.getData();
  }

  public void addFirst(T data) {
    head = new Node<>(data, this.head);
    if (size == 0) {
      tail = head;
    }
    size++;
  }

  public void addLast(T data) {
    Node<T> newest = new Node<>(data, null);
    if (isEmpty()) {
      head = newest;
    } else {
      tail.setNext(newest);
    }
    tail = newest;
    size++;
  }

  public T removeFirst() {
    if (isEmpty()) return null;
    T data = this.head.getData();
    head = this.head.getNext();
    size--;
    if (size == 0) {
      tail = null;
    }
    return data;
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Node<T> currentHead = this.head;
    while (currentHead.getData() != null) {
      sb.append(currentHead.getData());
      if (currentHead.getNext() == null) {
        break;
      }
      currentHead = currentHead.getNext();
      sb.append(", ");

    }
    return sb.toString();
  }

  public static void main(String[] args) {
    SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
    linkedList.addFirst(5);
    linkedList.addFirst(6);
    System.out.println(linkedList);
  }
}
