/*
* Lab10
*
* Lab 10
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Lab 10
*
* Author: Nicholas Graham
*
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: Febuary 26, 2015.
*/
public class MyBinarySearchTree {
  public static void main(String[] args){
    BinarySearchTree<String> b = new BinarySearchTree<String>();
    String a = "p";
    String d = "n";
    String c = "m";
    b.insert(a);
    b.insert(d);
    b.insert(c);
    b.insert("j");
    b.insert("q");
    b.insert("c");
    b.insert("r");
    b.insert("y");
    b.insert("o");
    b.insert("f");
    b.insert("e");
    b.printPreOrder();
    System.out.println();
    b.printInOrder();
    System.out.println();
    b.printPostOrder();
    System.out.println(b.lookup("j"));
    b.delete("n");
    b.delete("o");
    b.delete("j");
    b.delete("f");
    b.delete("q");
    b.delete("p");
    b.delete("m");
    b.delete("c");
    b.delete("r");
    b.printInOrder();
    System.out.println();
    b.printPreOrder();
  }
}
