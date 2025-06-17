package OOP2SampleCode;

// ========================= ADT ============================
// import java.util.*;

// public class Shape implements Comparable<Shape> {
//     private String name;
//     private int age;

//     public Shape(String name, int age) {
//         this.name = name;
//         this.age = age;
//     }

//     public String getName() {
//         return this.name;
//     }

//     public int getAge() {
//         return this.age;
//     }

//     @Override
//     public int compareTo(Shape other) {
//         // Compare persons based on age
//         return Integer.compare(this.age, other.age);
//     }

//     public static void main(String[] args) {
//         List<Shape> persons = new ArrayList<>();
//         persons.add(new Shape("Alice", 30));
//         persons.add(new Shape("Bob", 25));
//         persons.add(new Shape("Charlie", 35));

//         System.out.println("Before sorting:");
//         for (Shape person : persons) {
//             System.out.println(person.getName() + " (" + person.getAge() + ")");
//         }

//         Collections.sort(persons);

//         System.out.println("After sorting by age:");
//         for (Shape person : persons) {
//             System.out.println(person.getName() + " (" + person.getAge() + ")");
//         }
//     } 
// }

// ========================= Interface ============================

// abstract class Shape {
//     public abstract double getArea();
// }

// class Circle extends Shape {
//     private double radius;

//     public Circle(double radius) {
//         this.radius = radius;
//     }

//     public double getRadius() {
//         return radius;
//     }

//     public void setRadius(double radius) {
//         this.radius = radius;
//     }

//     @Override
//     public double getArea() {
//         return Math.PI * Math.pow(radius, 2);
//     }
// }

// class Square extends Shape {
//     private double side;

//     public Square(double side) {
//         this.side = side;
//     }

//     public double getSide() {
//         return side;
//     }

//     public void setSide(double side) {
//         this.side = side;
//     }

//     @Override
//     public double getArea() {
//         return Math.pow(side, 2);
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Circle circle = new Circle(2.0);
//         System.out.println("Circle area = " + circle.getArea());

//         Square square = new Square(3.0);
//         System.out.println("Square area = " + square.getArea());
//     }
// }

// ========================= Polymorphism ============================

// class Animal {
//     public void speak() {
//         System.out.println("Animal is speaking");
//     }
// }

// class Dog extends Animal {
//     @Override
//     public void speak() {
//         System.out.println("Dog is barking");
//     }
// }

// class Cat extends Animal {
//     @Override
//     public void speak() {
//         System.out.println("Cat is meowing");
//     }
// }

// public class Main {
//     public static void main(String[] args) {
//         Animal[] animals = new Animal[3];
//         animals[0] = new Animal();
//         animals[1] = new Dog();
//         animals[2] = new Cat();

//         for (Animal animal : animals) {
//             animal.speak();
//         }
//     }
// }

// ============= Student interface & ADT =============

// abstract class Course {
//   public abstract String courseName();
//   public abstract String courseCode();
//   public abstract int courseCredits();
//   public abstract String courseDescription();
// }

// interface Student {
//   public void fullName();
//   public void age();
//   public void id();
//   public void grad();
//   public void credits();
//   public void average();
// }

// // class avi implements Student {
// class avi extends Course implements Student {

//   String name = "Avinash";

//   public void fullName() {
//     String name = "Acorn, Avinash";
//     System.out.printf("%nStudent Name: %s", name);
//   }

//   public void age() {
//     int age = 16;
//     System.out.printf("%nStudent Age: %s", age);
//   }

//   public void id() {
//     int studentId = 10283365;
//     System.out.printf("%nStudent ID: %s", studentId);
//   }

//   public void credits() {
//     int c = 70;
//     System.out.printf("%nStudent credits: %s", c);
//   }

//   public void grad() {
//     int grade = 11;
//     System.out.printf("%nStudent's grad: %s", grade);
//   }

//   public void average() {
//     int overallMarks = 70;
//     System.out.printf("%nStudent's average: %s%%", overallMarks);
//   }

//    public String courseName() {
//         return "Mathematics";
//     }

//     public String courseCode() {
//         return "MATH101";
//     }

