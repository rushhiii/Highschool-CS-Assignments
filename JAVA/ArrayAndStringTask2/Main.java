package ArrayAndStringTask2;

import java.util.Arrays;
import java.util.Scanner;
import java.util.*;

class Main {
  public static void main(String[] args) {
    System.out.print("\n");
    // 1
    System.out.print("-----------------------------------------------------------------");
    System.out.print("\n");
    System.out.print("\n");
    System.out.println("#1. Compare two strings lexicographically, ignoring case differences");
    CompareStringsIgnoringCaseDifferences();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 2
    System.out.print("\n");
    System.out.print("\n");
    System.out.println("#2. String object with the contents of a character array");
    StringObjectContentsOfCharacterArray();
    System.out.print("\n");
    System.out.print("-----------------------------------------------------------------");
    // 3
    System.out.print("\n");
    System.out.print("\n");
    System.out.println("#3. Check whether a given string ends with the contents of another string");
    CheckGivenStrEndsContentsOfAnotherStr();
    System.out.print("\n");
    System.out.println("-----------------------------------------------------------------");
    // 4
    System.out.print("\n");
    System.out.println("#4. Check whether two String objects contain the same data");
    CheckStringSameData();
    System.out.print("\n");
    System.out.println("-----------------------------------------------------------------");
    // 5
    System.out.print("\n");
    System.out.println("#5. The index of all the characters of the alphabet, using myStr.indexOf(myChr, 0)");
    getIndexOfCharacters();
    System.out.print("\n");
    System.out.println("-----------------------------------------------------------------");
    // 6
    System.out.print("\n");
    System.out.println(
        "#6. The last index of a character within a string, using myStr.lastIndexOf(myChr, str.length() - 1);");
    getLastIndexOfCharacters();
    System.out.print("\n");
    System.out.println("-----------------------------------------------------------------");
    // 7
    System.out.print("\n");
    System.out.println("#7. Find the second most frequent character in a given string");
    getSecondMostFreq();
    System.out.print("\n");
    System.out.println("-----------------------------------------------------------------");
    // 8
    System.out.print("\n");
    System.out.println("#8. Reverse every word in a string using methods");
    System.out.print("\n");
    String str = "htriT letaP";
    System.out.println("This is a string: \"" + str + "\"");
    System.out.println("This is a reverse string: \"" + reverseWord(str) + "\"");
    System.out.print("\n");
    System.out.println("-----------------------------------------------------------------");

  }

  // 1. Compare two strings lexicographically, ignoring case differences
  public static void CompareStringsIgnoringCaseDifferences() {

    String str1 = "KaKar";
    String str2 = "KAKAR";

    System.out.print("\n");

    if (str1.compareToIgnoreCase(str2) == 0) {
      System.out.println(str1 + " is equal to " + str2);
    } else {
      System.out.println(str1 + " is not equale to " + str2);
    }
  }

  // 2. String object with the contents of a character array
  public static void StringObjectContentsOfCharacterArray() {

    System.out.println("\n");
    char[] numArray = new char[] { '1', '2', '3', '4' };
    String str = String.copyValueOf(numArray, 1, 2);
    System.out.print("The array contains \"" + str + "\" numbers.");
    System.out.println("\n");
  }

  // 3. Check whether a given string ends with the contents of another string
  public static void CheckGivenStrEndsContentsOfAnotherStr() {
    System.out.print("\n");
    String str1 = "Java Exercises";
    String str2 = "Java Exercise";
    String endStr = "se";

    boolean ends1 = str1.endsWith(endStr);
    boolean ends2 = str2.endsWith(endStr);

    System.out.println("Does \"" + str1 + "\" ends with " + "\"" + endStr + "\"? " + ends1);
    System.out.println("Does \"" + str2 + "\" ends with " + "\"" + endStr + "\"? " + ends2);
  }

  // 4. Check whether two String objects contain the same data
  public static void CheckStringSameData() {
    System.out.print("\n");
    String data1 = "Stephen Edwin King";
    String data4 = "Stephen Edwin King";
    String data2 = "Walter Winchell";
    String data3 = "Mike Royko";

    boolean dataEquals1 = data1.equals(data4);
    boolean dataEquals2 = data1.equals(data3);

    System.out.println("Is \"" + data1 + "\"" + " equals to " + "\"" + data4 + "\"? " + dataEquals1);
    System.out.println("Is \"" + data1 + "\"" + " equals to " + "\"" + data3 + "\"? " + dataEquals2);
  }

