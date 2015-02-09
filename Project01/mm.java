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

  }
