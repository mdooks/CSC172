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

public class MyDoublyLinkedList<AnyType> implements DoublyLinkedList<AnyType> {
  private MyDoubleNode<AnyType> start;
  private MyDoubleNode<AnyType> end;

  public MyDoublyLinkedList(){ //initalize the start and end node and have them point to each other
    start = new MyDoubleNode<AnyType>();
    end = new MyDoubleNode<AnyType>();
    start.next = end;
    end.prev = start;
  }
  public void insert(AnyType x){
    /*
    * Since the lookup function has O(n) that is factored in, and the return is just
    * a constant, so that part is O(n). the next few lines are constants so the end
    * result is just O(n), unless we are suppose to ignore the lookup() part of this
    * in our calculations, in which case, it is a constant time function.
    */
    if (lookup(x)){ //has O(n)
      return;
    }
    //rest is all constant
    MyDoubleNode<AnyType> e = end;
    MyDoubleNode<AnyType> in = new MyDoubleNode<AnyType>();
    in.data = x;
    in.prev = e.prev;
    in.next = e;
    e.prev.next = in;
    e.prev = in;
  }
/*  public void delete(AnyType x){
    if (lookup(x)){ //check to see the element is in there
      AnyType ans = start.next.data;
      start.next.next.prev = start;
      start.next = start.next.next;
      MyDoubleNode<AnyType> e = start;
      while(e.next.next != null){ //run through the elements
        if (e.next.data == x){ //ounce found remove it
          e.next.next.prev = e;
          e.next = e.next.next;
          return;
        }
        e = e.next;
      }
    }
  }*/
  public void delete(){
    start.next.next.prev = start;
    start.next = start.next.next;
  }

  public boolean lookup(AnyType x){
    MyDoubleNode<AnyType> e = start;
    while (e.next != null){ //run through the elements and check the data
      if (e.next.data == x){
        return true;
      }
      e = e.next;
    }
    return false;
  }
  public boolean isEmpty(){
    return (start.next.next == null);
  }
  public void printList(){
    MyDoubleNode<AnyType> e = start;
    while (e.next.next != null){ //run through the elements and print each one
      System.out.printf(e.next.data + ", ");
      e = e.next;
    }
    System.out.println();
  }
  public void printListRev(){
    MyDoubleNode<AnyType> e = end;
    while (e.prev.prev != null){ //run through the elements backwards printing each one
      System.out.printf(e.prev.data + ", ");
      e = e.prev;
    }
    System.out.println();
  }
  public AnyType firstItem (){
    return start.next.data;
  }
}
