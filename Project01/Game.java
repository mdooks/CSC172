import java.util.Scanner;

public class Game {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    //int y = input.nextInt();
    String[] colors = {"red", "blue", "green", "yellow", "orange", "purple"};
    int x = 3;
    MasterMind m = new MasterMind(colors, x);
    //m.printList();
    Code g = new Code();
    String[] move;
    while (!m.won){
      move = m.nextMove();
      //m.currentGuess = g;
      //m.printList();
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
      //m.printList();
      if (m.won){
        System.out.print("Do you want to play again (y/n)? ");
        String newgame = input.next();
        if (newgame.charAt(0) == 'y'){
          System.out.println("Yay!");
          m.newGame();
          //m.printList();
        }
      }
    }
  }
}
