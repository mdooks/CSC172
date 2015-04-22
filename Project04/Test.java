public class Test {
  public static void main (String[] args){
    Graph t = Graph.createFromFile("CSC172SP15_project4_data/nys.txt");
    t.shortPath("i1", "i82");
    //t.parentPrinter();
  }
}
