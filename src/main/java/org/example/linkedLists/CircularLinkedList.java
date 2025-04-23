package org.example.linkedLists;

public class CircularLinkedList<T> {
  private Node<T> tail = null;
  private int size = 0;

  public int getSize() {
    return size;
  }
  public boolean isEmpty(){return size == 0;}

  /**
   * this returns the first node which must come after the tail
   * or last node
   * @return
   */
  public T first(){
    if(isEmpty()) return null;
    return tail.getNext().getData();
  }

  public T last(){
    if(isEmpty()) return null;
    return tail.getData();
  }

  /**
   * rotates the list one node clockwise
   */
  public void rotate() {
    if (tail != null) {
      tail = tail.getNext();
    }
  }

  /**
   * Adds new node at the front of the circular linked list
   * @param data - the data to be store in the new node
   * @apiNote Time Complexity O(1)
   * @apiNote Space Complexity O(1)
   */
  public void addFirst(T data){
    if(isEmpty()){
      tail = new Node<>(data, null);
      tail.setNext(tail);
    }else{
      /**
       * this codes sets the next attribute of the new node to
       * reference the first node which is gotten ftom tail.next
       */
      Node<T> newNode = new Node<>(data,tail.getNext());
      /**
       * this will then set the first node by seting the next
       * attribute of the tail node to the newly created node
       */
      tail.setNext(newNode);
    }
    size++;
  }

  public void addlast(T data){
    addFirst(data);
    tail = tail.getNext();
  }

  public T removeFirst(){
    if(isEmpty()) return null;
    Node<T> firstNode = tail.getNext();
    if(firstNode == tail) tail = null;
    else tail.setNext(firstNode.getNext());
    size--;
    return firstNode.getData();
  }
}
