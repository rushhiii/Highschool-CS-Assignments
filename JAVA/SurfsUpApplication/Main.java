package SurfsUpApplication;

import java.util.*;

class Main {
  public static void main(String[] args) {

    
    Scanner input = new Scanner(System.in);

    System.out.println("What's the wave height today? ");
    int wave_height = input.nextInt();
   
    System.out.println("Wave height for today is " + wave_height + " feet");

    //waves are 6 or more then that 
    if (wave_height >= 6) {
      System.out.println("It's a great day for surfing!");
    }

    //waves are in between 3 to 6
    else if (wave_height > 3 & wave_height < 6) {
      System.out.println("Go body boarding!");
    }

    //waves are 3 or less then 3
    else if (wave_height <= 3 | wave_height == 0) {
      System.out.println("Go for a swim.");
    } 

    else {
      System.out.println("Whoa! What kind of surf is that?");
    }
    
  }
}