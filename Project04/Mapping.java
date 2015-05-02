
import java.util.ArrayList;

public class Mapping {
  public static void main(String[] args){
    String filename = args[0];
    boolean mmap = false;
    boolean direction = false;
    boolean show = false;
    String start ="", end = "";
    System.out.println(args[1]);
    if(args[1].equals("-show")){
      System.out.println("Showing");
      show = true;
      if (args[2].equals("-meridianmap")){
        mmap = true;
      }
      else if(args[2].equals("-directions")){
        System.out.println("Directions");
        direction = true;
        start = args[3];
        end = args[4];
      }
    }
    else{
      if (args[1].equals("-meridianmap")){
        mmap = true;
      }
      else if(args[1].equals("-directions")){
        direction = true;
        start = args[2];
        end = args[3];
      }
    }

    Graph t = Graph.createFromFile(filename);
    if (mmap == true){
      ArrayList<Edge> ans = t.Prim("i15");
      if(show){
        t.mspShow();
      }
      else{
        for (Edge e : ans){
          System.out.print(e.name + ", ");
        }
        System.out.println();
      }
    }
    else if (direction == true){
      System.out.println("directions");
      if(show){
        System.out.println("showing, no print");
        t.shortPath(start, end, false);
        t.directionShow();
      }
      else{
        System.out.println("printing no show");
        t.shortPath(start, end, true);
      }
    }


  }
}
