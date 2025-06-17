package ProgramControlFunction;

import java.util.Scanner;

public class Main {

  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);

    System.out.println(" ");
    System.out.println("---Input Three numbers---");
    System.out.println(" ");
    System.out.println("Enter First number: ");
    int num1 = input.nextInt();

    System.out.println("Enter Second number: ");
    int num2 = input.nextInt();

    System.out.println("Enter Third number: ");
    int num3 = input.nextInt();

    System.out.println(" ");
    System.out.println("The Smallest number is " + smallComp(num1, num2, num3) + ".");
    System.out.println(" ");
    Main Obj = new Main();
    Obj.Average(num1, num2, num3);
    // Obj.MiddleNum(num1, num2, num3);
    System.out.println(" ");
    System.out.print("The Middle number is " + middleNum(num1, num2, num3) + ".");
    System.out.println(" ");
    System.out.println(" ");    
    System.out.println("The Largest number is " + Largest(num1,num2,num3) + ".");
  }

  static int smallComp(int n1, int n2, int n3) {
    int smallNum = 0;
    if ((n1 < n2) && (n1 < n3)) {
      smallNum = n1;
    } else if ((n2 < n1) && (n2 < n3)) {
      smallNum = n2;
    } else if ((n3 < n1) && (n3 < n2)) {
      smallNum = n3;
    }
    return smallNum;
  }

  void Average(int num1, int num2, int num3) {
    int average = (num1 + num2 + num3) / 3;
    System.out.println("The Average of three numbers is " + average + ".");
  }

  /**
   * void MiddleNum(int num1, int num2, int num3){
   * if(num2>num1 && num1>num3 || num3>num1 && num1>num2){
   * System.out.print("The middle number is " + num1);
   * }
   * if(num1>num2 && num2>num3 || num3>num2 && num2>num1){
   * System.out.print(The middle number is " + num1);
   * }
   * if(num1>num3 && num3>num2 || num2>num3 && num3>num1){
   * System.out.print(num3+" is a middle number");
   * }
   * }
   */

  static int middleNum(int num1, int num2, int num3) {
    int middle;
    if (num1 > num2) {
      if (num2 > num3) {
        middle = num2;
      } else if (num3 > num1) {
        middle = num1;
      } else {
        middle = num3;
      }
    } else {
      if (num2 < num3) {
        middle = num2;
      } else if (num3 < num1) {
        middle = num1;
      } else {
        middle = num3;
      }
    }
    return middle;
  }

  static int Largest(int x, int y, int z){
    
    if (x >= y && x >= z)
      return x;
      
    else if (y >= x && y >= z)
      return y;
    
    else
      return z;
  }
}