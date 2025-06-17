package ROT13Cipher;

import java.util.*;
import java.util.stream.IntStream;

class Main {
  
  static int[] Alphabet;

  static class MyIntStream {
    public IntStream stream;
    public MyIntStream() {
      stream = IntStream.range(0, 0);
    }
    public MyIntStream concat(IntStream s) {
      this.stream = IntStream.concat(this.stream, s);
      return this;
    }
    public MyIntStream concat(int[] s) {
      return this.concat(IntStream.of(s));
    }
  }
  
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    String text, encText, decText;
    char choice; // holds yes or no
      
    System.out.print("\n\n");
    
    
    Alphabet = new MyIntStream().concat(IntStream.range('a', 'z' + 1)).concat(IntStream.range('A', 'Z' + 1)).concat(new int[] {'1', '2', '3', '4', '5', '6', '7', '8', '9', '0'}).concat(new int[] {' ', '?', '!', '.', ':', '-', '_', '(', ')', '[', ']', '@', '$','*', '#'}).stream.toArray();


      printer("ROT13Cipher", 70);
       
    System.out.println("\nEnter the text that you want to encrypt:");
    text = input.nextLine();
  
    encText = encipher(text);
    System.out.println("\nEncipher text:");
    System.out.println(encText);

    decText = decipher(encText);
    System.out.println("\nDecipher text:");
    System.out.println(decText);
    printer("-", 70);

      
      
     for (int i = 0; i < 100; i++) {
       System.out.print("\nWould you like to continue? ");
       String ans = input.nextLine();
       if (ans.equalsIgnoreCase("yes") || ans.equalsIgnoreCase("y")) {
         
    printer("ROT13Cipher", 70);
       
    System.out.println("\nEnter the text that you want to encrypt:");
    text = input.nextLine();
  
    encText = encipher(text);
    System.out.println("\nEncipher text:");
    System.out.println(encText);

    decText = decipher(encText);
    System.out.println("\nDecipher text:");
    System.out.println(decText);
    printer("-", 70); 
       }
      else if (ans.equalsIgnoreCase("no") || ans.equalsIgnoreCase("n")) {
         break;
      }
      else if (!ans.equalsIgnoreCase("no") && !ans.equalsIgnoreCase("yes")){
         System.out.println("Invalid input!!");
      }  
    }
  }
  
  static int indexOf(int[] array, int value) {
    int result = -1;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == value) {
        result = i;
        break;
      }
    }
    return result;
  }
  
  static String encipher(String text) {
    
    String  result = "";
    
    for (int c : text.toCharArray()) {
      int idx = indexOf(Alphabet, c);
      int idxC = (idx + 13) % Alphabet.length;
      result += (char)Alphabet[idxC];
    }
    return result;
  }

  static String decipher(String encText) {
   String  result = "";
    
    for (int c : encText.toCharArray()) {
      int idx = indexOf(Alphabet, c);
      int idxC = (idx + (Alphabet.length - 13)) % Alphabet.length;
      result += (char)Alphabet[idxC];
    }
    return result;
  }

  // CSS
  static void printer(String str, int size) {
    int left = (size - str.length()) / 2;
    int right = size - left - str.length();
    String repeatedChar = "-";
    StringBuffer buff = new StringBuffer();
    for (int i = 0; i < left; i++) {
      buff.append(repeatedChar);
    }
    buff.append(str);
    for (int i = 0; i < right; i++) {
      buff.append(repeatedChar);
    }
    System.out.println(buff.toString());
  }
}
