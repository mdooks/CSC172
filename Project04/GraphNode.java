public class GraphNode{
  String id;
  GraphNode next;
  double weight;

  public GraphNode(String i){
    id = i;
  }

  public void insert(GraphNode n, String a, Double lb){
    if(n.next == null){
      n.next = new GraphNode(a);
      n.next.weight = lb;
    }
    else{
      insert(n.next, a, lb);
    }
  }

  public boolean lookup(GraphNode n, String a){
    if(n == null){
      return false;
    }
    else if (n.id.equals(a)){
      return true;
    }
    else{
      return lookup(n.next, a);
    }
  }

  public double lookupWeight(GraphNode n, String a){
    if(n == null){
      return 10000000;//shoudl never Happen...
    }
    else if (n.id.equals(a)){
      return n.weight;
    }
    else{
      return lookupWeight(n.next, a);
    }
  }

  public void printConnections(){
    if (next == null){
      return;
    }
    else {
      System.out.print(next.id +", ");
      next.printConnections();
    }
  }

  public boolean equals (String x){
    return (x.equals(id));
  }
}
