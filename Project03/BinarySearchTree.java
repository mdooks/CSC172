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

  public boolean sameRegion(point a, point b){
      if (a.equals(new point(-10, -10)) || b.equals(new point(-10, -10))){
        System.out.println("One of the points was invalid, cannot calculate");
        return false;
      }
      else if (root.data == null){
        System.out.println("They are in the same region.");
        return true;
      }
      else {
        line ab = new line(a, b);
        root.pointCheck(root, ab);
      }
      return true;
  }

  public void clear (){
    root.data = null;
    root.rightChild = null;
    root.leftChild = null;
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
  -----------------------------------------*/
  public MyTreeNode lookup(line x){
    if (root.data !=null)
      return root.lookup(x);

    return null;
  }

}
