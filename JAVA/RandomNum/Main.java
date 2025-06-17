package RandomNum;

import java.util.Scanner;

class Main {
  public static void main(String args[]) {

    for (int i = 0; i < 2; i++) {
      int min, max;
      Scanner input = new Scanner(System.in);

      System.out.println("Enter minimunm value: ");
      min = input.nextInt();
      System.out.println("Enter maximimum value: ");
      max = input.nextInt();

      System.out.println("Random value from " + min + " to " + max + ":");
      int random_int = (int) Math.floor(Math.random() * (max - min + 1) + min);
      System.out.println(random_int);
    }
  }
}