package org.example.linkedLists;

public class DoublyLinkList<T> {

  private static class Node<T> {
    private T data;
    private Node<T> prev;
    private Node<T> next;

    public Node(T data, Node<T> prev, Node<T> next) {
      this.data = data;
      this.prev = prev;
      this.next = next;
    }

    public T getData() {
      return data;
    }

    public Node<T> getNext() {
      return next;
    }

    public Node<T> getPrev() {
      return prev;
    }

    public void setPrev(Node<T> prev) {
      this.prev = prev;
    }

    public void setNext(Node<T> next) {
      this.next = next;
    }
  }

  private Node<T> header;
  private Node<T> trailer;
  private int size = 0;

  public DoublyLinkList() {
    header = new Node<>(null, null, null);
    trailer = new Node<>(null, header, null);
    header.setNext(trailer);
  }

  public int getSize() {
    return size;
  }

  public boolean isEmpty() {
    return getSize() == 0;
  }

  public T getFirst(){
    if(isEmpty()) return null;
    return header.getNext().getData();
  }

  public T getLast(){
    if(isEmpty()) return null;
    return trailer.getPrev().getData();
  }

  public void addFirst(T data){
    addBetween(data, header, header.getNext());
  }

  public void addLast(T data){
    addBetween(data, trailer.getPrev(), trailer);
  }

  private void addBetween(T data, Node<T> predecessor, Node<T> successor){
    Node<T> newNode = new Node<>(data,predecessor, successor);
    predecessor.setNext(newNode);
    successor.setPrev(newNode);
    size++;
  }

  private T remove(Node<T> node){
    Node<T> predecessor = node.getPrev();
    Node<T> successor = node.getNext();
    predecessor.setNext(successor);
    successor.setPrev(predecessor);
    size--;
    return node.getData();
  }
}
