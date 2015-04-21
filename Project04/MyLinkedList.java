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

public class MyLinkedList implements SimpleLinkedList {
  private Node start;

  public MyLinkedList(){
    start = new Node(); //set up the starting Node
  }

  public void insert(Node x){ //insert item at the end of the list
    /*
    * Since the lookup function has O(n) that is factored in, and the return is just
    * a constant, so that part is O(n). the next few lines are constants until the
    * while loop, which also is a O(n), and the final line is a constant, so the
    * final is O(n) + O(n) = O(n)
    */
    if (lookup(x)){ // O(n) lloks up if the item is already in the list, if it is, does nothing
      return;
    }
    Node e = start;
    Node in = x; //sets up new Node to add to list
    while (e.connection != null){ //O(n) finds the end of the list
      e = e.connection;
    }
    e.connection = in; //adds the new node.
  }

  public void delete(Node x){ //remove an item from the list
    if (lookup(x)){ //find if its in the list
      Node e = start;
      while (e.connection != null){ //run through the list
        if (e.connection.name.equals(x.name)){ //once it is found
          e.connection = e.connection.connection; //remove the item by making the previus element point to the element after the removed element
          return; //end the search because the item can only be in the list once
        }
        e = e.connection; //if it wasn't found, move to the next item
      }
    }
  }

  public boolean lookup(Node x){ //originaly returned AnyType, not bool.
    Node e = start;
    while (e.connection !=null){ //run through the list
      if (e.connection.name.equals(x.name)){ //it the data is found return true
        return true;
      }
      e = e.connection;
    }
    return false; //return false if not found
  }

  public Node getInfo(String x){ //originaly returned AnyType, not bool.
    Node e = start;
    while (e.connection !=null){ //run through the list
      if (e.connection.name.equals(x)){ //it the data is found return the node
        return e.connection;
      }
      e = e.connection;
    }
    return null; //return null if not found
  }

  public boolean isEmpty(){ //check if the list is empty
    return (start.connection == null); //if the next element after the starting one is null the list is empty
  }

  public void printList(){ //prints out the elements of the list
    Node e = start;
    while (e.connection != null){ //if the next item isn't empty (runs through the list)
      System.out.printf(e.connection.name + ", "); //print out the data for the next item
      e = e.connection;
    }
    System.out.println();
  }
}
