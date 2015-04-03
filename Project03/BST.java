/*
* Project03
*
* Project 3
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Project 3
*
* Author: Nicholas Graham
*
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: April 2, 2015.
*/
//interface from lab 10 write up
public interface BST<T extends Comparable<T>> {
  public void insert(T x);
  public void delete(T x);
  public boolean lookup(T x);
  public void printPreOrder();
  public void printInOrder();
  public void printPostOrder();
}
