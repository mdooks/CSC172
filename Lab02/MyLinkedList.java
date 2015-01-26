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

public class MyLinkedList<AnyType> implements SimpleLinkedList<AnyType> {
  private MyNode start;

  public MyLinkedList(){
    start = new MyNode(); //set up the starting Node
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
    MyNode e = start;
    MyNode in = new MyNode(); //sets up new Node to add to list
    in.data = x;
    while (e.next != null){ //O(n) finds the end of the list
      e = e.next;
    }
    e.next = in; //adds the new node.
  }

  public void delete(AnyType x){ //remove an item from the list
    if (lookup(x)){ //find if its in the list
      MyNode e = start;
      while (e.next != null){ //run through the list
        if (e.next.data == x){ //once it is found
          e.next = e.next.next; //remove the item by making the previus element point to the element after the removed element
          return; //end the search because the item can only be in the list once
        }
        e = e.next; //if it wasn't found, move to the next item
      }
    }
  }

  public boolean lookup(AnyType x){ //originaly returned AnyType, not bool.
    MyNode e = start;
    while (e.next !=null){ //run through the list
      if (e.next.data == x){ //it the data is found return true
        return true;
      }
      e = e.next;
    }
    return false; //return false if not found
  }

  public boolean isEmpty(){ //check if the list is empty
    if (start.next == null){ //if the next element after the starting one is null the list is empty
      return true;
    }
    else {
      return false;
    }
  }

  public void printlist(){ //prints out the elements of the list
    MyNode e = start;
    while (e.next != null){ //if the next item isn't empty (runs through the list)
      System.out.printf(e.next.data + ", "); //print out the data for the next item
      e = e.next;
    }
    System.out.println();
  }
}
