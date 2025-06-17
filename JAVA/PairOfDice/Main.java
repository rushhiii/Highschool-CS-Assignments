package PairOfDice;

import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class Player {
  private String name;
  private int score;

  public Player(String name) {
    this.name = name;
    this.score = 0;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void setScore(int score) {
    this.score = score;
  }

  public void rollDice(Dice dice1, Dice dice2) {
    dice1.roll();
    dice2.roll();
    int sum = dice1.getValue() + dice2.getValue();

    if (sum == 7) {
      System.out.print(name + " rolled " + dice1.getValue() + " and " + dice2.getValue() + ", total: " + sum);
      System.out.print("  *** " + name + " wins! ***\n");
      setScore(getScore() + 1);
    } else {
      System.out.println(name + " rolled " + dice1.getValue() + " and " + dice2.getValue() + ", total: " + sum);
    }
  }
}

class Dice {
  private int value;
  private Random random;

  public Dice() {
    this.random = new Random();
    this.value = random.nextInt(6) + 1;
  }

  public int getValue() {
    return value;
  }

  public void roll() {
    this.value = random.nextInt(6) + 1;
  }
}

class PairOfDiceGame {
  private List<Player> players;
  private Dice dice1;
  private Dice dice2;

  public PairOfDiceGame() {
    this.players = new ArrayList<>();
    this.dice1 = new Dice();
    this.dice2 = new Dice();
  }

  public void addPlayer(Player player) {
    players.add(player);
  }

  public void play() {
    for (Player player : players) {
      player.rollDice(dice1, dice2);
    }
  }

  public void printScores() {
    for (Player player : players) {
      System.out.println(player.getName() + ": " + player.getScore());
    }
  }
}

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    PairOfDiceGame game = new PairOfDiceGame();

    System.out.println(
        "\nRules of this Game:\n1.Players who scores the most points wins\n2.To score a point a player's pair of dice sum has to be equal to 7");
    System.out.println("------------------------------------------------\n");

    System.out.print("Enter the number of players: ");
    int numOfP = input.nextInt();

    System.out.print("How my rounds you want to paly: ");
    int numOfR = input.nextInt();

    for (int i = 1; i <= numOfP; i++) {
      System.out.println();
      System.out.print("Enter player " + i + " name: ");
      String playerName = input.next();
      Player player = new Player(playerName);
      game.addPlayer(player);
    }

    System.out.println("\n\n------------------------------------------------");

    for (int i = 1; i <= numOfR; i++) {
      System.out.println("Round " + i + ":");
      System.out.println();
      game.play();
      System.out.println();
      System.out.println("------------------------------------------------");
    }

    System.out.println("Final scores:");
    System.out.println();
    game.printScores();
  }
}