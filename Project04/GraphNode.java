/*
* Project 4
*
* Project 4
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Project 4
*
* Author: Nicholas Graham
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: May 2, 2015
*/
public class GraphNode implements Comparable<GraphNode>{
  String id;
  GraphNode next;
  double weight;
  int cons;
  String parent;
  String road;

  public GraphNode(String i){
    id = i;
    cons = 0;
  }

  public void insert(GraphNode n, String a, Double lb, String par, String r){
    if(n.next == null){
      n.next = new GraphNode(a);
      n.next.weight = lb;
      n.next.parent = par;
      n.next.road = r;
      cons++;
    }
    else{
      insert(n.next, a, lb, par, r);
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
      return 10000000;//should never Happen...
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
  public GraphNode[] getConnections(){
    GraphNode[] ans = new GraphNode[cons];
    conHelper(this,ans, 0);
    return ans;
  }

  public GraphNode[] conHelper(GraphNode n, GraphNode[] a, int p){
    if (n.next == null){
      return a;
    }
    else{
      a[p] = n.next;
      return conHelper(n.next, a, p+1);
    }
  }

  public boolean equals (String x){
    return (x.equals(id));
  }

  public int compareTo(GraphNode that){
    if (this.weight == that.weight){
      return 0;
    }
    else if (this.weight > that.weight){
      return 1;
    }
    else{
      return -1;
    }
  }
}
