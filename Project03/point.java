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

public class point {
  double x;
  double y;

  line parent;
  public point (double xval, double yval){ //set up the point with an x & y value
    setX(xval);
    setY(yval);
  }

  public double getX(){ // get the x value
    return x;
  }
  public double getY(){ //get the y value
    return y;
  }

  public void setX(double a){ //set the x value
    if (a >= 0 && a <= 1 && y !=-10){
      x = a;
    }
    else{
      x = -10; //a value for invalid points, should really throw an error, but, I'll fix it later
      y = -10;
    }
  }
  public void setY(double a){ //set the y value
    if (a >= 0 && a <= 1 && x != -10){
      y = a;
    }
    else{
      y = -10; //a value for invalid points should throw an error, but I'll fix it later
      x = -10;
    }
  }

  public boolean equals(Object o){ //test the points equality
    point b = (point) o;
    if (this.x == b.x && this.y == b.y){
      return true;
    }
    return false;
  }
  public String toString() { //to string method for printing them out
    return ("(" + this.getX() + "," + this.getY() +")");
  }
}
