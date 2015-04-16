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
public class MyGraph {
  public static void main(String[] args){
    Vertex z = new Vertex(0);
    Vertex o = new Vertex(1);
    Vertex t = new Vertex(2);
    Vertex th = new Vertex(3);
    Vertex f = new Vertex(4);
    Vertex fi = new Vertex(5);
    Vertex s = new Vertex(6);
    Vertex se = new Vertex(7);

    
    Graph test1 = new Graph(7, true);

    Edge one = new Edge(z, th);
    Edge two = new Edge(z, o);
    Edge thr = new Edge(z, th);
    Edge fou = new Edge(o, f);
    Edge fiv = new Edge(t, z);
    Edge six = new Edge(t, fi);
    Edge sev = new Edge(th, t);
    Edge eig = new Edge(th, f);
    Edge nin = new Edge(f, s);
    Edge ten = new Edge(s, fi);
    Edge ele = new Edge(t, fi);
    Edge twe = new Edge(th, s);

    test1.insert(one);
    test1.insert(two);
    test1.insert(thr);
    test1.insert(fou);
    test1.insert(fiv);
    test1.insert(six);
    test1.insert(sev);
    test1.insert(eig);
    test1.insert(nin);
    test1.insert(ten);
    test1.insert(ele);
    test1.insert(twe);

    test1.show();

    System.out.println();

  }
}
