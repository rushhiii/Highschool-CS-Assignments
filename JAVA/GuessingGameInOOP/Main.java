package GuessingGameInOOP;

import java.util.*;

public class Main {
  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    char choice; // holds yes or no

    System.out.println("\n--------------Guessing Game--------------");

    do {
      System.out.print(
          "\n\nWhich type of guessing game you want to play\n1 - Letter\n2 - Number\n3 - Word\n\nEnter the number form above to play that game: ");

      int num = input.nextInt();

      if (num == 1) {
        System.out.println("\nGuess a letter ftom a-z (NOTE: Lowercase only)");
        LetterGameSet letterGameSet = new LetterGameSet();

        System.out.println("\n------------------------------------------------\n");

        System.out.print("Enter the number of players: ");
        int numOfP = input.nextInt();

        for (int i = 1; i <= numOfP; i++) {
          System.out.println();
          System.out.print("Enter player " + i + " name: ");
          String playerName = input.next();
          Player player = new Player(playerName);
          playGame(player, letterGameSet);

          System.out.print("\n------------------------------------------------\n");
        }
      }
      if (num == 2) {
        System.out.println("\nGuess a number from 0-10");
        NumberGameSet numberGameSet = new NumberGameSet();
        // WordGameSet wordGameSet = new WordGameSet();

        System.out.println("\n------------------------------------------------\n");

        System.out.print("Enter the number of players: ");
        int numOfP = input.nextInt();

        for (int i = 1; i <= numOfP; i++) {
          System.out.println();
          System.out.print("Enter player " + i + " name: ");
          String playerName = input.next();
          Player player = new Player(playerName);
          playGame(player, numberGameSet);

          System.out.print("\n------------------------------------------------\n");
        }
      }
      if (num == 3) {
        System.out.println(
            "\nGuess a word from the following:\napple, orange, grape, banana, pineapple, mango, pomegranate, papaya, watermelon, lime, cherry ,guava, chikoo\n(NOTE: lowercase only)");
        WordGameSet wordGameSet = new WordGameSet();

        System.out.println("\n------------------------------------------------\n");

        System.out.print("Enter the number of players: ");
        int numOfP = input.nextInt();

        for (int i = 1; i <= numOfP; i++) {
          System.out.println();
          System.out.print("Enter player " + i + " name: ");
          String playerName = input.next();
          Player player = new Player(playerName);
          playGame(player, wordGameSet);

          System.out.print("\n------------------------------------------------\n");
        }
      }

      System.out.print("\nWould you like to continue?\nEnter Y for yes or N for no: ");
      choice = input.next().charAt(0);
      System.out.print("\n------------------------------------------------\n");
    } while ((choice == 'y') || (choice == 'Y'));

    System.out.print("\nThanks for playing");

  }

  public static void playGame(Player player, GameSet gameSet) {
    System.out.println("\n" + player.getName() + " is playing with " + gameSet.getName() + " set.");
    System.out.println("Guess the " + gameSet.getType() + "!");

    // randomly select answer from game set
    String answer = gameSet.getRandomAnswer();

    // keep track of guesses and score
    int numGuesses = 0;
    int maxGuesses = 10;
    boolean isCorrect = false;

    while (numGuesses < maxGuesses && !isCorrect) {
      // get player's guess
      String guess = player.makeGuess(gameSet);

      // check if guess is correct
      if (guess.equals(answer)) {
        System.out.println("Correct!");
        isCorrect = true;
        player.incrementScore();
      } else {
        System.out.println("Incorrect. Guess again.");
        numGuesses++;
      }
    }

    // display game over message
    if (isCorrect) {
      System.out.println("\nGame over! " + player.getName() + " wins with a score of " + player.getScore() + ".");
    } else {
      System.out.println("\nGame over! " + player.getName() + " failed to guess the " + gameSet.getType() + ".");
      System.out.println("\nThe letter was: " + answer);
    }
  }
}

abstract class GameSet {
  private String name;
  private String type;
  private List<String> answers;

  public GameSet(String name, String type, List<String> answers) {
    this.name = name;
    this.type = type;
    this.answers = answers;
  }

  public String getName() {
    return name;
  }

  public String getType() {
    return type;
  }

  public String getRandomAnswer() {
    int index = new Random().nextInt(answers.size());
    return answers.get(index);
  }
}

class LetterGameSet extends GameSet {
  public LetterGameSet() {
    super("Letter", "letter", Arrays.asList("a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o",
        "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"));
  }
}

class NumberGameSet extends GameSet {
  public NumberGameSet() {
    super("Number", "number", Arrays.asList("0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10"));
  }
}

class WordGameSet extends GameSet {
  public WordGameSet() {
    super("Word", "word",
        Arrays.asList("apple", "orange", "grape", "banana", "pineapple", "mango", "pomegranate", "papaya", "watermelon",
            "lime", "cherry", "guava", "chikoo"));
  }
}

class Player {
  private String name;
  private int score;

  public Player(String name) {
    this.name = capitalize(name);
    this.score = 0;
  }

  public String getName() {
    return name;
  }

  public int getScore() {
    return score;
  }

  public void incrementScore() {
    score++;
  }

  public static final String capitalize(String str) {
    if (str == null || str.length() == 0)
      return str;
    return str.substring(0, 1).toUpperCase() + str.substring(1);
  }

  public String makeGuess(GameSet gameSet) {
    Scanner input = new Scanner(System.in);
    System.out.print("Enter your guess for the " + gameSet.getType() + ": ");
    return input.nextLine();
  }
}
