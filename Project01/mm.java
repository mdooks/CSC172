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
//interface given to us in the project assignment.
public interface mm {
  //public mm (String[] tokencolors, int positions);
  // The constructor must take an array of strings as input
  // For instance, if:
  // tokencolors ==
  // {"ORANGE", "PINK","RED", "BLUE", "GREEN", "YELLOW"};
  // then the engine returns guesses from this set,
  // However, it would be just as valid to pass in
  // tokencolors ==
  // {"SNEZZY", "SLEEPY", "DIRTY", "FILTHY", "GRUMPY", "HAPPY", "DOC"};
  //So, the number of elements that your system guesses
  //over is determined by the array
  public void response(int colorsRightPositionWrong, int positionsAndColorRight);
  public void newGame(); // Reset the game
  public String [] nextMove(); // return the next guess
  //NEED TO CHANGE BACK TO STRING
}
