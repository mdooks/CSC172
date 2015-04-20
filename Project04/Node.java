public class Node {
  String name;
  int num;
  double lon;
  double lat;
  Node connection;

  public Node(String n, int spot, double lo, double la){
    num = spot;
    name = n;
    lon = lo;
    lat = la;
  }
}
