package org.example.sorting;

import java.util.Arrays;

public class SortingAlgo {
  public static <T extends Comparable<T>> void insertionSort(T[] data) {
    int dataLength = data.length;
    //start from the second element in the array
    int startIndex = 1;
    for (int i = startIndex; i < dataLength; i++) {
      T currentData = data[i];

      //set a pointer left of the current index (i-1)
      int prevIndex = i - 1;
      while (prevIndex >= 0 && data[prevIndex].compareTo(currentData) > 0) {
        data[prevIndex + 1] = data[prevIndex];
        prevIndex--;
      }

      //place the currentData in its correct position
      data[prevIndex + 1] = currentData;
    }
  }

  private static <T> void printData(T[] data) {
    int a = 0;
    System.out.print("[");

    for (T d : data) {
      System.out.print(d);
      System.out.print(", ");
    }
    System.out.print("]");
    System.out.println();
  }

  public static void main(String[] args) {
    Integer[] data = {20, 45, 93, 67, 10, 97, 52, 88, 33, 92};
    SortingAlgo.insertionSort(data);
    System.out.println(Arrays.toString(data));
  }
}
