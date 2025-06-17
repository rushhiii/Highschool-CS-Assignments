package TheSaffirSimpsonHurricaneScale;

import java.util.*;

class Main {
  public static void main(String[] args) {

    int cat;
    
    Scanner input = new Scanner(System.in);

    System.out.println("Enter the catergory of the hurricane: ");
    cat = input.nextInt();
    input.close();

    switch (cat) {
      case 1:
        System.out.println("Category 1: 74-95 mph or 64-82 kt or 119-153 km/hr");
        break;
      case 2:
        System.out.println("Category 2: 96-110 mph or 83-95 kt or 154-177 km/hr");
        break;
      case 3:
        System.out.println("Category 3: 111-130 mph or 96-113 kt or 178-209 km/hr");
        break;
      case 4:
        System.out.println("Category 4: 131-155 mph or 114-135 kt or 210-249 km/hr");
        break;
      case 5:
        System.out.println("Category 5: Greater than 155mph or 135kt or 249 km/hr");
      
    }
  }

}

