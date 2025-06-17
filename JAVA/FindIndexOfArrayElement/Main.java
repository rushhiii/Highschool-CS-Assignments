package FindIndexOfArrayElement;

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static int findIndex(int arr[], int t) {

    // if array is Null
    if (arr == null) {
      return -1;
    }

    // find length of array
    int len = arr.length;
    int i = 0;

    // traverse in the array
    while (i < len) {

      // if the i-th element is t
      // then return the index
      if (arr[i] == t) {
        return i;
      } else {
        i = i + 1;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    System.out.println("\n");

    Scanner input = new Scanner(System.in);

    int[] intArray = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365 };
    System.out.println("Type the number from the given array:\n" + Arrays.toString(intArray));
    
    int element = input.nextInt();
    int index = findIndex(intArray, element);

    System.out.println("\nThe index of element \"" + element + "\" is: " + index);
  }
}