//     public int courseCredits() {
//         return 3;
//     }

//     public String courseDescription() {
//         return "Introduction to Calculus";
//     }
// }

// // class arman implements Student {
// class arman extends Course implements Student {
//   String name = "Arman";

//   public void fullName() {
//     String name = "Singh, Arman";
//     System.out.printf("%nStudent Name: %s", name);
//   }

//   public void age() {
//     int age = 18;
//     System.out.printf("%nStudent Age: %s", age);
//   }

//   public void id() {
//     int studentId = 80318475;
//     System.out.printf("%nStudent ID: %s", studentId);
//   }

//   public void credits() {
//     int c = 106;
//     System.out.printf("%nStudent credits: %s", c);
//   }

//   public void grad() {
//     int grade = 12;
//     System.out.printf("%nStudent's grad: %s", grade);
//   }

//   public void average() { 
//     int overallMarks = 90;
//     System.out.printf("%nStudent's average: %s%%", overallMarks);
//   }
//   public String courseName() {
//     return "Chemistry";
//   }

//   public String courseCode() {
//     return "CHEM101";
//   }

//   public int courseCredits() {
//     return 4;
//   }

//   public String courseDescription() {
//     return "Introduction to Chemical Bonding";
//   }
// }

// public class Main {
//   public static void main(String args[]) {
//     System.out.println();
//     avi Student_1 = new avi();
//     arman Student_2 = new arman();

//     System.out.print("\n------------ Student Info ------------");
//     Student_1.fullName();
//     Student_1.age();
//     Student_1.id();
//     Student_1.credits();
//     Student_1.grad();
//     Student_1.average();
//     System.out.print("\n\nStudent's Course info");
//     System.out.printf("%nCourse name: %s", Student_1.courseName());
//     System.out.printf("%nCourse code: %s", Student_1.courseCode());
//     System.out.printf("%nCourse credit: %s",                              Student_1.courseCredits());
//     System.out.printf("%nCourse description: %s",                         Student_1.courseDescription());
//     System.out.print("\n--------------------------------------");

//     System.out.print("\n\n------------ Student Info ------------");
//     Student_2.fullName();
//     Student_2.age();
//     Student_2.id();
//     Student_2.credits();
//     Student_2.grad();
//     Student_2.average();
//     System.out.print("\n\nStudent's Course info");
//     System.out.printf("%nCourse name: %s", Student_2.courseName());
//     System.out.printf("%nCourse code: %s", Student_2.courseCode());
//     System.out.printf("%nCourse credit: %s",                              Student_2.courseCredits());
//     System.out.printf("%nCourse description: %s",                   Student_2.courseDescription());
//     System.out.print("\n--------------------------------------");
//   }
// }

// ================= 2 way =================

import java.util.*;

abstract class Course {
  public abstract String name();

  public abstract String code();

  public abstract int creditHours();

  public abstract String description();
}

class MathCourse extends Course {
  public String name() {
    return "Mathematics";
  }

  public String code() {
    return "MATH101";
  }

  public int creditHours() {
    return 3;
  }

  public String description() {
    return "Introduction to Calculus";
  }
}

class EnglishCourse extends Course {
  public String name() {
    return "English";
  }

  public String code() {
    return "ENGL101";
  }

  public int creditHours() {
    return 3;
  }

  public String description() {
    return "Introduction to Literature";
  }
}

class PhysicsCourse extends Course {
  public String name() {
    return "Physics";
  }

  public String code() {
    return "PHYS101";
  }

  public int creditHours() {
    return 4;
  }

  public String description() {
    return "Introduction to Mechanics";
  }
}

class ChemistryCourse extends Course {
  public String name() {
    return "Chemistry";
  }

  public String code() {
    return "CHEM101";
  }

  public int creditHours() {
    return 4;
  }

  public String description() {
    return "Introduction to Chemical Bonding";
  }
}

interface Student {
  public void fullName();

  public void age(int age);

  public void id();

  public void grad();

  public void credits();

  public void average();

  public void courses(Course[] courses);
}

