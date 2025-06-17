package SnakeEyes;

//import java.util.Scanner;

class Main {

  public static void main(String[] args) {

    int dic1 = 0;
    int dic2 = 0;
    int V = 0;

    while ((dic1 != 1.0) || (dic2 != 1.0)) {
      dic1 = (int) Math.floor(Math.random()*(6-1)+  1);    
      dic2 = (int) Math.floor(Math.random()*(6-1 ) +1 ) ;  
      V += 1;
      System.out.println("dice 1: " + dic1 + ", dice 2: " + dic2);
      if (dic1 == 1 && dic2 == 1 ){
        System.out.println("\nit took "+  V +"  rolls for snakeyes");
      }
    }
  }
}