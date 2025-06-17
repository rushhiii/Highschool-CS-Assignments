package SumOfFiveIntegers;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    int a,b,c,d,e;
    int total;
    Scanner input = new Scanner(System.in);

    System.out.println("Enter first integer: ");
    a = input.nextInt();
    
    int i = 0;
    while (i < 5) {
      System.out.println("What's the first number?");
        a = input.nextInt();
      System.out.println("What's the second number?");
        b = input.nextInt();
      System.out.println("What's the third number?");
        c = input.nextInt();
      System.out.println("What's the fourth number?");
        d = input.nextInt();
      System.out.println("What's the fifth number?");
        e = input.nextInt();
      total = a + b + c + d + e;
      System.out.println("Total: " + total);
      System.out.println("-------------------------");
      i++;
    }
  }
}

