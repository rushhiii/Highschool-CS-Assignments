package Exercise2;

import java.util.*;

class Main {
  public static void main(String[] args) {
    int V = 0;
    while (V < 5) {
      int num, ten, one;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a two digit number: ");
      num = input.nextInt();

      ten = num / 10;
      one = num % 10;

      System.out.println("Tens place is " + ten);
      System.out.println("Ones place is " + one);
      V++;
    }

  }

}