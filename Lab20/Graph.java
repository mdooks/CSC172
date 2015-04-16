/*
* Lab18
*
* Lab 18
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Lab 18
*
* Author: Nicholas Graham
*
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: April 11, 2015.
*/
import java.io.File;
import java.util.Scanner;
public class Graph {
  static Scanner in;
  private int vertexCount;
  private int edgeCount;

  boolean directed;
  private boolean adj[][];

  public Graph (int numV, boolean d){
    vertexCount = numV;
    directed = d;
    adj = new boolean[numV][numV];
    edgeCount = 0;
  }

  public boolean isDirected(){
    return directed;
  }
  public int vertices(){
    return vertexCount;
  }
  public int edges(){
    return edgeCount;
  }
  public void insert(Edge e) {
    if (isDirected()){
      if (adj[e.v.val][e.w.val] == false){
        adj[e.v.val][e.w.val] = true;
        edgeCount++;
      }
    }
    else{
      if(adj[e.v.val][e.w.val] == false){
        adj[e.v.val][e.w.val] = true;
        edgeCount++;
      }
      if(adj[e.w.val][e.v.val] == false)
      adj[e.w.val][e.v.val] = true;
      edgeCount++;
    }
  }

  public void delete(Edge e){
    if (isDirected()){
      if (adj[e.v.val][e.w.val] == true){
        adj[e.v.val][e.w.val] = false;
        edgeCount--;
      }
    }
    else{
      if(adj[e.v.val][e.w.val] == true){
        adj[e.v.val][e.w.val] = false;
        edgeCount--;
      }
      if(adj[e.w.val][e.v.val] == true)
      adj[e.w.val][e.v.val] = false;
      edgeCount--;
    }
  }

  public boolean connected (int node1, int node2){
    return adj[node1][node2];
  }

  public AdjArray getAdjList(int vertex){
    return new AdjArray(vertex);
  }

  public void show(){
    for (int s = 0; s<vertices(); s++){
      System.out.print(s + ": ");
      AdjList A = getAdjList(s);
      for(int t = A.begin(); !A.end(); t=A.next()){
        System.out.print(t+ " ");
      }
      System.out.println();
    }
  }

  public static Graph createFromFile(String fileName){
    File f = new File(fileName);
    try{
      in = new Scanner(f);
    }catch(Exception e){
      System.out.println("File Not Found");
      return null;
    }

    int nodes = in.nextInt();
    String directionality = in.next();
    Graph g;
    if (directionality.equals("U")){
      g = new Graph(nodes, false);
    }
    else if(directionality.equals("D")){
      g = new Graph(nodes, true);
    }
    else{
      System.out.println("The option for the directionality was not valid.");
      return null;
    }
    while (in.hasNext()){
      int v = in.nextInt();
      int w = in.nextInt();
      int we = in.nextInt();
      g.insert(new Edge(v,w,we));
    }
    g.show();
    return g;
  }

  private class AdjArray implements AdjList {
    private int v;
    private int i;

    public AdjArray(int v){
      this.v = v;
      i = -1;
    }

    public int next(){
      for(++i; i < vertices(); i++){
        if (connected(v, i) == true){
          return i;
        }
      }
      return -1;

    }

    public int begin(){
      i = -1;
      return next();
    }

    public boolean end(){
      if (i < vertices()) {
        return false;
      }
      return true;
    }

  }
}
