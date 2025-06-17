package LinearAndQuadraticEquationCalculator;

import java.util.*;

class Main {
  static String removeSpace(String s) {
    String temp = "";
    for (int i = 0; i < s.length(); i++){    
      String c = s.substring(i, i+1);              
      if (c.equals(" ")){
         
      }
      else {
        temp = temp + c;                
      }
    }
    return temp;   
  }

  static String replace(String input) {    
    String[] filteredWords = {"x"};
    StringBuilder asterisk = new StringBuilder();
    String inputInLower = input.toLowerCase();
    for (String filter: filteredWords) {
      if (inputInLower.contains(filter)) {
        for (int i = 0; i < filter.length(); i++) {asterisk.append("1x");}
          inputInLower = inputInLower.replace(filter, asterisk.toString());
          asterisk.setLength(0);
      }
    }
    return inputInLower;
  }

  static void runMyCode() {
    Scanner sc = new Scanner(System.in);
    
    System.out.print("Do you want to calculate linear equation or quadratic equation?\n\nEnter 1 to calculate linear equation\nEnter 2 to calculate quadratic equation");
    System.out.print("\nEnter your number: ");
    String num1 = sc.nextLine();
    int num = Integer.valueOf(num1);
    System.out.print("\n");

    if (num == 1) {
      String input, equation, equation1, equation2;
      System.out.print("Enter your linear equation: ");
      input = sc.nextLine();
      System.out.print("\n");
      equation1 = removeSpace(input);
      //equation2 = replace(equation1);
      //equation = equation2;
      equation = equation1;
      
      System.out.println(equation);
      
      solveEquation(equation);
    }
    
    else if (num == 2) {
      System.out.print("Enter your quadratic equation in \""+"aX + bx + c = 0"+"\"\n(NOTE: enter \"X\" instade of \"x square\"): ");
      String input = sc.nextLine();
      System.out.print("\n");
      String equation1 = removeSpace(input);
      String equation = equation1;
      
      solvequadraticEquation(replace(equation));
    }
    
    else {
      System.out.print("\nEnter a valid input: ");
    }
  }

  
  public static void main(String args[]) {
    System.out.println("\n");
    Scanner sc = new Scanner(System.in);
    
    printer("|Welcome to Tirth's Linear Equation Calculator|", 70);
    System.out.print("\n");

    runMyCode();
  
    while (true) {
      System.out.print("\n");
      System.out.print("Do you want to calculate again?(y/n) ");
      String choice = sc.next();
      if (choice.equals("n")) {
        break;
      }
      if (choice.equals("y")) {
        System.out.print("\n");
        printer("-", 70);
        runMyCode(); 
        printer("-", 70);
      } 
    }
  }
    
  

  static int gcd(int a, int b) {  
     if (a == 0)
      return b;

    return gcd(b % a, a);
  }
    
  static void solveEquation(String equation) {
    int n = equation.length(), sign = 1, coeff = 0;
	  int total = 0, i = 0;

    
	    // Traverse the equation
	  for (int j = 0; j < n; j++) {
		  if (equation.charAt(j) == '+' || equation.charAt(j) == '-') {
			  if (j > i) {
				  total += sign * Integer.parseInt(equation.substring(i, j));
			    i = j;
	      }
      }
  
		    // For cases such
		    // as: x, -x, +x
		  
		  else if (equation.charAt(j) == 'x') {
			  if ((i == j) || equation.charAt(j - 1) == '+') {
				  coeff += sign;
        }
			  else if (equation.charAt(j - 1) == '-') {
				  coeff -= sign;
        }
			  else {
				  coeff += sign * Integer.parseInt(equation.substring(i, j));
			    i = j + 1;
        }
		  }

		    // Flip sign once
		    // '=' is seen
		  else if (equation.charAt(j) == '=') {
        if (if equation.charAt(j) == isInteger('=')) {
          
        }
			  if (j > i) {
				  total += sign * Integer.parseInt(equation.substring(i, j));
			    sign = -1;
			    i = j + 1;
        }
		  }
	  }

	    // There may be a
	    // number left in the end
	  if (i < n) {
		  total = total + sign * Integer.parseInt(equation.substring(i));
    }
	    // For infinite
	    // solutions
	  if (coeff == 0 && total == 0) {
		  System.out.println("Infinite solutions");
    }
	    // For no solution
	  if (coeff == 0 && total != 0) {
		  System.out.println("No solution");
    }
    if (total == 0) {
		  System.out.println("x = 0\nInfinite solutions");
    }
	    // x = total sum / coeff
	    // of x '-' sign indicates
	    // moving numeric value to
	    // right hand side
    double Total = total;
    double Coeff = coeff;
	  double ans = -Total / Coeff;
    double ans1 = Math.round(ans * 100.0) / 100.0;
    int gcd1 = gcd(total,coeff);
    int gcd = checkGCD(gcd1);
      
      //Show final x value 
    if (coeff < 0 && total > 0) {
      if (ans1 == -1.0 || ans1 == 1.0){
        System.out.printf("\nx = %.0f\n", ans1);
      }
      else {
      int newcoeff = (coeff*(-1))/gcd;
      int newtotal = (total*(-1))/gcd;
      
    String ans2 = "x = " + Double.toString(ans1) +" or x = "+ Integer.toString(total)+"/"+Integer.toString(newcoeff);
      
    System.out.println(ans2);
      }
    }
    
    if (total < 0 && coeff > 0) {
      if (ans1 == -1.0 || ans1 == 1.0){
        System.out.printf("\nx = %.0f\n", ans1);
      }
      else {
      int newcoeff = coeff/gcd;
      int newtotal = (total*(-1))/gcd;
    String ans2 = "x = " + Double.toString(ans1) +" or x = "+ Integer.toString(newtotal)+"/"+Integer.toString(newcoeff);
      
    System.out.println(ans2);
      }
    }
    
    if (total > 0 && coeff > 0) {
      if (ans1 == -1.0 || ans1 == 1.0){
        System.out.printf("\nx = %.0f\n", ans1);
      }
      else {
        int newcoeff = coeff/gcd;
        int newtotal = (total*(-1))/gcd;
        String ans2 = "x = " + Double.toString(ans1) +" or x = "+ Integer.toString(newtotal)+"/"+Integer.toString(newcoeff);
      
        System.out.println(ans2);
      }
    }
    
    if (total < 0 && coeff < 0) {
      if (ans1 == -1.0 || ans1 == 1.0){
        System.out.printf("\nx = %.0f\n", ans1);
      }
      else {
      int newcoeff = coeff*(-1);
    String ans2 = "x = " + Double.toString(ans1) +" or x = "+ Integer.toString(total)+"/"+Integer.toString(newcoeff);
      
    System.out.println(ans2);
      }
    }
  
  }

