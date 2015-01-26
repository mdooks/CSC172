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
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: January 26, 2014.
*/

public class test {
  public static void main(String[] args){
    MyDoublyLinkedList t = new MyDoublyLinkedList();

    if(t.isEmpty()){
      System.out.println("The list is empty");
    }
    else{
      System.out.println("The list is not empty");
    }

    t.insert("h");
    t.insert("c");
    t.insert("n");
    t.insert("u");
    t.insert("a");
    t.insert("l");
    t.insert("1");
    t.insert("2");
    t.insert("3");

    t.insert("u");
    t.insert("a");
    t.insert("l");
    t.insert("1");

    t.printList();
    t.printListRev();

    if(t.lookup("h")){
      System.out.println("There is an h in the list");
    }
    else{
      System.out.println("There is no h in the list");
    }
    if(t.lookup("12")){
      System.out.println("There is an 12 in the list");
    }
    else{
      System.out.println("There is no 12 in the list");
    }

    t.delete("2");
    t.printList();
    t.delete("3");
    t.printList();
    t.delete("1");
    t.printList();
    t.delete("a");
    t.printList();
    t.printListRev();

    System.out.println(t.isEmpty());
  }
}
