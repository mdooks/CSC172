public class Test {
  public static void main (String[] args){
    Graph t = Graph.createFromFile("CSC172SP15_project4_data/ur.txt");
    t.shortPath("GOERGEN-ATHLETIC", "CSB");
    //System.out.println(t.edges());
  }
}
