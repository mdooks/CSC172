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
public class BinarySearchTree{
  private MyTreeNode root;

  public BinarySearchTree(){
    root = new MyTreeNode();
  }
  public MyTreeNode getRoot(){
    return root;
  }
  public void insert(line in){
    if (root.data == null){
      root.data = in;
    }
    else{
      root.insertLine(root, in);
    }
  }

  public void printPreOrder(){
    if (root.data != null)
      root.printPreOrder();
  }

  public void printInOrder(){
    if (root.data != null)
      root.printInOrder();
  }
  public void printPostOrder(){
    if(root.data != null)
      root.printPostOrder();
  }
  /*----------------------------------------
  public void delete(line x){
    if (!(lookup(x)) || root == null){
      return;
    }
    else{
      root.delete(x);
    }
  }
  public boolean lookup(line x){
    if (root.data !=null)
      if(root.lookup(x))
        return true;

    return false;
  }
  -----------------------------------------*/
}
