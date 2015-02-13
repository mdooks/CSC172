public class Game {
  public static void main(String[] args){
    String[] colors = {"red", "blue", "green", "yellow"};
    int x = 3;
    MasterMind m = new MasterMind(colors, x);
    m.printList();
    System.out.println();
    Code g = new Code();
    int[] d = {0,0,1};
    g.code = d;
    m.currentGuess = g;
    m.response(1, 1);
    //m.codeList.delete(g.code);
    m.printList();
  }
}
