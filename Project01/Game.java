import java.util.Scanner;

public class Game {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in);
    int y = input.nextInt();
    String[] colors = {"red", "blue", "green", "yellow"};
    int x = 3;
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
      System.out.println("How many are the right color, wrong spot? ");
      int w = input.nextInt();
      m.response(w,b);
      m.printList();
    }
    System.out.println();

    int[] d = {0,0,1};
    g.code = m.nextMove();
    for(int i : g.code){
      System.out.print(i);
    }
    System.out.println();
    System.out.println();
    m.currentGuess = g;
    m.response(1, 1);
    //m.codeList.delete(g.code);
    m.printList();
    System.out.println();
    System.out.println();
    g.code = m.nextMove();
    for(int i : g.code){
      System.out.print(i);
    }
    System.out.println();
    System.out.println();
  }
}
