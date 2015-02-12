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

public class MyStack<AnyType> implements Stack<AnyType> {
  private MyNode<AnyType> start;

  public MyStack(){
    start = new MyNode<AnyType>(); //set up the starting Node
  }

  public void insert(AnyType x){ //insert item at the end of the list
    /*
    * Since the lookup function has O(n) that is factored in, and the return is just
    * a constant, so that part is O(n). the next few lines are constants until the
    * while loop, which also is a O(n), and the final line is a constant, so the
    * final is O(n) + O(n) = O(n)
    */
   if (lookup(x)){ // O(n) lloks up if the item is already in the list, if it is, does nothing
      return;
    }
    //MyNode<AnyType> e = start;
    MyNode<AnyType> in = new MyNode<AnyType>(); //sets up new Node to add to list
    in.data = x;
    in.next = start.next;
    start.next = in; //adds the new node.
  }
  public AnyType pop() {
    if (! isEmpty()){
      AnyType ans = start.next.data;
      start.next = start.next.next;
      return ans;
    }
    return null;

  }
  public void push(AnyType x){
    MyNode<AnyType> in = new MyNode<AnyType>(); //sets up new Node to add to list
    in.data = x;
    in.next = start.next;
    start.next = in; //adds the new node.
  }

  public AnyType peek(){
    if (! isEmpty()){
      return start.next.data;
    }
    return null;
  }

  public void delete(){
    start.next = start.next.next;
    return;
  }

  public boolean lookup(AnyType x){ //originaly returned AnyType, not bool.
    MyNode<AnyType> e = start;
    while (e.next !=null){ //run through the list
      if (e.next.data == x){ //it the data is found return true
        return true;
      }
      e = e.next;
    }
    return false; //return false if not found
  }

  public boolean isEmpty(){ //check if the list is empty
    return (start.next == null); //if the next element after the starting one is null the list is empty
  }

  public void printList(){ //prints out the elements of the list
    MyNode<AnyType> e = start;
    while (e.next != null){ //if the next item isn't empty (runs through the list)
      System.out.printf(e.next.data + ", "); //print out the data for the next item
      e = e.next;
    }
    System.out.println();
  }

  public AnyType firstItem(){
    return start.next.data;
  }
}
