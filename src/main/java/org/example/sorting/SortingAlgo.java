package org.example.sorting;

import java.util.Arrays;

public class SortingAlgo {
  public static <T extends Comparable<T>> void bubbleSort(T[] data){
    int dataLength = data.length;
    int bound = dataLength - 1;

    for (int i=0; i < dataLength; i++) {
      boolean swapped = false;
      int newBound = 0;
      /**
       * in the iteration the highest value is placed to the right or end
       * of the array. in the second loop, the seconf highest value will be second to
       * the end of the array..., the ith cell has already stored the sorted items,
       * there is no need to visit that index and do a comparison
       * */
      for (int j = 0; j < bound; j++) {
        //check if the currentData at index j is greater than the next data
        if (data[j].compareTo(data[j + 1]) > 0) {
          T temp = data[j + 1];
          data[j + 1] = data[j];
          data[j] = temp;
          swapped = true;
          newBound = j;
        }
      }
      bound = newBound;
      //if no swap occurs that means the array has been sorted
      if(!swapped) break;
    }
  }

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

  /**
   * in selection sort, the min/max element in the array is placed in the first
   * index if we are sorting in descending order and find the second most min or max
   * and place in the second place and so on
   */
  public static <T extends Comparable<T>> void selectionSort(T[] data){
    int dataLength = data.length;
    for (int i = 0; i < dataLength; i++){
      int minIndex = i;
      /**
       * start the inner loop from the current + 1 so we dont compare value of same index
       *
       */
      for (int j = minIndex + 1; j < dataLength; j++){
        // if j < the current minIndex replace the assign the value of j to minIndex
        if(data[j].compareTo(data[minIndex]) < 0){
          minIndex = j;
        }
      }
      /**
       * if the minIndex is was changed from its starting index then swap
       */
      if(minIndex != i){
        T temp = data[i];
        data[i] = data[minIndex];
        data[minIndex] = temp;
      }
    }
  }

  private static <T> void printData(T[] data) {
    System.out.println(Arrays.toString(data));
  }

  public static void main(String[] args) {
    Integer[] data = {20, 45, 93, 67, 10, 97, 52, 88, 33, 92};
    SortingAlgo.selectionSort(data);
    printData(data);
  }
}
