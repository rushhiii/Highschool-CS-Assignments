package Factorial;

import java.util.Scanner;

class Main {

  public static void main(String[] args) {
      
      int num;
      long factorial = 1;
      Scanner input = new Scanner(System.in);
      
      System.out.println("Enter a number:");
      num = input.nextInt();
    
    for(int i = 1; i <= num; ++i) {
      // factorial = factorial * i;
      factorial *= i;
    }
    System.out.printf("Factorial of %d = %d", num, factorial);
  }
}