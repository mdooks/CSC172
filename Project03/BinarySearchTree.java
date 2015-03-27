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
public class BinarySearchTree<T extends Comparable<T>> implements BST<T>{
  private MyTreeNode<T> root;

  public BinarySearchTree(){
    root = new MyTreeNode<T>();
  }

  public void insert(T in){
    if ((lookup(in))){
      return;
    }
    if (root.data == null){
      root.data = in;
    }
    else
      root.insert(root, in);
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
  public void delete(T x){
    if (!(lookup(x)) || root == null){
      return;
    }
    else{
      root.delete(x);
    }
  }
  public boolean lookup(T x){
    if (root.data !=null)
      if(root.lookup(x))
        return true;

    return false;
  }

}
