package DistanceFormula;

import java.util.Scanner;

public class Main {

  public static void main(String args[]) {
    
    int x1, x2, y1, y2;
    double dis;
    Scanner Obj = new Scanner(System.in);

    System.out.println("Enter x1 point");
    x1 = Obj.nextInt();
    System.out.println("Enter y1 point");
    y1 = Obj.nextInt();
    System.out.println("Enter x2 point");
    x2 = Obj.nextInt();
    System.out.println("Enter y2 point");
    y2 = Obj.nextInt();
    dis = Main.distance(x1, y1, x2, y2);

    System.out.println("Distance between" + "(" + x1 + "," + y1 + ")," + "(" + x2 + "," + y2 + ") => " + dis);

  }

  static double distance(int x1, int y1, int x2, int y2) {
    return (Math.sqrt((x2 - x1) * (x2 - x1) + (y2 - y1) * (y2 - y1)));
  }
}