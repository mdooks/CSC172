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
    Graph test1 = new Graph(7, true);

    Edge one = new Edge(0, 3);
    Edge two = new Edge(0, 1);
    Edge thr = new Edge(1, 3);
    Edge fou = new Edge(1, 4);
    Edge fiv = new Edge(2, 0);
    Edge six = new Edge(2, 5);
    Edge sev = new Edge(3, 2);
    Edge eig = new Edge(3, 4);
    Edge nin = new Edge(4, 6);
    Edge ten = new Edge(6, 5);
    Edge ele = new Edge(3, 5);
    Edge twe = new Edge(3, 6);

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

    Graph test2 = new Graph(5, false);
    Edge a = new Edge(0, 1);
    Edge b = new Edge(0, 3);
    Edge c = new Edge(0, 4);
    Edge d = new Edge(1, 0);
    Edge e = new Edge(1, 3);
    Edge f = new Edge(1, 2);
    Edge g = new Edge(2, 1);
    Edge h = new Edge(2, 3);
    Edge i = new Edge(2, 4);
    Edge j = new Edge(3, 0);
    Edge k = new Edge(3, 1);
    Edge l = new Edge(3, 2);
    Edge m = new Edge(4, 0);
    Edge o = new Edge(4, 2);

    test2.insert(a);
    test2.insert(b);
    test2.insert(c);
    test2.insert(d);
    test2.insert(e);
    test2.insert(f);
    test2.insert(g);
    test2.insert(h);
    test2.insert(i);
    test2.insert(j);
    test2.insert(k);
    test2.insert(l);
    test2.insert(m);
    test2.insert(o);

    test2.show();

  }
}
