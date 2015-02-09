/*
* Lab3
*
* Lab 3
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Lab 3
*
* Author: Nicholas Graham
*
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: January 29, 2014.
*/

public interface DoublyLinkedList<AnyType> {
  public void insert(AnyType x);
  public void delete();
  public boolean lookup(AnyType x);
  public boolean isEmpty();
  public void printList();
  public void printListRev();
}
