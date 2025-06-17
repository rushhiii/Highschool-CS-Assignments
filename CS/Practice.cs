using System;

class Program
{
    public static void Main(string[] args)
    {
        Console.WriteLine("\n");
        Console.WriteLine("Type your equation: ");
        string[] answer = new string[10];
        for (int i = 0; i < answer.length; i++)
        {
            answer[i] = Console.ReadLine();
        }
    }
}
