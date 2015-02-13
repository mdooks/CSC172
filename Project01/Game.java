public class Game {
  public static void main(String[] args){
    String[] colors = {"red", "blue", "green", "yellow"};
    int x = 3;
    MasterMind m = new MasterMind(colors, x);
    //m.printList();
    System.out.println();
    Code g = new Code();
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
