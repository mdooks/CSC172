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

public class Geometry { //class for the math
  public enum direction{ //used to back up the method given to us
    CLOCKWISE, COUNTERCLOCKWISE, COLINEAR
  }

  public static Double infinity = 1.0/0.0;
  public static direction ccw (point p0, point p1, point p2){ //method taken from the lab assignment
    double dx1 = p1.getX() - p0.getX(); //get the slope of the line made by points 0 & 1
    double dy1 = p1.getY() - p0.getY();

    double dx2 = p2.getX() - p0.getX(); //get slope of line made by points 0 & 2
    double dy2 = p2.getY() - p0.getY();

    //return the direction of point for sorting reasons
    if (dx1*dy2 > dx2*dy1) {
      return direction.COUNTERCLOCKWISE;
    }
    else if (dx1*dy2 < dx2*dy1){
      return direction.CLOCKWISE;
    }
    else if ((dx1*dx2 < 0) || (dy1 * dy2 < 0)){
      return direction.CLOCKWISE;
    }
    else if ((dx1*dx1 + dy1*dy1) < (dx2*dx2 + dy2*dy2)){
      return direction.COUNTERCLOCKWISE;
    }
    else {
      return direction.COLINEAR;
    }

  }

  public static point intersect (line a, line b){ //check if the lines intersect
    double m1 = slope(a); // find the slopes of the line
    double m2 = slope(b);
    if (m1 == m2){
      return new point (-10, -10);
    }
    double ansY;
    double ansX;
    if (a.start.getX() == a.end.getX()){ //Handle vertical line
      ansY = m2 * (a.start.getX() - b.start.getX()) + b.start.getY();
      ansX = a.start.getX();
    }
    else if (b.start.getX() == b.end.getX()){ //handle vertical line
      ansY = m1 * (b.start.getX() - a.start.getX()) + a.start.getY();
      ansX = b.start.getX();
    }
    else{
      double x01 = a.start.getX(); //get the starting x points
      double x02 = b.start.getX();

      double y01 = a.start.getY(); //and the starting y points
      double y02 = b.start.getY();

      ansX = ((m1 * x01 - y01 - m2*x02 + y02)/(m1-m2));
      ansY = m1 * (ansX - x01) + y01;
    }
    point ans = new point(ansX, ansY);
    System.out.println("Intersect: " + ans);
    if ((a.start.getX() > ans.getX() || a.end.getX() < ans.getX()) || (b.start.getX() > ans.getX() || b.end.getX() < ans.getX())){ //if the point is out of the scope of the line, make the error point
      return new point (-10, -10);
    }
    else if (!(ans.getY() >= Math.min(a.start.getY(), a.end.getY()) && ans.getY() <= Math.max(a.start.getY(), a.end.getY()))){
      System.out.println("Y case");
      return new point (-10, -10);
    }
    /*else if ((b.start.getY() <= ans.getY() || b.end.getY() >= ans.getY()) || (b.end.getY() <= ans.getY() || b.start.getY() >= ans.getY())){ //if the point is out of the scope of the line, make the error point
      System.out.println("Y bounds");
      return new point (-10, -10);
    }
    /*else if ((a.start.getY() > ans.getY() || a.end.getY() < ans.getY()) || (b.start.getY() > ans.getY() || b.end.getY() < ans.getY())){ //if the point is out of the scope of the line, make the error point
      System.out.println("Y bounds");
      return new point (-10, -10);
    }*/
    if ((a.start.equals(ans) || a.end.equals(ans)) ||  (b.start.equals(ans) || b.end.equals(ans))){ //if the point is the start or end then the intersect doesn't matter
      return new point (-10,-10);
    }
    return ans;

  }
  public static double slope (line a){ //get the slope of the line
    double dx = a.end.getX() - a.start.getX();
    double dy = a.end.getY() - a.start.getY();
    return (dy/dx);
  }

  public static boolean isValid(Float a){ //check if its a valid point.
    if (a >= 0 &&  a <= 1){
      return true;
    }
    return false;
  }
}