  // 5. get the index of all the characters of the alphabet, using
  // myStr.indexOf(myChr, 0)
  public static void getIndexOfCharacters() {
    System.out.println("\n");
    String str = "The quick brown fox jumps over the lazy dog";

    int a = str.indexOf("a", 0);
    int b = str.indexOf("b", 0);
    int c = str.indexOf("c", 0);
    int d = str.indexOf("d", 0);
    int e = str.indexOf("e", 0);
    int f = str.indexOf("f", 0);
    int g = str.indexOf("g", 0);
    int h = str.indexOf("h", 0);
    int i = str.indexOf("i", 0);
    int j = str.indexOf("j", 0);
    int k = str.indexOf("k", 0);
    int l = str.indexOf("l", 0);
    int m = str.indexOf("m", 0);
    int n = str.indexOf("n", 0);
    int o = str.indexOf("o", 0);
    int p = str.indexOf("p", 0);
    int q = str.indexOf("q", 0);
    int r = str.indexOf("r", 0);
    int s = str.indexOf("s", 0);
    int T = str.indexOf("T", 0);
    int t = str.indexOf("t", 0);
    int u = str.indexOf("u", 0);
    int v = str.indexOf("v", 0);
    int w = str.indexOf("w", 0);
    int x = str.indexOf("x", 0);
    int y = str.indexOf("y", 0);
    int z = str.indexOf("z", 0);

    System.out.println("This is a string: \"" + str + "\"");
    System.out.print("\n");
    System.out.println("T  h  e    " + "q  u  i  c  k    " + "b  r  o  w  n    " + "f  o  x    " + "j  u  m  p  s    ");
    System.out.println("-------    " + "-------------    " + "-------------    " + "-------    " + "-------------    ");
    System.out.println(T + "  " + h + "  " + e + "    " + q + "  " + u + "  " + i + "  " + c + "  " + k + "    " + b
        + " " + r + " " + o + " " + w + " " + n + "   " + f + " " + o + " " + x + "   " + j + " " + u + "  " + m + " "
        + p + " " + m);
    System.out.print("\n");
    System.out.println("o  v  e  r    " + "t  h  e    " + "l  a  z  y    " + "d  o  g");
    System.out.println("----------    " + "-------    " + "----------    " + "-------");
    System.out.println(o + " " + v + " " + e + "  " + r + "   " + t + " " + h + "  " + e + "    " + l + " " + a + " "
        + z + " " + y + "   " + d + " " + o + " " + g);

    /*
     * System.out.println( "The index of character \"a\": " + a );
     * System.out.println( "The index of character \"b\": " + b );
     * System.out.println( "The index of character \"c\": " + c );
     * System.out.println( "The index of character \"d\": " + d );
     * System.out.println( "The index of character \"e\": " + e );
     * System.out.println( "The index of character \"f\": " + f );
     * System.out.println( "The index of character \"g\": " + g );
     * System.out.println( "The index of character \"h\": " + h );
     * System.out.println( "The index of character \"i\": " + i );
     * System.out.println( "The index of character \"j\": " + j );
     * System.out.println( "The index of character \"k\": " + k );
     * System.out.println( "The index of character \"l\": " + l );
     * System.out.println( "The index of character \"m\": " + m );
     * System.out.println( "The index of character \"n\": " + n );
     * System.out.println( "The index of character \"o\": " + o );
     * System.out.println( "The index of character \"p\": " + p );
     * System.out.println( "The index of character \"q\": " + q );
     * System.out.println( "The index of character \"r\": " + r );
     * System.out.println( "The index of character \"s\": " + s );
     * System.out.println( "The index of character \"t\": " + t );
     * System.out.println( "The index of character \"u\": " + u );
     * System.out.println( "The index of character \"v\": " + v );
     * System.out.println( "The index of character \"w\": " + w );
     * System.out.println( "The index of character \"x\": " + x );
     * System.out.println( "The index of character \"y\": " + y );
     * System.out.println( "The index of character \"z\": " + z );
     */
  }

  // 6. the last index of a character within a string, using
  // myStr.lastIndexOf(myChr, str.length() - 1);
  public static void getLastIndexOfCharacters() {
    System.out.print("\n");
    String str = "Hello planet earth, you are a great planet";
    System.out.println("This is a string: \"" + str + "\"");
    System.out.println("The last index of a character \"t\" is " + str.lastIndexOf("t", str.length() - 1) + ".");
  }

  // 7. find the second most frequent character in a given string
  public static void getSecondMostFreq() {
    System.out.print("\n");
    /*
     * String str = "abaababcdelkm";
     * char[] c = str.toCharArray();
     * int sz = c.length;
     * int j;
     * int k = sz-1;
     * for (int i = 0; i < sz; i++) {
     * int counter = 0;
     * for ( j = 0; j < sz; j++) {
     * if (j < i && c[i] == c[j]) {
     * break;
     * }
     * if (c[i] == c[j]) {
     * counter++;
     * }
     * if (j == k) {
     * System.out.println("The Character " + c[i] + " is present " + counter +
     * " times");
     * }
     * }
     * }
     */
    String str = "yogeshg";

    char[] chararray = new char[str.length()];
    int[] frequency = new int[str.length()];
    int min, max;
    char minchar = str.charAt(0), maxchar = str.charAt(0);

    chararray = str.toCharArray();

    int i, j;
    for (i = 0; i < str.length(); i++) {
      frequency[i] = 1;
      for (j = i + 1; j < str.length(); j++) {
        if (chararray[i] == chararray[j] && chararray[i] != ' ' && chararray[i] != '0') {
          frequency[i]++;
          chararray[j] = '0';
        }
      }
    }
    min = max = frequency[0];

    for (i = 0; i < frequency.length; i++) {
      if (min > frequency[i] && frequency[i] != '0') {
        min = frequency[i];
        minchar = chararray[i];
      }
      if (max < frequency[i]) {
        max = frequency[i];
        maxchar = chararray[i];
      }
    }
    System.out.println("Minimum reapted char = " + minchar);
    System.out.println("Maximum reapted char = " + maxchar);
  }

  // 8. reverse every word in a string using methods
  public static String reverseWord(String str) {
    String words[] = str.split("\\s");
    String reverseWord = "";
    for (String w : words) {
      StringBuilder sb = new StringBuilder(w);
      sb.reverse();
      reverseWord += sb.toString() + " ";
    }

    return reverseWord.trim();
  }
}