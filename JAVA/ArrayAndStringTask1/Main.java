package ArrayAndStringTask1;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    System.out.print("\n");
    // 1
    System.out.print("-----------------------------------------------------------------");
    System.out.print("\n");
    System.out.println("#1. Sort a numeric array and a string array");
    NumericAndStringArray();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 2
    System.out.print("\n");
    System.out.println("#2. Using array to print grid");
    ArrayToPrintTheGrid();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 3
    System.out.print("\n");
    System.out.println("#3. Find the index of an array element");
    FindIndexOfArrayElement();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 4
    System.out.print("\n");
    System.out.println("#4. The second largest element in an array");
    FindSecondLargestElementInArray();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 5
    System.out.print("\n");
    System.out.println("#5. The number of even and odd integers in a given array of integers");
    FindOddAndEvenIntegersInArray();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 6
    System.out.print("\n");
    System.out.println("#6. The longest consecutive elements sequence from array of integers");
    FindLongestConsecutiveSequence();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 7
    System.out.print("\n");
    System.out.println("#7. Minimum subarray sum of specified size in a given array of integers");
    FindMinimumSubarraySum();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 8
    System.out.print("\n");
    System.out.println("#8. Smallest and second smallest elements of a given array");
    FindSmallestAndSecondSmallestnumInArray();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
  }

  // 1. Sort a numeric array and a string array
  public static void NumericAndStringArray() {

    int[] intArray;
    String[] strArray;

    intArray = new int[] { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };

    strArray = new String[] { "Java", "Python", "PHP", "C#", "C Programming", "C++" };

    System.out.println("\nOriginal numeric array : " + Arrays.toString(intArray));
    Arrays.sort(intArray);
    System.out.println("\nSorted numeric array : " + Arrays.toString(intArray));

    System.out.println("\nOriginal string array : " + Arrays.toString(strArray));
    Arrays.sort(strArray);
    System.out.println("\nSorted string array : " + Arrays.toString(strArray));
  }

  // 2. Sort a numeric array and a string array
  public static void ArrayToPrintTheGrid() {
    String[] strArray;

    strArray = new String[] { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
        "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-",
        "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" };

    for (int i = 0; i < strArray.length; i++) {
      if (i % 10 == 0)
        System.out.println();
      System.out.print(strArray[i]);
    }
    System.out.print("\n");
  }

  // 3. Find the index of an array element
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

  public static void FindIndexOfArrayElement() {

    Scanner input = new Scanner(System.in);

    int[] intArray = { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365 };
    System.out.print("\n");
    System.out.println("Type the number from the given array:\n" + Arrays.toString(intArray));
    System.out.println("1899");
    int element = 1899;
    // int element = input.nextInt();
    int index = findIndex(intArray, element);

    System.out.println("\nThe index of element \"" + element + "\" is: " + index);
  }

  // 4. The second largest element in an array
  public static void FindSecondLargestElementInArray() {
    System.out.print("\n");
    int intArray[] = { 12, 35, 1, 10, 34, 35, -1 };
    /*
     * Scanner input = new Scanner(System.in);
     * System.out.print("How many elements do you want in int array: ");
     * int a = input.nextInt();
     * System.out.println("Enter " + a + " elements:");
     * int intArray[] = new int[a];
     * for(int i = 0; i < a; i++) {
     * intArray[i] = input.nextInt();
     * }
     */
    int n = intArray.length;
    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for (int i = 0; i < n; i++) {

      if (intArray[i] > largest) {
        secondLargest = largest;
        largest = intArray[i];
      }
      if (intArray[i] < largest && intArray[i] > secondLargest) {
        secondLargest = intArray[i];
      }
    }
    // System.out.println("\n");
    System.out.print("This is the Array: [");
    for (int i = 0; i < intArray.length; i++) {
      System.out.print(intArray[i]);
      if (i < intArray.length - 1)
        System.out.print(", ");
    }
    System.out.print("]");

    System.out.println("\n");
    System.out.println("Largest element in array is " + largest);
    System.out.println("Second Largest element in array is " + secondLargest);
  }

  // 5. The number of even and odd integers in a given array of integers
  public static void FindOddAndEvenIntegersInArray() {
    int intArray[] = { 1, 2, 5, 6, 3, 2 };
    /*
     * Scanner input = new Scanner(System.in);
     * System.out.print("How many elements do you want in int array: ");
     * int n = input.nextInt();
     * System.out.println("Enter " + n + " elements:");
     * int[] intArray = new int[n];
     * for(int i = 0; i < n; i++) {
     * intArray[i] = input.nextInt();
     * }
     */

    System.out.print("\n");
    System.out.print("This is the Array: [");
    for (int i = 0; i < intArray.length; i++) {
      System.out.print(intArray[i]);
      if (i < intArray.length - 1)
        System.out.print(", ");
    }
    System.out.print("]");

    System.out.println("\n");
    System.out.print("Odd Numbers: ");
    for (int i = 0; i < intArray.length; i++) {
      if (intArray[i] % 2 != 0) {
        System.out.print(intArray[i]);
        if (i < intArray.length - 2)
          System.out.print(", ");
      }
    }

    System.out.println();
    System.out.print("Even Numbers: ");
    for (int i = 0; i < intArray.length; i++) {
      if (intArray[i] % 2 == 0) {
        System.out.print(intArray[i]);
        if (i < intArray.length - 1)
          System.out.print(", ");
      }
    }
    System.out.println();
  }

  // 6. The longest consecutive elements sequence from array of integers
  public static void FindLongestConsecutiveSequence() {

    int intArray[] = { 49, 1, 3, 200, 2, 4, 70, 5 };
    /*
     * Scanner input = new Scanner(System.in);
     * System.out.print("How many elements do you want in int array: ");
     * int n = input.nextInt();
     * System.out.println("Enter " + n + " elements:");
     * int[] intArray = new int[n];
     * for (int i = 0; i < n; i++) {
     * intArray[i] = input.nextInt();
     * }
     */

    System.out.print("\n");
    System.out.print("This is the Array: " + Arrays.toString(intArray));
    System.out.println("\n");
    System.out.println("The longest consecutive elements sequence is: " + longestConsecutive(intArray));
  }

  public static int longestConsecutive(int[] array) {
    if (array.length == 0)
      return 0;

    int length = 1;
    int ans = 1;

    Arrays.sort(array);

    for (int i = 0; i < array.length - 1; i++) {
      if (array[i] == array[i + 1]) {
        continue;
      } else if (array[i] + 1 == array[i + 1]) {
        length++;
      } else {
        length = 1;
      }

      ans = Math.max(ans, length);
    }

    return ans;
  }

  // 7. Minimum subarray sum of specified size in a given array of integers
  public static void FindMinimumSubarraySum() {
    int intArray[] = { 17, 20, 18, 14, 13, 58, 24, 12, 72, 23 };

    Scanner input = new Scanner(System.in);

    System.out.print("\n");
    System.out.print("This is the Array: " + Arrays.toString(intArray));
    System.out.println("\n");

    Arrays.sort(intArray);
    System.out.print("This is sorted array: " + Arrays.toString(intArray));
    System.out.println("\n");

    System.out.print("Sub-array size: ");
    int a = input.nextInt();
    int[] result = minSubArraySum(intArray, a);
    System.out.printf("Sub-array from %d to %d and sum is: %d", result[0], result[1], result[2]);
    System.out.println();
  }

  public static int[] minSubArraySum(int[] nums, int k) {
    int sub_arr_sum = 0;
    int min_sub_arr = Integer.MAX_VALUE;
    int last = 0;
    int[] result = new int[3];

    Arrays.sort(nums);

    for (int i = 0; i < nums.length; i++) {
      sub_arr_sum += nums[i];
      if (i + 1 >= k) {
        if (min_sub_arr > sub_arr_sum) {
          min_sub_arr = sub_arr_sum;
          last = i;
        }
        sub_arr_sum -= nums[i + 1 - k];
      }
    }
    result[0] = last - k + 1;
    result[1] = last;
    result[2] = min_sub_arr;
    return result;
  }

  // 8. Smallest and second smallest elements of a given array
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

  public static void FindSmallestAndSecondSmallestnumInArray() {
    int intArray[] = { 17, 20, 10, 14, 13, 58, 24, 12, 72, 23 };

    /*
     * Scanner input = new Scanner(System.in);
     * System.out.print("How many elements do you want in int array: ");
     * int n = input.nextInt();
     * System.out.println("Enter " + n + " elements:");
     * int[] intArray = new int[n];
     * for (int i = 0; i < n; i++) {
     * intArray[i] = input.nextInt();
     * }
     */
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