class avi implements Student {
  String name = "Avinash";
  private Course[] courses;

  public void courses(Course[] courses) {
    this.courses = courses;
  }

  public void fullName() {
    String name = "Acorn, Avinash";
    System.out.printf("%nStudent Name: %s", name);
  }

  public void age(int age) {
    // int age = 16;
    // System.out.printf("%nStudent Age: %s", age);
    try {
      // int age = -16;
      if (age < 0) {
        throw new IllegalArgumentException("ERROR: ---- Age cannot be negative ----");
      }
      System.out.printf("%nStudent Age: %s", age);
    } catch (IllegalArgumentException e) {
        System.out.print("\n" + e.getMessage());
      }
  }

  public void id() {
    int studentId = 10283365;
    System.out.printf("%nStudent ID: %s", studentId);
  }

  public void credits() {
    int c = 70;
    System.out.printf("%nStudent credits: %s", c);
  }

  public void grad() {
    int grade = 11;
    System.out.printf("%nStudent's grad: %s", grade);
  }

  public void average() {
    int overallMarks = 70;
    System.out.printf("%nStudent's average: %s%%", overallMarks);
  }
}

class arman implements Student {
  String name = "Arman";
  private Course[] courses;

  public void courses(Course[] courses) {
    this.courses = courses;
  }

  public void fullName() {
    String name = "Sharma, Arman";
    System.out.printf("%nStudent Name: %s", name);
  }

  public void age(int age) {
    // int age = 18;
    // System.out.printf("%nStudent Age: %s", age);
    try {
      // int age = -18;
      if (age < 0) {
        throw new IllegalArgumentException("ERROR: ---- Age cannot be negative ----");
      }
      System.out.printf("%nStudent Age: %s", age);
    } catch (IllegalArgumentException e) {
        System.out.print("\n" + e.getMessage());
      }
  }

  public void id() {
    int studentId = 80318475;
    System.out.printf("%nStudent ID: %s", studentId);
  }

  public void credits() {
    int c = 106;
    System.out.printf("%nStudent credits: %s", c);
  }

  public void grad() {
    int grade = 12;
    System.out.printf("%nStudent's grad: %s", grade);
  }

  public void average() {
    int overallMarks = 90;
    System.out.printf("%nStudent's average: %s%%", overallMarks);
  }
}

public class Main {
  public static void main(String args[]) {
    Scanner input = new Scanner(System.in);
    System.out.println();
    System.out.print("Enter Student 1 age: ");
    int ageS1 = input.nextInt();
    System.out.println();
    System.out.print("Enter Student 2 age: ");
    int ageS2 = input.nextInt();
    
    Course mathCourse = new MathCourse();
    Course englishCourse = new EnglishCourse();
    Course physicsCourse = new PhysicsCourse();
    Course chemistryCourse = new ChemistryCourse();

    Student avi = new avi();
    Student arman = new arman();

    Course[] aviCourses = {mathCourse, physicsCourse};
    avi.courses(aviCourses);

    Course[] armanCourses = {mathCourse, englishCourse, chemistryCourse};
    arman.courses(armanCourses);

    System.out.print("\n------------ Student 1 Info ------------");
    avi.fullName();
    avi.age(ageS1);
    avi.id();
    avi.grad();
    avi.credits();
    avi.average();
    System.out.println("\nCourses taken by Avinash:");
    for (Course course : aviCourses) {
      System.out.println(course.name() + " (" + course.code() + "): " + course.description());
    }
    System.out.println("--------------------------------------");

    System.out.print("\n\n------------ Student 2 Info ------------");
    arman.fullName();
    arman.age(ageS2);
    arman.id();
    arman.grad();
    arman.credits();
    arman.average();
    System.out.println("\nCourses taken by Arman:");
    for (Course course : armanCourses) {
      System.out.println(course.name() + " (" + course.code() + "): " + course.description());
    }
    System.out.println("--------------------------------------");
  }
}


// try {
//       avi.fullName();
//     } catch (NumberFormatException | NullPointerException e) {
//       System.out.println("Hey dude, you can't make an int out");
//     }
//     System.out.println("End here");