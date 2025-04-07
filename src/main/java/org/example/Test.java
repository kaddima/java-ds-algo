package org.example;

public class Test<T, U> {
  T first;
  U second;

  public Test(T arg1, U arg2){
    first = arg1;
    second = arg2;
  }

  public T getFirst() {
    return first;
  }

  public U getSecond() {
    return second;
  }

  public static <K> void reverse(K[] data){
    int low = 0, high = data.length - 1;
    while(low < high){
      K temp = data[low];
      data[low++] = data[high];
      data[high--] = temp;
    }
  }
}
