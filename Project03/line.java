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

public class line {
  point start;
  point end;

  public line (point xval, point yval){ //define the start and end points of the line
    start = xval;
    end = yval;

    start.parent = this; //lets the points see the line that they are a part of, not used in the end.
    end.parent = this;
  }

  public line (double s1, double s2, double e1, double e2){ //make a line right from floats
    start = new point (s1, s2);
    end = new point (e1, e2);

    start.parent = this;
    end.parent = this;
  }

  public boolean equals (Object o){ //define equality
    line b = (line) o;
    if ((start.x == b.start.x) && (start.y == b.start.y) && (end.x == b.end.x) && (end.y == b.end.y)) {
      return true;
    }
    else if ((start.x == b.end.x) && (start.y == b.end.y) && (end.x == b.start.x) && (end.y == b.start.y)){
      return true;
    }
    return false;
  }

  public String toString (){ //toString for printing the lines in standard form
    //scratch that, they want two points.
    return (start +", " + end);
  }

}
