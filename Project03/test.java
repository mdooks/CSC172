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

import java.util.Scanner;

public class test {
  public static void main(String[] args){
    System.out.println(Geometry.infinity);
    line qw = new line (0.1, 0.1, 0.7, 0.1);
    line rt = new line (0.5, 0, 0.5, 1);
    System.out.println(Geometry.intersect(qw, rt));
    Scanner input = new Scanner(System.in); //set up scanner

    System.out.println("Enter the number of lines, then enter the lines in the following format:\n# of lines \nx1 y1 x2 y2");
    int num_lines = input.nextInt(); //get the number of lines

    line L[] = new line[num_lines]; //set up the array of lines

    for(int i = 0; i < num_lines; i++){ //loop through, getting the 4 points of each line
      float x1 = input.nextFloat();
      float y1 = input.nextFloat();
      float x2 = input.nextFloat();
      float y2 = input.nextFloat();
      if (Geometry.isValid(x1) && Geometry.isValid(y1) && Geometry.isValid(x2) && Geometry.isValid(y2)){ //check for valid points
        L[i] = new line(x1, y1, x2, y2);
      }
      else {
        System.out.println("One of the points you have entered is invalid. The points must be in the unit square.");
        i--;
      }
    }

    BinarySearchTree bst = new BinarySearchTree(); //set up the tree

    for (line l : L){ //insert the lines
      bst.insert(l);
      bst.printInOrder(); //for testing, print the lines
      System.out.println();
    }


    System.out.println("Enter the points you want to test: x1 y1 x2 y2"); //ask for the points

    while (true) { //untill they quit
      String s = input.next(); //get the first thing
      if (s.equals("quit")){ //if its quit, break
        break;
      }
      bst.sameRegion(new point(new Float(s), input.nextFloat()), new point (input.nextFloat(), input.nextFloat())); //otherwise test the points
    }
  }
}
