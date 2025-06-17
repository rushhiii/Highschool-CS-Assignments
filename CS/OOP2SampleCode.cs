// Sample code 1
// using System;

// public interface A
// {
//     void myMethod1();
//     // void mymethod2();
//     void myMethod2();
//     // void myMethod3();
//     // void myMethod4();
// }

// public interface B : A
// {

//     void myMethod5();
// }

// public interface C : B
// {

//     void myMethod6();
// }

// class changeMethod : C
// {

//     public void myMethod1()
//     {
//         Console.WriteLine("Implement method 1");
//     }

//     public void myMethod2()
//     {
//         Console.WriteLine("Implement method 2");
//     }

//     public void myMethod5()
//     {
//         Console.WriteLine("Implement method 5");
//     }
//     public void myMethod6()
//     {
//         Console.WriteLine("Implementation method 6")
//     }
// }

// class Program
// {
//     public static void Main(string[] args)
//     {
//         {

//             changeMethod obj = new changeMethod();

//             obj.myMethod1();
//             obj.myMethod2();
//             obj.myMethod5();
//             obj.myMethod6();
//         }
//     }
// }


// =========================================================


// Sample code 2
using System;

// declaring an interface
public interface Votes
{

    // method of interface
    void vote_no(int a);
}

// The methods of interface Votes
// is inherited into interface Details
public interface Details : Votes
{

    // method of interface Details
    void detailsofauthor(string n, int p, int age);
}

// Below class is inheriting
// the interface Details
// This class must implement
// the methods of both interface
// i.e. Votes and Details
class TechinalScriptWriter : Details
{

    // implementing the method
    // of interface Votes
    public void vote_no(int a)
    {
        Console.WriteLine("Total number of votes: {0}", a);
    }
    // implementing the method
    // of interface Details
    public void detailsofauthor(string n, int p, int age)
    {
        // string N = CapitalizeFirstLetter(n);
        Console.Write("Author's name: ");
        CapitalizeFirstLetter(n);

        Console.WriteLine("\nAuthor's age: {0}", age);

        Console.WriteLine("Total number of article published: {0}", p);
    }
    public String CapitalizeFirstLetter(string str)
    {
        // string str = "educative";

        if (str.Length == 0) {
            System.Console.Write("");
          }
      else if (str.Length == 1) {
            System.Console.Write(char.ToUpper(str[0]));
        }
      else {
            System.Console.Write(char.ToUpper(str[0]) + str.Substring(1));
        }
        return str;
    }
}






// Driver Class
class Program
{
    public static void Main(string[] args)
    {

        // Creating the objects of
        // TechinalScriptWriter class
        TechinalScriptWriter obj = new TechinalScriptWriter();

        // calling the methods by passing
        // the required values
        Console.Write("\nEnter the author's name: ");
        String n = Console.ReadLine();

        Console.Write("Enter the author's age: ");
        int age = Convert.ToInt32(Console.ReadLine());
        // int age = Console.Read();

        Console.Write("Enter number of article published: ");
        int p = Convert.ToInt32(Console.ReadLine());
        // int p = Console.Read();

        Console.Write("Enter number of votes out of 470045: ");
        int v = Convert.ToInt32(Console.ReadLine());
        // int v = Console.Read();

        Console.WriteLine("\n================================================\n");

        obj.detailsofauthor(n, p, age);
        obj.vote_no(v);
    }
}