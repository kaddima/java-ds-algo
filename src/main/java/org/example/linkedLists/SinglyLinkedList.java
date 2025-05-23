package org.example.linkedLists;

public class SinglyLinkedList<T> {

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

  public void addBefore(T data, T query) {
    Node newNode = new Node<>(data, null);

    if (!isEmpty()) {
      if (head.getData().equals(query)) {
        newNode.setNext(head);
        head = newNode;
        size++;
        return;
      }
      Node prev = head;
      Node currentNode = head.getNext();

      while (currentNode != null) {
        if (currentNode.getData().equals(query)) {
          newNode.setNext(currentNode);
          prev.setNext(newNode);
          size++;
          return;
        }
        prev = currentNode;
        currentNode = currentNode.getNext();
      }
    }

  }

  public void addAfter(T data, T query) {
    Node newNode = new Node<>(data, null);

    if (!isEmpty()) {
      Node currentNode = head;

      while (currentNode != null) {
        if (currentNode.getData().equals(query)) {
          newNode.setNext(currentNode.getNext());
          currentNode.setNext(newNode);
          size++;
          return;
        }
        currentNode = currentNode.getNext();
      }
    }
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
      sb.append("[" + currentHead.getData() + "]->");
      if (currentHead.getNext() == null) {
        sb.append("null");
        break;
      }
      currentHead = currentHead.getNext();
    }
    return sb.toString();
  }

  public static void main(String[] args) {
    SinglyLinkedList<Integer> linkedList = new SinglyLinkedList<>();
    linkedList.addFirst(5);
    linkedList.addFirst(6);
    linkedList.addBefore(9, 6);
    linkedList.addFirst(86);
    linkedList.addAfter(43, 9);
    linkedList.addAfter(7, 5);
    System.out.println(linkedList);
  }
}
