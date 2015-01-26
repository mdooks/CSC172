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
    if (lookup(x)){
      return;
    }
    MyNode e = start;
    MyNode in = new MyNode();
    in.data = x;
    while (e.next != null){
      e = e.next;
    }
    e.next = in;
  }

  public void delete(AnyType x){
    if (lookup(x)){
      MyNode e = start;
      while (e.next != null){
        if (e.next.data == x){
          e.next = e.next.next;
          return;
        }
        e = e.next;
      }
    }
  }

  public boolean lookup(AnyType x){
    MyNode e = start;
    while (e.next !=null){
      if (e.next.data == x){
        return true;
      }
      e = e.next;
    }
    return false;
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
