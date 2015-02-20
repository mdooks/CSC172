import java.util.Scanner;

public class Game {
  public static void main(String[] args){
    System.out.println("Welcome to MasterMind. The Computer will try to guess the code you have chosen, and you provide feedback based on the positions of the tokens. Have fun!\n");
    Scanner input = new Scanner(System.in);
    System.out.print("Enter the tokens seperated by a space: ");
    String color_s = input.nextLine();
    String[] colors = color_s.split(" ");
    System.out.print("Enter the number of tokens in the code: ");
    int x = input.nextInt();
    MasterMind m = new MasterMind(colors, x);
    Code g = new Code();
    String[] move;
    while (!m.won){
      System.out.println("Finding move, please wait.");
      move = m.nextMove();
      System.out.print("My guess is: ");
      for (String c : move){
        System.out.print(c +", ");
      }
      System.out.println();
      System.out.print("How many are in the right spot? ");
      int b = input.nextInt();
      System.out.print("How many are the right color, wrong spot? ");
      int w = input.nextInt();
      System.out.println();
      m.response(w,b);
      if (m.won){
        System.out.print("Do you want to play again (y/n)? ");
        String newgame = input.next();
        if (newgame.charAt(0) == 'y'){
          System.out.println("Good Luck.");
          m.newGame();
        }
      }
    }
  }
}
