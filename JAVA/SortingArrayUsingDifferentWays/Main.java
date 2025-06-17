package SortingArrayUsingDifferentWays;

import java.util.*;
import java.util.Random;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in); // scanner of input
    char choice; // holds yes or no
    Random rd = new Random(); // creating Random nums
    int n;
      do {
      System.out.print("\n\nEnetr the number of elements you want to store: ");
      n = input.nextInt();
      int[] array = new int[n];

      for (int i = 0; i < n; i++) {
        array[i] = rd.nextInt(500);
      }

      int first = array[0];
      int last = array[array.length - 1];

      System.out.print("\n\nThis is the Array: ");
      printArray(array, n);

      System.out.print("\n");
      printer("Selection Sort", 80);
      selectionSort(array, n);
      printer("-", 80);

      System.out.print("\n");
      printer("Isertion Sort", 80);
      insertionSort(array, n);
      printer("-", 80);

      System.out.print("\n");
      printer("Bubble Sort", 80);
      bubbleSort(array, n);
      printer("-", 80);

      System.out.print("\n");
      printer("Quick Sort", 80);
      // Start timer
      long startTime = System.nanoTime();
      quickSort(array, first, last, n);
      // End timer
      long endTime = System.nanoTime();
      long timeDiff = (endTime - startTime);
      double duration = (timeDiff / 1000000.0);
      // System.out.println("\nThe sorted array useing quick sort:");
      // printArray(array, n);
      System.out.print("\n\nDuration of Quick sort (milliseconds): ");
      System.out.printf("%.2fms", duration);
      System.out.print("\n");
      printer("-", 80);

      System.out.print("\n");
      printer("Merge Sort", 80);
      // Start timer
      long startTime1 = System.nanoTime();
      mergeSort(array, 0, array.length - 1);
      // End timer
      long endTime1 = System.nanoTime();
      long timeDiff1 = (endTime1 - startTime1);
      double duration1 = (timeDiff1 / 1000000.0);
      // System.out.println("\nThe sorted array useing Merge sort:");
      // printArray(array, n);
      System.out.print("\n\nDuration of Merge sort (milliseconds): ");
      System.out.printf("%.2fms", duration1);
      System.out.print("\n");
      printer("-", 80);

      System.out.print("\nWould you like to continue?\nEnter Y for yes or N for no: ");
      choice = input.next().charAt(0);
      printer("-", 80);
    } while ((choice == 'y') || (choice == 'Y'));
    printer("-", 80);
  }

  // CSS
  static void printer(String str, int size) {
    int left = (size - str.length()) / 2;
    int right = size - left - str.length();
    String repeatedChar = "-";
    StringBuffer buff = new StringBuffer();
    for (int i = 0; i < left; i++) {
      buff.append(repeatedChar);
    }
    buff.append(str);
    for (int i = 0; i < right; i++) {
      buff.append(repeatedChar);
    }
    System.out.println(buff.toString());
  }

  // prints array
  static void printArray(int[] array, int n) {
    System.out.print("[");
    for (int i = 0; i < n; i++) {
      if (i == n - 1) {
        System.out.print(array[i] + "");
      } else {
        System.out.print(array[i] + ", ");
      }
    }
    System.out.print("]\n");
  }

  // Selection Sort
  static void selectionSort(int[] intArray, int n) {
    // intArray.length - 1 because the array index starts from zero.
    // Start timer
    long startTime = System.nanoTime();

    for (int i = 0; i < intArray.length - 1; i++) {

      int index = i;
      for (int j = i + 1; j < intArray.length; j++) {
        if (intArray[j] < intArray[index]) {
          index = j; // find smallest
        }
      }

      int smallestNum = intArray[index];
      intArray[index] = intArray[i];
      intArray[i] = smallestNum;
    }

    // End timer
    long endTime = System.nanoTime();
    long timeDiff = (endTime - startTime);
    double duration = (timeDiff / 1000000.0);

    System.out.println("\nThe sorted array useing selection sort:");
    printArray(intArray, n);

    System.out.print("\n\nDuration of selection sort (milliseconds): ");
    System.out.printf("%.2fms", duration);
    System.out.print("\n");
  }

  // insertion Sort
  static void insertionSort(int[] intArray, int n) {

    // Start timer
    long startTime = System.nanoTime();

    for (int i = 1; i < intArray.length - 1; i++) {

      int index = intArray[i];
      int j = i - 1;
      while (j >= 0 && index <= intArray[j]) {

        intArray[j + 1] = intArray[j];
        j = j - 1;
      }
      intArray[j + 1] = index;
    }

    // End timer
    long endTime = System.nanoTime();
    long timeDiff = (endTime - startTime);
    double duration = (timeDiff / 1000000.0);

    // System.out.println("\nThe sorted array useing insertion sort:");
    // printArray(intArray, n);

    System.out.print("\n\nDuration of insertion sort (milliseconds): ");
    System.out.printf("%.2fms", duration);
    System.out.print("\n");
  }

  // Bubble Sort
  static void bubbleSort(int[] intArray, int n) {

    // Start timer
    long startTime = System.nanoTime();

    for (int i = 0; i < n; i++) {

      for (int j = 0; j < n - i - 1; j++) {
        if (intArray[j] > intArray[j + 1]) {
          // swap index and intArray[i]
          int index = intArray[j];
          intArray[j] = intArray[j + 1];
          intArray[j + 1] = index;
        }
      }
    }

    // End timer
    long endTime = System.nanoTime();
    long timeDiff = (endTime - startTime);
    double duration = (timeDiff / 1000000.0);

    // System.out.println("\nThe sorted array useing bubble sort:");
    // printArray(intArray, n);

    System.out.print("\n\nDuration of Bubble sort (milliseconds): ");
    System.out.printf("%.2fms", duration);
    System.out.print("\n");
  }

  static void quickSort(int intArray[], int begin, int end, int n) {

    if (begin < end) {
      int partitionIndex = partition(intArray, begin, end);
      quickSort(intArray, begin, partitionIndex - 1, n);
      quickSort(intArray, partitionIndex + 1, end, n);
    }
  }

  static int partition(int arr[], int begin, int end) {
    int pivot = arr[end];
    int i = (begin - 1);

    for (int j = begin; j < end; j++) {
      if (arr[j] <= pivot) {
        i++;

        int indexSwap = arr[i];
        arr[i] = arr[j];
        arr[j] = indexSwap;
      }
    }

    int indexSwap = arr[i + 1];
    arr[i + 1] = arr[end];
    arr[end] = indexSwap;

    return i + 1;
  }

  // Merge sort
  // Merges two subarrays of arr[].
  // First subarray is arr[l..m]
  // Second subarray is arr[m+1..r]
  static void merge(int arr[], int l, int m, int r) {
    // Find sizes of two subarrays to be merged
    int n1 = m - l + 1;
    int n2 = r - m;

    int L[] = new int[n1];
    int R[] = new int[n2];

    for (int i = 0; i < n1; ++i)
      L[i] = arr[l + i];
    for (int j = 0; j < n2; ++j)
      R[j] = arr[m + 1 + j];

    // Initial indexes of first and second subarrays
    int i = 0, j = 0;

    // Initial index of merged subarray array
    int k = l;
    while (i < n1 && j < n2) {
      if (L[i] <= R[j]) {
        arr[k] = L[i];
        i++;
      } else {
        arr[k] = R[j];
        j++;
      }
      k++;
    }

    while (i < n1) {
      arr[k] = L[i];
      i++;
      k++;
    }

    while (j < n2) {
      arr[k] = R[j];
      j++;
      k++;
    }
  }

  static void mergeSort(int arr[], int l, int r) {
    if (l < r) {
      // Find the middle point
      int m = (l + r) / 2;

      // Sort first and second halves
      mergeSort(arr, l, m);
      mergeSort(arr, m + 1, r);

      // Merge the sorted halves
      merge(arr, l, m, r);
    }
  }
}

// 172.30.48.106
// 172.30.48.102
// 172.30.48.116
// 172.30.48.110
// 172.30.48.111
// 172.30.48.104
// 172.30.48.105
// 172.30.48.118
// 172.30.48.116
// 172.30.48.115
// 172.30.48.113
// 172.30.48.114
// 172.30.48.112
// 172.30.48.127
// 172.30.48.123
// 172.30.48.122
// 172.30.48.124
// 172.30.48.125
// 172.30.48.126
// 172.30.48.119
// 172.30.48.120
// 172.30.48.121
// 172.30.48.103
// 172.30.48.134
// 172.30.48.109
// 172.30.48.128
// 172.30.48.129
// 172.30.48.130
// 172.30.48.131
// 172.30.48.132
// 172.30.48.133