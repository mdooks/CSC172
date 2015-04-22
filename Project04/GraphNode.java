public class GraphNode{
  String id;
  GraphNode next;
  double weight;

  public GraphNode(String i){
    id = i;
  }

  public void insert(GraphNode n, String a, Double lb){
    if(n.next == null){
      next = new GraphNode(a);
      next.weight = lb;
    }
    else{
      insert(n.next, a, lb);
    }
  }
}
