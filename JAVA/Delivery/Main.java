package Delivery;
import java.util.*;
//import java.util.Random;

class Main {
 public static void main(String[] args) {

  int length,width,height;
  //Random num1 = new Random(10);
  //Random num2 = new Random(10);
  //Random num3 = new Random(10);
  
   
 Scanner input = new Scanner(System.in);
 
 System.out.println("Enter length");
 length = input.nextInt();
   
 System.out.println("Enter width");
 width = input.nextInt();
   
 System.out.println("Enter height");
 height = input.nextInt();
 input.close();
 
 if (length <= 10 && width <= 10 && height <= 10) {
 System.out.println("Accept");
    }
 else {
 System.out.println("Reject");
    }
 }
}