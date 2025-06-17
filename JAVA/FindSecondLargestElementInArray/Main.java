package FindSecondLargestElementInArray;

import java.util.Scanner;

class Main {
  public static void main(String args[]) {

    System.out.println("\n");
    //int intArray[] = {12, 35, 1, 10, 34, 35, -1};
    Scanner input = new Scanner(System.in);
    System.out.print("How many elements do you want in int array: ");
    int a = input.nextInt();
    System.out.println("Enter " + a + " elements:");
    int intArray[] = new int[a];
    for(int i = 0; i < a; i++) {
      intArray[i] = input.nextInt();   
    }
    
    int n = intArray.length;

    int largest = Integer.MIN_VALUE;
    int secondLargest = Integer.MIN_VALUE;

    for(int i = 0; i < n; i++) {

      if(intArray[i] > largest) {
        secondLargest = largest;
        largest = intArray[i];
      }
      if(intArray[i] < largest && intArray[i] > secondLargest){
        secondLargest = intArray[i];
      }
    }

    System.out.println("\n");
    
    System.out.print("This is the Array: [");
    for(int i = 0; i < intArray.length; i++) {
        System.out.print(intArray[i] );
       if(i < intArray.length-1)
        System.out.print(", ");    
    }
    System.out.print("]");
    
    System.out.println("\n");
    System.out.println("Largest element in array is " + largest);
    System.out.println("Second Largest element in array is " + secondLargest);
  }
}