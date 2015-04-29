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
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class Graph {
  static Scanner in;
  private int vertexCount;
  private int edgeCount;
  PriorityQueue<Node> dijkstasQueue;

  HashMap<String, Node> nodeMap;
  HashMap<String, Edge> edgeMap;

  boolean directed;
  private boolean adj[][];
  double dist;

  GraphNode adjNode[];
  HashMap<String, GraphNode> adjNodeMap;

  public double weight[][];

  public Graph () {
    nodeMap = new HashMap<String, Node>();
    edgeMap = new HashMap<String, Edge>();
    adjNodeMap = new HashMap<String, GraphNode>();
    dijkstasQueue = new PriorityQueue<Node>();
    edgeCount = 0;
  }
  public Graph (int numV){
    adj = new boolean[numV][numV];
    weight = new double[numV][numV];
    edgeCount = 0;
    nodeMap = new HashMap<String, Node>();
    edgeMap = new HashMap<String, Edge>();
    adjNodeMap = new HashMap<String, GraphNode>();
    dijkstasQueue = new PriorityQueue<Node>();
  }

  public void buildAdjNode(int numV){
    adjNode = new GraphNode[numV];
    int i = 0;
    for(String k : nodeMap.keySet()){
      if(k != null){
        adjNode[i] = new GraphNode(k);
        //System.out.println(adjNode[i].id);
        i++;
      }
    }
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

  public void insertList(String a, String b, double lb){
    GraphNode g = adjNodeMap.get(a);
    if(g == null){
      adjNodeMap.put(a, new GraphNode(a));
      g = adjNodeMap.get(a);
    }
    g.insert(g,b,lb);

    g = adjNodeMap.get(b);
    if(g == null){
      adjNodeMap.put(b, new GraphNode(b));
      g = adjNodeMap.get(b);
    }
    g.insert(g,a,lb);
  }
  /*
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
  }*/

  public boolean connected (int node1, int node2){
    return adj[node1][node2];
  }
  public boolean connected (Node node1, Node node2){

    GraphNode t = adjNodeMap.get(node1.name);
    if (t == null){
      return false;
    }
    return t.lookup(t, node2.name);

  }

  public double getNodeWeight (Node node1, Node node2){
    GraphNode t = adjNodeMap.get(node1.name);
    if (t == null){
      return 100000;//should never happen
    }
    return t.lookupWeight(t, node2.name);
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
    dist = 0;
    if(a.equals(b)){
      System.out.println ("Those are the same point.");
    }

    else{
      dijksra(a, b);
      shortHelper(a, b);
      System.out.println();
    }
  }

  public void shortPath(String a, String b){
    dist = 0;
    if(a.equals(b)){
      System.out.println ("Those are the same point.");
    }

    else{
      Node aa = nodeMap.get(a);
      Node bb = nodeMap.get(b);
      dijksra(aa, bb);
      shortHelper(aa, bb);
      System.out.println(" " + bb.distance*69 + " miles");
    }
  }

  public void parentPrinter(){
    for(Node n : nodeMap.values()){
      System.out.println(n.parent);
    }
  }

  public void shortHelper(Node a, Node b){
    if(a.name.equals(b.name)){
      System.out.print(a.name + ", ");
      dist = a.distance;
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
    //dist = dist + b.distance;
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
    g.setVertexCount(i);
    //g.buildAdjNode(i);
    //System.out.println("First read works: " + i);
    //g.setAdj(i);
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
    //System.out.println(n + " " + d + " " + s + " " + lb);
    g.insertList(d, s, lb);
    //System.out.println(n + " " + d + " " + s + " " + lb);
    while (in.hasNext()){
      String r = in.next(); //reads in and ignores the 'r'
      String nam = in.next();
      String i1 = in.next();
      String i2 = in.next();
      //System.out.println(nam + " " + i1 + " " + i2);
      Node n1 = g.nodeMap.get(i1);
      Node n2 = g.nodeMap.get(i2);
      double lbs = getWeight(n1, n2);
      g.insertList(i1, i2, lbs);
      g.edgeMap.put(nam, new Edge(nam, i1, i2, lbs));
    }
    //g.show();

    return g;
  }

  /*public void dijksra (int v){ //O(n^2)
    known = new boolean[vertices()];
    dist = new double[vertices()];
    parent = new String[vertices()];
    for (int i = 0; i< vertices(); i++){ //O(n)
      known[i] = false;
      dist[i] = Double.POSITIVE_INFINITY;
      parent[i] = null; //set a value that can not be a node
    }

    dist[v] = 0;
    //parent[v] = v; //UNDO!
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
              //parent[j] = t; //UNDO!!
              //known[j] = true;
            }
          }

        }
      }
    }
  }*/

  public void dijksra (Node v, Node w){ //O(n^2)
    //known = new boolean[vertices()];
    //dist = new double[vertices()];
    //parent = new int[vertices()];

    /* //Doing in the node setup, should be fine
    for (Node n : nodeMap.values()){ //O(n)
      if(n != null){
        n.known = false;
        n.distance = Double.POSITIVE_INFINITY;
        n.parent = null;
        //System.out.println(n.known);
      }
    }
    */
    v.distance = 0;
    v.parent = v;
    dijkstasQueue.add(v);

    //Node ttt = nodeMap.get(v.name);
    //System.out.println(ttt.distance);
    //known[v] = true;

    //while(isUnknown())
    int i = 0;
    while (dijkstasQueue.size() != 0){ //O(n)
      if(w.known){
        return;
      }
      //System.out.print(i + ": ");
      i++;

      Node t = dijkstasQueue.poll();//O(n)

      //System.out.println("t: " + t.name);
      if (t == null){
        System.out.println("Whoop went null");
        return;
      }
      /*else if (t.equals(w)){
        return;
      }*/
      //System.out.println(m + "mhm");
      //System.out.println(t.known);
      t.known = true;
      //System.out.println(t.known);
      long s = System.currentTimeMillis();
      GraphNode l = adjNodeMap.get(t.name);
      GraphNode[] cons = l.getConnections();
      for(GraphNode c : cons){ //O(n) //I THINK I CAN BRING THIS DOWN!
        Node j = nodeMap.get(c.id);
        if (j != null){
          //System.out.print(j.name + ", ");
          if (!(j.known)){
            //System.out.println(j.name + ", true");
              double cvw = getNodeWeight(t,j);
              //System.out.println(dist[t] + cvw);
              if(t.distance + cvw < j.distance){
                j.distance = t.distance + cvw;
                j.parent = t;
                dijkstasQueue.add(j);
                //known[j] = true;
              }
          }
        }
      }
      long e = System.currentTimeMillis();
      //System.out.println(e-s);
    }
  }

  /*public boolean isUnknown(){
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
  }*/

  public Node smallestDistNode(){ //O(2n)
    Node ans = firstNotKnownNode();//O(n)
    //System.out.println(ans + ", smallest dist.." );
    if (ans == null){
      //System.out.println("ans is null");
      return ans;
    }
    //System.out.println(ans);
    for (Node n : nodeMap.values()){

      if(n.distance < ans.distance){
        //System.out.println("i update: " + i);
        if (!(n.known)){

          ans = n;
        }
      }
    }
    //System.out.println("Smallest was: " + ans.name);
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

  /*public int firstNotKown(){ //O(n)
    for (int i = 0; i<vertices(); i++){
      if(!(known[i]) && !(dist[i] == Double.POSITIVE_INFINITY )){
        return i;
      }
    }
    //System.out.println("Woah there, first not known broke");
    return -1;
  }*/

  public Node firstNotKnownNode(){ //O(n)
    for (Node n : nodeMap.values()){

      if (n != null){
        /*System.out.println(n.distance);
        System.out.println("Node Test!");
        if (!(n.known)){
          System.out.println("Known works");
        }
        if (!(n.distance == Double.POSITIVE_INFINITY )){
          System.out.println("distance works");
        }*/
        if(!(n.known) && !(n.distance == Double.POSITIVE_INFINITY )){
          //System.out.println("returning " + n.name + " " + n.distance);
          return n;
        }
      }
    }
    System.out.println("Woah there, first not known broke");
    return null;
  }

  public ArrayList<Edge> Kruskal (List<Edge> edge, int numVert){ //based off of sudo code from the book
    DisjSets ds = new DisjSets(numVert);
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>(edge);
    ArrayList<Edge> mst = new ArrayList<>();

    while(mst.size() != numVert - 1){
      Edge e = pq.poll();
      SetNode w = ds.find(e.w);
      SetNode v = ds.find(e.v);

      if (w.equals(v)){
        mst.add(e);
        ds.union(w.id,v.id);
      }
    }
    return mst;

  }

  public static double getWeight(Node a, Node b){
    double w = 0;
    double x = Math.abs(b.lat) - Math.abs(a.lat);
    double y = Math.abs(b.lon) - Math.abs(a.lon);
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
