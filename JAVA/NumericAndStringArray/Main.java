package NumericAndStringArray;

import java.util.Arrays;

public class Main {
  public static void main(String[] args) {

    int[] intArray;
    String[] strArray;
    
     intArray = new int[] { 1789, 2035, 1899, 1456, 2013, 1458, 2458, 1254, 1472, 2365, 1456, 2165, 1457, 2456 };

     strArray = new String[] {"Java", "Python", "PHP", "C#", "C Programming", "C++"};
    
    System.out.println("\nOriginal numeric array : " + Arrays.toString(intArray));
    Arrays.sort(intArray);
    System.out.println("\nSorted numeric array : " + Arrays.toString(intArray));

    System.out.println("\nOriginal string array : " + Arrays.toString(strArray));
    Arrays.sort(strArray);
    System.out.println("\nSorted string array : " + Arrays.toString(strArray));
  }
}