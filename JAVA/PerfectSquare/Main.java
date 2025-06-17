package PerfectSquare;

import java.util.Scanner;

class Main {
 
  static boolean checkPerfectSquare(double x) {
 
 double sq = Math.sqrt(x);
 /* Math.floor() returns closest integer value, for
* example Math.floor of 984.1 is 984, so if the value
* of sq is non integer than the below expression would
* be non-zero.
*/
 return ((sq - Math.floor(sq)) == 0);
  }
 
  public static void main(String[] args) {
 
   Scanner scanner = new Scanner(System.in);
    String prompt;
    do{
      System.out.print("Enter any number: ");
   double num = scanner.nextDouble();
   //scanner.close();
 
   if (checkPerfectSquare(num)) {
   System.out.print(num+ " is a perfect square number");
      }
   else {
   System.out.print(num+ " is not a perfect square number ");
      }  
     
      System.out.println(" Would you like to continue?(yes/no)");
      prompt = scanner.next();
     
    } while (prompt.equalsIgnoreCase("yes"));
  }
}