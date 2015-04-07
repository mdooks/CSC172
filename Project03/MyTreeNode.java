/*
* Project03
*
* Project 3
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Project 3
*
* Author: Nicholas Graham
*
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: April 2, 2015.
*/
//from lab 10 writeup
public class MyTreeNode{
  public line data;
  public MyTreeNode leftChild;
  public MyTreeNode rightChild;
  public MyTreeNode parent;

  public MyTreeNode insertLine(MyTreeNode n, line in){ //insert a line.
    if (n == null){ //null node, insert
      n = new MyTreeNode();
      n.data = in;
      return n;
    }
    else if (n.data.equals(in)){ //equivelent node found, break out.
      return n;
    }
    else if (!(Geometry.intersect(n.data, in).equals(new point(-10,-10)))){ //if they intersect, both sides
      point inter = Geometry.intersect(n.data, in);
      if(Geometry.ccw(in.start, n.data.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){
        n.rightChild = insertLine(n.rightChild, new line (inter, in.end));
        n.rightChild.parent = n;
        n.leftChild = insertLine(n.leftChild, new line (in.start, inter));
        n.leftChild.parent = n;
      }
      else{
        n.rightChild = insertLine(n.rightChild, new line (inter, in.end));
        n.rightChild.parent = n;
        n.leftChild = insertLine(n.leftChild, new line (in.start, inter));
        n.leftChild.parent = n;
      }
    }
    else if(Geometry.ccw(in.end, n.data.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){ //right
      n.rightChild = insertLine(n.rightChild, in);
      n.rightChild.parent = n;
    }
    else if(Geometry.ccw(in.end, n.data.start, n.data.end) == Geometry.direction.CLOCKWISE){ //left
      n.leftChild = insertLine(n.leftChild, in);
      n.leftChild.parent = n;
    }
    else if(Geometry.ccw(in.end, n.data.start, n.data.end) == Geometry.direction.COLINEAR){ //same line
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

  public void printInOrder(){ //prints
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

  public MyTreeNode lookup(line x){ //lookup a line
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
    if (n == null){ //null node, insert
      System.out.println("null");
      System.out.println("They are in the same region");
    }
    else if (n.data.equals(x)){ //equivelent node found, break out.
      System.out.println("same");
      System.out.println("The points are on the line: " + n.data);
    }
    else if (!(Geometry.intersect(n.data, x).equals(new point(-10,-10)))){ //if they intersect, both sides
      point inter = Geometry.intersect(n.data, x);
      System.out.println("Intersection");
      System.out.println("The points are seperated by the line: " + n.data);

    }
    else if(Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){ //right
      System.out.println("right");
      pointCheck(n.rightChild, x);
    }
    else if(Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.CLOCKWISE){ //left
      System.out.println("left");
      pointCheck(n.leftChild, x);
    }
    else if(Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.COLINEAR){ //same line
      System.out.println("Colinear");
      System.out.println("One of these points falls on a line");
    }
    else{
      System.out.println("Uh...");
    }

  }
  /*public void pointCheck(MyTreeNode n, line x){ //check two points

    if (n == null){
      System.out.println("They are in the same region");
    }
    else if (!(Geometry.intersect(x, n.data).equals(new point(-10,-10)))){
      System.out.println("These points are seperated by line: " + n.data);
    }
    else if (Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.ccw(x.end, n.data.start, n.data.end)){
      if (Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.COUNTERCLOCKWISE){
        System.out.println("left");
        pointCheck(n.leftChild, x);
      }
      else if(Geometry.ccw(x.start, n.data.start, n.data.end) == Geometry.direction.CLOCKWISE){
        System.out.println("right");
        pointCheck(n.rightChild, x);
      }
      else{
        System.out.println("These points both are on line: " + n.data);
      }
    }
    else {
      System.out.println("These points are seperated by line: " + n.data);
    }
  }*/

}
