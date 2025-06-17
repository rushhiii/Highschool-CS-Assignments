package Conversions;

import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    int R = 1;
    Double pounds, kilograms, inches, feet, centimeters;
    Scanner input = new Scanner(System.in);

    do {
    System.out.println(" ");
    System.out.println("----Pounds to Kilogram converter----");
      System.out.println(" ");
    System.out.println("Enter a number in Pounds: ");
    pounds = input.nextDouble(); 
  
    kilograms = pounds * 0.454;
      R++;
    System.out.printf("%.1f" + " is " + "%.1f" + " Kilograms." , pounds, kilograms);
    System.out.println(" ");
      
    } while (R == 1); {  
      System.out.println(" ");
      System.out.println("----Inches to Centimeters converter----");
      System.out.println(" ");
      System.out.println("Enter a number in Inches: ");
      inches = input.nextDouble();
      Scanner obj = new Scanner(System.in);
      System.out.println("Enter a number in Feet: ");
      feet = obj.nextDouble();
      centimeters = ((feet*12) + inches) * 2.54;
      
      System.out.printf("%.1f" + " inches and " + "%.1f" + " feet is " + "%.2f" + " Centimeters." ,inches ,feet, centimeters);
    }
  }
}