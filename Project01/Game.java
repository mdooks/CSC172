import java.util.Scanner;

public class Game {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    //int y = input.nextInt();
    String[] colors = {"red", "blue", "green", "yellow"};
    int x = 4;
    MasterMind m = new MasterMind(colors, x);
    //m.printList();
    Code g = new Code();
    while (!m.won){
      g.code = m.nextMove();
      m.currentGuess = g;
      //m.printList();
      System.out.print("My guess is: ");
      for (int c : g.code){
        System.out.print(c);
      }
      System.out.println();
      System.out.print("How may are in the right spot? ");
      int b = input.nextInt();
      System.out.print("How many are the right color, wrong spot? ");
      int w = input.nextInt();
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
