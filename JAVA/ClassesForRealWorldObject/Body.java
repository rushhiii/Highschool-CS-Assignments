package ClassesForRealWorldObject;

import java.awt.*;

class Body {
  public Body(){
  int legs = 1;
  int arms = 2;
  int heart = 0;

    System.out.print("\n");
    running(legs);
    training(arms);
    heartBeat(heart);
    System.out.print("\n");
    
}
  public void running(int legs) {
    System.out.println("I am Running using my " + legs + " leg.");
  }
  void training(int arms) {
    System.out.println("I train my " + arms + " arms to make them big.");
  }
  void heartBeat(int heart) {
    System.out.println("If my heart rate hits " + heart + " bpm, while traing my arms I might die.");
  }
}