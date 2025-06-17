package GuessTheCorrectPin;

import java.util.Scanner;

class Main {
  
  public static void main(String[] args) {
  
    Scanner input = new Scanner(System.in);
    System.out.println("");
    System.out.println("Please Enter Pin:");
    int Pin = input.nextInt();
    int V = 1;
    
    while (V < 3 && Pin != 605021){
      System.out.println("");
      System.out.println("Incorrect Pin, Try again:");
      Pin = input.nextInt();
      V += 1;
    
      if (V == 3){
        System.out.println("");
        System.out.println("Sorry but you have been locked out");
      }
    }
    if (Pin == 605021){
      System.out.println("");
      System.out.println("Welcome back!");
    } 
}
}