public class Test {
  public static void main (String[] args){
    Graph t = Graph.createFromFile("CSC172SP15_project4_data/nys.txt");
    //t.shortPath("GOERGEN-ATHLETIC", "CSB");
    t.shortPath("i1", "i2");
    //t.parentPrinter();
  }
}
