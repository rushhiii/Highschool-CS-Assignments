package FindSmallestAndSecondSmallestIntegerInArray;

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static int findSecondSmallest(int[] intArray) {

    // Integer.MAX_VALUE = 2147483647
    int smallest = Integer.MAX_VALUE; // -1
    int secondSmallest = Integer.MAX_VALUE; // -1

    for (int i = 0; i < intArray.length; i++) {
      if (intArray[i] < smallest) {
        smallest = intArray[i];
      }
      if (intArray[i] > smallest && intArray[i] < secondSmallest) {
        secondSmallest = intArray[i];
      }
    }
    return secondSmallest;
  }

  public static int findSmallest(int[] intArray) {

    // Integer.MAX_VALUE = 2147483647
    int smallest = Integer.MAX_VALUE;

    for (int i = 0; i < intArray.length; i++) {
      if (intArray[i] < smallest) {
        smallest = intArray[i];
      }
    }
    return smallest;
  }

  public static void main(String[] args) {
    System.out.println("\n");
    //int intArray[] = { 17, 20, 10, 14, 13, 58, 24, 12, 72, 23 };

    Scanner input = new Scanner(System.in);
    
      System.out.print("How many elements do you want in int array: ");
      int n = input.nextInt();
      System.out.println("Enter " + n + " elements:");
      int[] intArray = new int[n];
      for (int i = 0; i < n; i++) {
      intArray[i] = input.nextInt();
      }
     

    System.out.print("\n");

    System.out.print("This is the Array: " + Arrays.toString(intArray));

    System.out.println("\n");

    int result1 = findSmallest(intArray);
    System.out.printf("Smallest number in array is: %d", result1);
    
    System.out.print("\n");
    
    int result2 = findSecondSmallest(intArray);
    System.out.printf("Second smallest number in array is: %d", result2);
    System.out.println();
  }
}