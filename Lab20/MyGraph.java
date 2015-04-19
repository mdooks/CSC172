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

    Graph test1 = Graph.createFromFile("Figure9-20.txt");
    test1.shortPath(0, 4);
    test1.shortPath(0, 5);
    test1.shortPath(2, 4);
    test1.shortPath(3, 1);
    test1.shortPath(1, 5);

    System.out.println();

    Graph test2 = Graph.createFromFile("MyExample1.txt");
    test2.shortPath(0, 4);
    test2.shortPath(2, 4);
    test2.shortPath(1, 5);
    test2.shortPath(1, 8);
    test2.shortPath(1, 9);
    test2.shortPath(1, 7);

    System.out.println();

    Graph test3 = Graph.createFromFile("MyExample2.txt");
    test3.shortPath(0, 4);
    test3.shortPath(2, 4);
    test3.shortPath(1, 5);
    test3.shortPath(1, 8);
    test3.shortPath(1, 9);
    test3.shortPath(1, 11);
    test3.shortPath(11, 0);

    System.out.println();

    Graph test4 = Graph.createFromFile("MyExample3.txt");
    test4.shortPath(0, 4);
    test4.shortPath(2, 4);
    test4.shortPath(1, 5);
    test4.shortPath(1, 8);
    test4.shortPath(1, 9);
    test4.shortPath(1, 10);
    test4.shortPath(10, 0);
    test4.shortPath(1, 6);
    test4.shortPath(3, 6);
    


  }
}
