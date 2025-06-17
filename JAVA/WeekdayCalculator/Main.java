package WeekdayCalculator;

import java.util.GregorianCalendar;
import java.lang.String;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {

    System.out.println("What year were you born in?");
    Scanner keyboard = new Scanner(System.in);
    String varYear = keyboard.next();

    int year = Integer.parseInt(varYear);

    System.out.println("What month were you born in? (Please type in number)");
    Scanner keyboard2 = new Scanner(System.in);
    int month = Integer.parseInt(keyboard2.next());

    System.out.println("What day of the month were you born on?");
    Scanner keyboard3 = new Scanner(System.in);
    String varDay = keyboard3.next();

    int day = Integer.parseInt(varDay);
/*
    month = month.replace("JANUARY", "0");
    month = month.replace("FEBRUARY", "1");
    month = month.replace("MARCH", "2");
    month = month.replace("APRIL", "3");
    month = month.replace("5", "MAY");
    month = month.replace("JUNE", "5");
    month = month.replace("JULY", "6");
    month = month.replace("AUGUST", "7");
    month = month.replace("SEPTEMBER", "8");
    month = month.replace("OCTOBER", "9");
    month = month.replace("NOVEMBER", "10");
    month = month.replace("DECEMBER", "11");
*/
    int realMonth = month;

    GregorianCalendar birthDay = new GregorianCalendar();

    birthDay.set(year, realMonth, day);

    int weekday = birthDay.get(GregorianCalendar.DAY_OF_WEEK);

    String weekDay = String.valueOf(weekday + 3);

    weekDay = weekDay.replace("0", "Sunday.");
    weekDay = weekDay.replace("1", "Monday.");
    weekDay = weekDay.replace("2", "Tuesday.");
    weekDay = weekDay.replace("3", "Wednesday.");
    weekDay = weekDay.replace("4", "Thursday.");
    weekDay = weekDay.replace("5", "Friday.");
    weekDay = weekDay.replace("6", "Saturday.");

    System.out.println("You were born on a " + (weekDay));
  }
}