package Exercise4;

import java.util.*;
import java.lang.Math;

public class Main {

  static Scanner sc = new Scanner(System.in);

  public static void main(String args[]) {
    int V = 1;
    while (V == 1) {

      System.out.print("Enter the radius: ");

      double radius = sc.nextDouble();

      double area = Math.PI * (radius * radius);
      System.out.println("The Rounded area of circle is: " + Math.round(area));

      double circumference = Math.PI * 2 * radius;
      System.out.println("The Rounded circumference of the circle is:" + Math.round(circumference));

      if (circumference > 500d) {
        break;
      }
    }
  }
}