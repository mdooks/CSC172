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

  public boolean known[];
  public double dist[];
  public int parent[];

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
      if (adj[e.v][e.w] == false){
        adj[e.v][e.w] = true;
        edgeCount++;
      }
    }
    else{
      if(adj[e.v][e.w] == false){
        adj[e.v][e.w] = true;
        edgeCount++;
      }
      if(adj[e.w][e.v] == false)
      adj[e.w][e.v] = true;
      edgeCount++;
    }
  }

  public void delete(Edge e){
    if (isDirected()){
      if (adj[e.v][e.w] == true){
        adj[e.v][e.w] = false;
        edgeCount--;
      }
    }
    else{
      if(adj[e.v][e.w] == true){
        adj[e.v][e.w] = false;
        edgeCount--;
      }
      if(adj[e.w][e.v] == true)
      adj[e.w][e.v] = false;
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

  public void unweighted (int s){
    known = new boolean[vertices()];
    dist = new double[vertices()];
    parent = new int[vertices()];
    for (int i = 0; i< vertices(); i++){
      known[i] = false;
      dist[i] = Double.POSITIVE_INFINITY;
    }

    dist[s] = 0;

    for(int currDist = 0; currDist< vertices(); currDist++){
      for (int j = 0; j<vertices(); j++){
        if(!known[j] && dist[j] == currDist){
          known[j] = true;

          for(int k = 0; k <vertices(); k++){
            if(adj[j][k]){
              if(dist[k] == Double.POSITIVE_INFINITY){
                dist[k] = currDist + 1;
                parent[k] = j;
              }
            }
          }
        }
      }
    }

  }

  public void shortestPath(int a, int b){
    if (a == b){
      System.out.println("They Are the same Node");
    }
    else{
      unweighted(a);
      int p = b;

      while(p != a){
        System.out.println(p);
        p = parent[p];
      }
      System.out.println(a);
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
      g.insert(new Edge(v,w));
    }

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
