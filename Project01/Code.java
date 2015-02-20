/*
* Project 1
*
* Project 1
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Lab 3
*
* Author: Nicholas Graham
*
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: January 29, 2014.
*/
public class Code {
  int[] code;
  Code nextCode;
  Code prevCode;

  public void printCode(){
    for (int i : code){
      System.out.print(i);
    }
    System.out.println();
  }
}
