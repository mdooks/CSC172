public class Node {
  String name;
  int num;
  double lon;
  double lat;
  Node connection;

  boolean known;
  double distance;
  Node parent;

  public Node(String n, int spot, double lo, double la){
    num = spot;
    name = n;
    lon = lo;
    lat = la;
  }
  public Node(){

  }

  public Node(String n){
    name = n;
  }

  public void setKnown(){
    
  }

  public boolean equals(Node that){
    if (this.name.equals(that.name)){
      return true;
    }
    return false;
  }
}
