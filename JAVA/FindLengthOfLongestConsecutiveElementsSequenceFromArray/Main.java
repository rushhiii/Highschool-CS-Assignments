package FindLengthOfLongestConsecutiveElementsSequenceFromArray;

import java.util.Scanner;
import java.util.Arrays;

class Main {
  public static void main(String[] args) {

    System.out.println("\n");
    // int intArray[] = { 1, 2, 5, 6, 3, 2 };49, 1, 3, 200, 2, 4, 70, 5

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

    System.out.println("The longest consecutive elements sequence is: " + longestConsecutive(intArray));
    System.out.println();
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
}