package Exercise3;

import java.util.*;

public class Main {

  public static void main(String[] Strings) {
    int V = 1;
    while (V == 1)
    {

      Scanner input = new Scanner(System.in);

      System.out.print("Input a degree in Fahrenheit: ");
      double fahrenheit = input.nextDouble();

      if (fahrenheit > 300d) {
        break;
      }
      
      double celsius = ((5 * (fahrenheit - 32.0)) / 9.0);
      System.out.println(fahrenheit + " degree Fahrenheit is equal to " + celsius + " in Celsius");
    }
  }
}