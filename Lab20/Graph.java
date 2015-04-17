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

  public int weight[][];
  public boolean known[];
  public double dist[];
  public int parent[];

  public Graph (int numV, boolean d){
    vertexCount = numV;
    directed = d;
    adj = new boolean[numV][numV];
    weight = new int[numV][numV];
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
  public void insert(Edge e, int lb) {
    if (isDirected()){
      if (adj[e.v][e.w] == false){
        adj[e.v][e.w] = true;
        weight[e.v][e.w] = lb;
        edgeCount++;
      }
    }
    else{
      if(adj[e.v][e.w] == false){
        adj[e.v][e.w] = true;
        weight[e.v][e.w] = lb;
        edgeCount++;
      }
      if(adj[e.w][e.v] == false)
      adj[e.w][e.v] = true;
      weight[e.w][e.v] = lb;
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

  public void shortPath(int a, int b){
    if(a == b){
      System.out.println ("Those are the same point.");
    }

    else{
      dijksra(a);
      shortHelper(a, b);
      System.out.println();
    }
  }

  public void shortHelper(int a, int b){
    if(a == b){
      System.out.print(a + ", ");
      return;
    }
    else if(b == -1){
      System.out.println("There is no path");
      return;
    }
    else if (parent[b] == -1){
      System.out.println("There is no path");
      return;
    }

    shortHelper(a, parent[b]);
    System.out.print(b + ", ");
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
      g.insert(new Edge(v,w), we);
    }
    g.show();
    return g;
  }

  public void dijksra (int v){
    known = new boolean[vertices()];
    dist = new double[vertices()];
    parent = new int[vertices()];
    for (int i = 0; i< vertices(); i++){ //O(n)
      known[i] = false;
      dist[i] = Double.POSITIVE_INFINITY;
      parent[i] = -1; //set a value that can not be a node
    }

    dist[v] = 0;
    parent[v] = v;
    //known[v] = true;

    //while(isUnknown())
    for (int m = 0; m < vertices(); m++){
      /*for (boolean b : known){
        System.out.print(b +" ");
      }
      System.out.println();
      for (double d : dist){
        System.out.print(d+ " ");
      }
      System.out.println();
      for (int p : parent){
        System.out.print(p + " ");
      }
      System.out.println();
      */
      int t = smallestDist();
      //System.out.println("t: " + t);
      if (t == -1){
        return;
      }
      known[t] = true;
      for(int j = 0; j < vertices(); j++){

        if (connected(t,j)){
          if(!(known[j])){
            int cvw = weight[t][j];
            //System.out.println(dist[t] + cvw);
            if(dist[t] + cvw < dist[j]){
              dist[j] = dist[t] + cvw;
              parent[j] = t;
              //known[j] = true;
            }
          }

        }
      }
    }
  }

  public boolean isUnknown(){
    for (double d : dist){
      if (d == Double.POSITIVE_INFINITY){
        return true;
      }
    }
    return false;
  }

  public int smallestDist(){
    int ans = firstNotKown();
    if (ans == -1){
      return ans;
    }
    //System.out.println(ans);
    for (int i = 0; i<vertices(); i++){

      if(dist[i] < dist[ans]){
        //System.out.println("i update: " + i);
        if (!(known[i])){

          ans = i;
        }
      }
    }
    return ans;
  }
 /*
  public int smallestDist(){
    for (int i = 0; i<vertices(); i++){
      if(!(known[i])){
        return i;
      }
    }
    return -1;
  }*/

  public int firstNotKown(){
    for (int i = 0; i<vertices(); i++){
      if(!(known[i]) && !(dist[i] == Double.POSITIVE_INFINITY )){
        return i;
      }
    }
    //System.out.println("Woah there, first not known broke");
    return -1;
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
