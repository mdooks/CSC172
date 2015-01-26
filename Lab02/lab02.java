/*
* Lab2
*
* Lab 2
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Lab 2
*
* Author: Nicholas Graham
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: January 25, 2014.
*/

public class lab02<AnyType> implements SimpleLinkedList<AnyType> {
  private MyNode start;

  public lab02(){
    start = new MyNode();
  }

  public void insert(AnyType x){
    MyNode e = start.next;
    MyNode in = new MyNode();
    in.data = x;
    do {
    //while (e.next != null){
      if (e.data != null){
        e = e.next;
      }
      else {
        e = in;
        e = e.next;
      }
    }while (e != null);
  }

  public void delete(AnyType x){

  }

  public AnyType lookup(AnyType x){
    return x;
  }

  public boolean isEmpty(){
    if (start.next == null){
      return true;
    }
    else {
      return false;
    }
  }

  public void printlist(){
    MyNode e = start;
    while (e.next != null){
      System.out.println(e.next.data);
      e = e.next;
    }
  }
}
