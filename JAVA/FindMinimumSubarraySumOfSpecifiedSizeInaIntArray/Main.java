package FindMinimumSubarraySumOfSpecifiedSizeInaIntArray;

import java.util.Scanner;
import java.util.Arrays;

class Main {
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

  public static void main(String[] args) {
    System.out.println("\n");
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
    int [] result = minSubArraySum(intArray, a);
    System.out.printf("Sub-array from %d to %d and sum is: %d", result[0], result[1], result[2]);
    System.out.println();
  }
}