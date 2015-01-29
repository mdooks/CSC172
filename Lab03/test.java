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

public class test {
  public static void main(String[] args){
    //sets up the linked list, uses string to test, but any class can be substituted.
    MyDoublyLinkedList<String> t = new MyDoublyLinkedList<String>();

    if(t.isEmpty()){ //check if the list is empty
      System.out.println("The list is empty");
    }
    else{
      System.out.println("The list is not empty");
    }

    //test the insert function
    t.insert("h");
    t.insert("c");
    t.insert("n");
    t.insert("u");
    t.insert("a");
    t.insert("l");
    t.insert("1");
    t.insert("2");
    t.insert("3");

    //the following will not insert because they are already in the list
    t.insert("u");
    t.insert("a");
    t.insert("l");
    t.insert("1");

    //print the list, and then print the list in reverse
    t.printList();
    t.printListRev();

    //test the lookup function
    if(t.lookup("h")){
      System.out.println("There is an h in the list");
    }
    else{
      System.out.println("There is no h in the list");
    }
    if(t.lookup("12")){ //1 & 2 are in the list, but 12 is not
      System.out.println("There is an 12 in the list");
    }
    else{
      System.out.println("There is no 12 in the list");
    }

    //test the delete function, printing the list after each delete
    t.delete("2");
    t.printList();
    t.delete("3");
    t.printList();
    t.delete("1");
    t.printList();
    t.delete("a");
    t.printList();
    t.printListRev();

    if(t.isEmpty()){ //check again if the list is empty
      System.out.println("The list is empty");
    }
    else{
      System.out.println("The list is not empty");
    }
  }
}
