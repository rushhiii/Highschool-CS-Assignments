package ArrayToPrintTheGrid;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    String[] strArray;

    strArray = new String[] { "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-", "-" };

    for (int i = 0; i < strArray.length; i++) {
      if (i % 10 == 0)
        System.out.println();
      System.out.print(strArray[i]);
    }
    /*Scanner input = new Scanner(System.in); 
    System.out.print("\nHeight: ");
    int height = input.nextInt();
    System.out.print("Width: ");
    int width = input.nextInt();
    System.out.print("\n");

     int[][] strArray = new int[width][height];
   
    for (int h = 1; h <= width; h++) {
      //Inner loop - cols+
      for(int w = 1; w <= height; w++) {
        System.out.print(strArray[w][h]);
      }
      System.out.println();
    }*/
  }
}