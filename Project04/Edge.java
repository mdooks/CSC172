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

public class Edge implements Comparable<Edge>{
  String name;
  String v;
  String w;
  double weight;

  public Edge(String n, String x, String y, double we){
    name = n;
    v = x;
    w = y;
    weight = we;
  }

  public int compareTo(Edge that){
    if(weight == that.weight){
      return 0;
    }
    else if (weight > that.weight){
      return 1;
    }
    else{
      return -1;
    }
  }
}
