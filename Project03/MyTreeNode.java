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
//from lab writeup
public class MyTreeNode{
  public line data;
  public MyTreeNode leftChild;
  public MyTreeNode rightChild;
  public MyTreeNode parent;

  public MyTreeNode insertLine(MyTreeNode n, line in){
    if (n == null){
      n = new MyTreeNode();
      n.data = in;
      //System.out.println(n.data);
      return n;
    }
    else if (n.data.equals(in)){
      return n;
    }
    else if (!(Geometry.intersect(n.data, in).equals(new point(-10,-10)))){
      point inter = Geometry.intersect(n.data, in);
      System.out.println("intersect!");
      n.rightChild = insertLine(n.rightChild, new line (inter, in.end));
      n.rightChild.parent = n;
      n.leftChild = insertLine(n.leftChild, new line (in.start, inter));
      n.leftChild.parent = n;
    }
    else if(Geometry.ccw(n.data.start, in.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){
      n.rightChild = insertLine(n.rightChild, in);
      n.rightChild.parent = n;
    }
    else if(Geometry.ccw(n.data.start, in.start, n.data.end) == Geometry.direction.CLOCKWISE){
      n.leftChild = insertLine(n.leftChild, in);
      n.leftChild.parent = n;
    }
    else if(Geometry.ccw(n.data.start, in.start, n.data.end) == Geometry.direction.COLINEAR){
      n = new MyTreeNode();
      n.data = in;
      //System.out.println(n.data);
      return n;
    }
    else{
      return null;
    }

    return n;
  }
/*
  public MyTreeNode insert(MyTreeNode<T> n, T in){
    if (n == null){
      n = new MyTreeNode<T>();
      n.data = in;
    }

    else if (in.compareTo(n.data) > 0){
      n.rightChild = insert(n.rightChild, in);
      n.rightChild.parent = n;
    }
    else {
      n.leftChild = insert(n.leftChild, in);
      n.leftChild.parent = n;
    }

    return n;
  }

  */

  public void printInOrder(){
    if(leftChild !=null)
      leftChild.printInOrder();
    System.out.println(data);
    if (rightChild !=null)
      rightChild.printInOrder();
  }

  public void printPostOrder(){
    if(leftChild !=null)
      leftChild.printPostOrder();

    if (rightChild !=null)
      rightChild.printPostOrder();
    System.out.println(data);
  }
  public void printPreOrder(){
    System.out.println(data);
    if(leftChild !=null)
      leftChild.printPreOrder();

    if (rightChild !=null)
      rightChild.printPreOrder();
  }

  public MyTreeNode lookup(line x){
    if (this == null){
      return null;
    }
    else if (x.equals(data)){
      return this;
    }
    else if (Geometry.ccw(this.data.start, x.start, this.data.end) == Geometry.direction.COUNTERCLOCKWISE)
      return rightChild.lookup(x);
    else if (Geometry.ccw(this.data.start, x.start, this.data.end) == Geometry.direction.CLOCKWISE)
      return leftChild.lookup(x);

    return null;
  }

  public void pointCheck(MyTreeNode n, line x){

    if (n == null){
      System.out.println("They are in the same region");
    }
    else if (!(Geometry.intersect(x, n.data).equals(new point(-10,-10)))){
      System.out.println("These points are seperated by line: " + n.data);
    }
    else if (Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.ccw(x.end, n.data.start, n.data.end)){
      //System.out.println("Point Check: " + n.data);
      //System.out.println("They match!");
      if (Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){
        pointCheck(n.rightChild, x);
      }
      else if(Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.CLOCKWISE){
        pointCheck(n.leftChild, x);
      }
      else{
        System.out.println("These points both are on line: " + n.data);
      }
    }
    else {
      System.out.println("These points are seperated by line: " + n.data);
    }
  }

  public void pathDiff(MyTreeNode that){
    if (this.rightChild != null || this.leftChild != null){ //Should work for how I am using it, but not really an a great test...
      System.out.println("They are in the same area");
    }

  }
  /* -------------------------------------------------------
  public void delete(line x){
    if (x.equals(data)){

      if (leftChild == null && rightChild == null){
        if (parent.leftChild == this){
          parent.leftChild = null;
        }
        else{
          parent.rightChild = null;
        }
      }
      else if(leftChild == null){
        if (parent.leftChild == this){
          parent.leftChild = rightChild;
          if(rightChild !=null)
            rightChild.parent = parent;
        }
        else{
          parent.rightChild = rightChild;
          if(rightChild !=null)
            rightChild.parent = parent;
        }
      }
      else if(rightChild == null){
        if (parent.leftChild == this){
          parent.leftChild = leftChild;
          if(leftChild != null)
            leftChild.parent = parent;
        }
        else{
          parent.rightChild = leftChild;
          if(leftChild != null)
            leftChild.parent = parent;
        }
      }

      else{
        MyTreeNode e = LmostRchild();
        line temp = e.data;
        delete(e.data);
        data = temp;
      }
    }
    else if (x.compareTo(data) > 0 && rightChild != null)
      rightChild.delete(x);
    else if ((x.compareTo(data) < 0 && leftChild != null))
      leftChild.delete(x);
  }
  public MyTreeNode LmostRchild(){
    MyTreeNode e = rightChild;

    while (e.leftChild != null){
      e = e.leftChild;
    }
    return e;
  }

  ---------------------------------------------------------- */
}
