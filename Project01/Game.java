public class Game {
  public static void main(String[] args){
    String[] colors = {"red", "blue", "green", "yellow"};
    int x = 3;
    MasterMind m = new MasterMind(colors, x);
    m.printList();
  }
}
