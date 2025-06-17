package FindOddAndEvenIntegersInArray;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    System.out.println("\n"); 
    //int intArray[] = { 1, 2, 5, 6, 3, 2 };
    Scanner input = new Scanner(System.in);
    System.out.print("How many elements do you want in int array: ");
    int n = input.nextInt();
    System.out.println("Enter " + n + " elements:");
    int[] intArray = new int[n];
    for(int i = 0; i < n; i++) {
        intArray[i] = input.nextInt();   
    }

    System.out.print("\n");
    
    System.out.print("This is the Array: [");
    for(int i = 0; i < intArray.length; i++) {
        System.out.print(intArray[i] );
       if(i < intArray.length-1)
        System.out.print(", ");    
    }
    System.out.print("]");

    System.out.println("\n");
    
    System.out.print("Odd Numbers: ");
    for (int i = 0; i < intArray.length; i++) {
      if (intArray[i] % 2 != 0) {
        System.out.print(intArray[i]);
        if(i < intArray.length-2)
        System.out.print(", ");
      }
    }
    
    System.out.println();
    
    System.out.print("Even Numbers: ");
    for (int i = 0; i < intArray.length; i++) {
      if (intArray[i] % 2 == 0) {
        System.out.print(intArray[i]);
        if(i < intArray.length-1)
        System.out.print(", ");
      }
    }
    System.out.println();
  }
}