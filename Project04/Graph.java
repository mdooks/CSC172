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
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: April 18, 2015.
*/

//Taken from lab 20, with code based off of code given in the textbook.

import java.io.File;
import java.util.Scanner;
import java.util.HashMap;
import java.util.LinkedList;
public class Graph {
  static Scanner in;
  private int vertexCount;
  private int edgeCount;

  HashMap<String, Node> nodeMap;

  MyLinkedList nodeList;

  boolean directed;
  private boolean adj[][];

  public double weight[][];
  public boolean known[];
  public double dist[];
  public int parent[];

  public Graph () {
    nodeMap = new HashMap<String, Node>();
    nodeList = new MyLinkedList();
    edgeCount = 0;
  }
  public Graph (int numV){
    adj = new boolean[numV][numV];
    weight = new double[numV][numV];
    edgeCount = 0;
    nodeMap = new HashMap<String, Node>();
    nodeList = new MyLinkedList();
  }
  public void setAdj(int numV){
    adj = new boolean[numV][numV];
    weight = new double[numV][numV];
  }
  public void setVertexCount(int v){
    vertexCount = v;
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
  public void insert(Edge e, double lb) {
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

  public void shortPath(Node a, Node b){
    if(a == b){
      System.out.println ("Those are the same point.");
    }

    else{
      dijksra(a);
      shortHelper(a, b);
      System.out.println();
    }
  }

  public void shortPath(String a, String b){
    if(a.equals(b)){
      System.out.println ("Those are the same point.");
    }

    else{
      Node aa = nodeMap.get(a);
      Node bb = nodeMap.get(b);
      dijksra(aa.num);
      shortHelper(aa, bb);
      System.out.println();
    }
  }

  public void shortHelper(Node a, Node b){
    if(a.name.equals(b.name)){
      System.out.print(a.name + ", ");
      return;
    }
    else if(b == null){
      System.out.println("There is no path");
      return;
    }
    else if (b.parent == null){
      System.out.println("There is no path");
      return;
    }

    shortHelper(a, b.parent);
    //Node nb = nodeList.getInfo(b);
    System.out.print(b.name + ", ");
  }

  public static Graph createFromFile(String fileName){
    Graph g = new Graph();
    File f = new File(fileName);
    try{
      in = new Scanner(f);
    }catch(Exception e){
      System.out.println("File Not Found");
      return null;
    }
    in.useDelimiter("\\t|\\n");
    int i = 0;
    while(in.hasNext()){
      if (in.next().equals("r")){
        break;
      }
      else{
        String n = in.next();
        double lati = in.nextFloat();
        double longi = in.nextFloat();
        Node t = new Node(n, i, longi, lati);
        g.nodeMap.put(n, t);
        //g.nodeList.insert(t);
      }
      i++;
    }
    g.setAdj(i);
    g.setVertexCount(i);
    //g.nodeList.printList();
    //first r was read in so first edge is made outside loop
    String n = in.next();
    String d = in.next();
    String s = in.next();
    //System.out.println(n + " " + d + " " + s);
    Node first = g.nodeMap.get(d);
    Node second = g.nodeMap.get(s);
    double lb = getWeight(first, second);
    System.out.println(n + " " + d + " " + s + " " + lb);
    g.insert(new Edge(n, first.num, second.num), lb);
    while (in.hasNext()){
      String r = in.next(); //reads in and ignores the 'r'
      String nam = in.next();
      String i1 = in.next();
      String i2 = in.next();
      //System.out.println(nam + " " + i1 + " " + i2);
      Node n1 = g.nodeMap.get(i1);
      Node n2 = g.nodeMap.get(i2);
      double lbs = getWeight(n1, n2);
      g.insert(new Edge(nam, n1.num, n2.num), lbs);
    }
    //g.show();
    return g;
  }

  public void dijksra (int v){ //O(n^2)
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
    for (int m = 0; m < vertices(); m++){ //O(n)
      int t = smallestDist();//O(n)
      //System.out.println("t: " + t);
      if (t == -1){
        return;
      }
      known[t] = true;
      for(int j = 0; j < vertices(); j++){ //O(n)

        if (connected(t,j)){
          if(!(known[j])){
            double cvw = weight[t][j];
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
  public void dijksra (Node v){ //O(n^2)
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
    for (int m = 0; m < vertices(); m++){ //O(n)
      int t = smallestDist();//O(n)
      //System.out.println("t: " + t);
      if (t == -1){
        return;
      }
      known[t] = true;
      for(int j = 0; j < vertices(); j++){ //O(n)

        if (connected(t,j)){
          if(!(known[j])){
            double cvw = weight[t][j];
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

  public int smallestDist(){ //O(2n)
    int ans = firstNotKown();//O(n)
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

  public int firstNotKown(){ //O(n)
    for (int i = 0; i<vertices(); i++){
      if(!(known[i]) && !(dist[i] == Double.POSITIVE_INFINITY )){
        return i;
      }
    }
    //System.out.println("Woah there, first not known broke");
    return -1;
  }

  public static double getWeight(Node a, Node b){
    double w = 0;
    double x = b.lat - a.lat;
    double y = b.lon - a.lon;
    double c2 = x*x + y*y;
    w = Math.sqrt(c2);
    //System.out.println(a.name + " " + b.name + " " + w);
    return w;
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
