package SummationOfEveryNumFrom1;

import java.util.Scanner;

class Main {
  public static void main(String[] args) {

    Scanner input = new Scanner(System.in);
    System.out.println("Enter any natural number:");
    int Num = input.nextInt();
    int V = 0;
    int totalNum = 0;

    while (V < Num) {
      if (V < 1) {
        V += 1;
        System.out.print(V);
        totalNum += V;

      } else {
        V += 1;
        totalNum += V;
        System.out.print(" + " + V);
      }

    }
    System.out.println(" = " + totalNum);
  }
}