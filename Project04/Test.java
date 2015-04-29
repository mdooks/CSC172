import java.util.ArrayList;

public class Test {
  public static void main (String[] args){
    long s = System.currentTimeMillis();
    Graph t = Graph.createFromFile("CSC172SP15_project4_data/ur.txt");
    /*for (Node n : t.nodeMap.values()){
      //System.out.println(n.name);
    }*/
    //System.out.println(t.vertices()+ " Vert");
    long e = System.currentTimeMillis();
    System.out.println(e-s);
    t.shortPath("GOERGEN-ATHLETIC", "CSB");
    //t.shortPath("i15", "i326985");
    long e2 = System.currentTimeMillis();
    System.out.println(e2-s);
    t.Kruskal(new ArrayList<Edge>(t.edgeMap.values()), t.vertices());
    //t.parentPrinter();
  }
}