  static void solvequadraticEquation(String equation) {
    double root1, root2, a, b, c;

    int n = equation.length(), sign = 1, coeff = 0, coeff2 = 0;
	  int total = 0, i = 0;

	    // Traverse the equation
	  for (int j = 0; j < n; j++) {
		  if (equation.charAt(j) == '+' || equation.charAt(j) == '-') {
			  if (j > i) {
				  total += sign * Integer.parseInt(equation.substring(i, j));
			    i = j;
	      }
      }
  
		    // For cases such
		    // as: x, -x, +x
		  else if (equation.charAt(j) == 'x') {
			  if ((i == j) || equation.charAt(j - 1) == '+') {
				  coeff += sign; // coeff = coeff + sign
        }
			  else if (equation.charAt(j - 1) == '-') {
				  coeff -= sign;
        }
			  else {
				  coeff += sign * Integer.parseInt(equation.substring(i, j));
			    i = j + 1;
        }
		  }

        // For cases such
		    // as: x2, -x2, +x2 (for x square)
      else if (equation.charAt(j) == 'X') {
        if ((i == j) || equation.charAt(j -1) == '+') {
          coeff2 += sign;
        }
        else if (equation.charAt(j - 1) == '-') {
				  coeff2 -= sign;
        }
			  else {
				  coeff2 += sign * Integer.parseInt(equation.substring(i, j));
			    i = j + 1;
        }
      }

		    // Flip sign once
		    // '=' is seen
		  else if (equation.charAt(j) == '=') {
			  if (j > i) {
				  total += sign * Integer.parseInt(equation.substring(i, j));
			    sign = -1;
			    i = j + 1;
        }
		  }
	  }

    c = Double.valueOf(total);
    b = Double.valueOf(coeff);
    a = Double.valueOf(coeff2);
    
    double determinant = b * b - 4 * a * c;

    // check if determinant is greater than 0
    if (determinant > 0) {
      // two real and distinct roots
      root1 = (-b + Math.sqrt(determinant)) / (2 * a);
      root2 = (-b - Math.sqrt(determinant)) / (2 * a);

      if (root1%1 == 0 && root2%1 == 0) {
        System.out.format("root1 = %.0f and root2 = %.0f", root1, root2);
      }
      else if (root1%1 == 0) {
        System.out.format("root1 = %.0f and root2 = %.2f", root1, root2);
      }
      else if (root2%1 == 0) {
        System.out.format("root1 = %.2f and root2 = %.0f", root1, root2);
      }
      else {
        System.out.format("root1 = %.2f and root2 = %.2f", root1, root2);
      }
  
      System.out.print("\n");
    }

    // check if determinant is equal to 0
    else if (determinant == 0) {
      // two real and equal roots
      // determinant is equal to 0
      // so -b + 0 == -b
      root1 = root2 = -b / (2 * a);
      System.out.format("root1 = root2 = %.2f;", root1);
      System.out.print("\n");
    }

    // if determinant is less than zero
    else {
      // roots are complex number and distinct
      double real = -b / (2 * a);
      double imaginary = Math.sqrt(-determinant) / (2 * a);
      System.out.format("It has no real roots\n");
      System.out.format("root1 = %.2f+%.2fi", real, imaginary);
      System.out.format("\nroot2 = %.2f-%.2fi", real, imaginary);
      System.out.print("\n");
    }
  }

  static int checkGCD(int a) {
    if (a < 0){
      int num = a*(-1);
      return num;
    }else{ 
      return a;
    }
  }

  static boolean isInteger( String input ) { //Pass in string 
    try { //Try to make the input into an integer 
        Integer.parseInt( input ); 
        return true; //Return true if it works 
    } 
    catch( Exception e ) {  
        return false; //If it doesn't work return false 
    } 
  }
  
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