public class Test {
  public static void main (String[] args){
    long s = System.currentTimeMillis();
    Graph t = Graph.createFromFile("CSC172SP15_project4_data/monroe.txt");
    long e = System.currentTimeMillis();
    System.out.println(e-s);
    //t.shortPath("GOERGEN-ATHLETIC", "CSB");
    t.shortPath("i1", "i2");
    long e2 = System.currentTimeMillis();
    System.out.println(e2-s);
    //t.parentPrinter();
  }
}
