package CalculateSumOfGeometricSequence;

import java.util.*;

class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char choice; // holds yes or no
    System.out.print("\n");
    printer("Wlecome to geometric and arithmetic sequence Sum claculator", 80);
    System.out.print("\n");
    do {
      System.out.print(
          "\nEnter 1 to calculate Sum of Geometric Sequence\nEnter 2 to calculate Sum of Arithmetic Sequence\n\nEnter: ");

      int num = input.nextInt();
      if (num == 1) {

        sumOfGeometricSequence();
      }
      if (num == 2) {

        sumOfArithmeticSequence();
      }
      System.out.print("Would you like to continue?\nEnter Y for yes or N for no: ");
      choice = input.next().charAt(0);
    } while ((choice == 'y') || (choice == 'Y'));
  }

  static void printer(String str, int size) {
    int left = (size - str.length()) / 2;
    int right = size - left - str.length();
    String repeatedChar = "-";
    StringBuffer buff = new StringBuffer();
    for (int i = 0; i < left; i++) {
      buff.append(repeatedChar);
    }
    buff.append(str);
    for (int i = 0; i < right; i++) {
      buff.append(repeatedChar);
    }
    System.out.println(buff.toString());
  }
  // static float sumOfGS(float a, float r, int n) {
  // float sum = 0;
  // for (int i = 0; i < n; i++) {
  // sum = sum + a;
  // a = a * r;
  // }
  // return sum;
  // }

  // public static void sumOfGeometricSequence(float a, float r, int n) {
  public static void sumOfGeometricSequence() {
    Scanner input = new Scanner(System.in);
     printer("-", 80);
    System.out.println("Geometric Sequence Sum calculator\n");
    System.out.print("Enter first term: ");
    float a = input.nextFloat();
    System.out.print("Enter common ration: ");
    float r = input.nextFloat();
    System.out.print("Sum of how many first terms you want to calculate? ");
    int n = input.nextInt();
    System.out.print("\n");
    float sum = 0;
    System.out.print("The First " + n + " terms of this Geometric Sequence are: ");
    for (int i = 0; i < n; i++) {
      sum = sum + a;
      if (i == n - 1) {
        
        System.out.printf("%.0f. ", a);
      } else {

        System.out.printf("%.0f, ", a);
      }
      a = a * r;
    }

    System.out.printf("\nThe sum of first %d terms of this Geometric Sequence is %.0f", n, sum);
    System.out.print("\n");
     printer("-", 80);
    System.out.print("\n");
  }

  public static void sumOfArithmeticSequence() {
    Scanner input = new Scanner(System.in);
    printer("-", 80);
    System.out.println("Arithmetic Sequence Sum calculator\n");
    System.out.print("Enter first term: ");
    float a = input.nextFloat();
    System.out.print("Enter common difference: ");
    float d = input.nextFloat();
    System.out.print("Sum of how many first terms you want to calculate? ");
    int n = input.nextInt();
    System.out.print("\n");
    float sum = 0;
    System.out.print("The First " + n + " terms of this Arithmetic Sequence are: ");
    for (int i = 0; i < n; i++) {
      sum = sum + a;
      if (i == n - 1) {

        System.out.printf("%.0f ", a);
      } else {

        System.out.printf("%.0f, ", a);
      }
      a = a + d;
    }

    System.out.printf("\nThe sum of first %d terms of this Arithmetic Sequence %.0f", n, sum);
    System.out.print("\n");
    printer("-", 80);
    System.out.print("\n");
  }
}