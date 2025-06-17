package PrintABoxOfNums;

import java.util.*;

class Main {
  
  public static void main(String[] args) {
    
  int WC=0;
  int HC=0;
    Scanner input = new Scanner(System.in);
    System.out.println("width:");
     int UserW= input.nextInt();
    System.out.println("height:");
     int UserH= input.nextInt();
    do{
      System.out.print("#");
      WC+=1;
      while (WC==UserW){
        System.out.print("\n");
        HC+=1;
        WC=0;
      }
     
    }while (HC<UserH);
    System.out.print("\n");
  }
}