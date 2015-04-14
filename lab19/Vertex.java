public class Vertex{
  int val;
  double dist;
  boolean known;
  Vertex parent;
  public Vertex(int i){
    val = i;
  }

  public int getVal(){
    return val;
  }
}
