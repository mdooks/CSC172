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
    Graph test1 = Graph.createFromFile("Figure9-10.txt");

    test1.show();
    test1.shortestPath(0,2);
    test1.shortestPath(1,5);
    test1.shortestPath(5,1);

    System.out.println();

    Graph test2 = Graph.createFromFile("Figure9-17.txt");

    test2.show();
    test2.shortestPath(0,2);
    test2.shortestPath(8,1);
    test2.shortestPath(5,1);

    Graph test3 = Graph.createFromFile("Figure9-62.txt");

    System.out.println();

    test3.show();
    test3.shortestPath(0,4);
    test3.shortestPath(0,2);
    test3.shortestPath(2,0);
    test3.shortestPath(4, 1);

    System.out.println();

    Graph test4 = Graph.createFromFile("MyExample1.txt");

    test4.show();
    test4.shortestPath(0,4);
    test4.shortestPath(0,2);
    test4.shortestPath(5,0);
    test4.shortestPath(4,1);

    System.out.println();

    Graph test5 = Graph.createFromFile("MyExample2.txt");

    test5.show();
    test5.shortestPath(0,4);
    test5.shortestPath(0,7);
    test5.shortestPath(5,0);
    test5.shortestPath(8,7);
    test5.shortestPath(8,2);

    System.out.println();

    Graph test6 = Graph.createFromFile("MyExample3.txt");

    test6.show();
    test6.shortestPath(0,4);
    test6.shortestPath(0,8);
    test6.shortestPath(5,0);
    test6.shortestPath(8,18);
    test6.shortestPath(8,2);

  }
}
