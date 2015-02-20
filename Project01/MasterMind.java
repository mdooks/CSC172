public class MasterMind implements mm {
  //set up the variables needed by the mastermind game
  PossibleCodes codeList;
  int spaces;
  String[] colors;
  boolean won;
  Code currentGuess;
  int colorCorrect;
  int positionsCorrect;
  public MasterMind (String[] tokencolors, int positions){
    won = false;
    colors = tokencolors;
    codeList = new PossibleCodes();
    spaces = positions;
    int[] tokens = new int[spaces];
    codeGenerator(tokens, 0);
    colorCorrect = -1; //used to tell if it is the first move.
  }

  public void printList (){
    codeList.printList();
  }

  public void response(int colorsRightPositionWrong, int positionsAndColorRight) { //checks the users response and checks if the computer won, otherwise it removes options from the list
    colorCorrect = colorsRightPositionWrong;
    positionsCorrect = positionsAndColorRight;
    if (positionsAndColorRight == spaces){
      won = true;
      return;
    }
    else {
      codeList.rightColorRightSpot(currentGuess, positionsAndColorRight);
      codeList.rightColorWrongSpot(currentGuess, colorsRightPositionWrong, colors);
    }
    //printList();
  }

  public void newGame() { //resets variables for the new game
    codeList.clear();
    int[] tokens = new int[spaces];
    codeGenerator(tokens, 0);
    won = false;
    colorCorrect = -1;
  }


  public String [] nextMove() { //finds the next guess
    Code e = codeList.first.nextCode;
    if (colorCorrect == -1){ //for the first guess there is no base data so just start with the middle item
      System.out.println("first try");
      String[] g = new String[e.nextCode.code.length];
      Code nm = new Code();
      for (int i = 0; i < codeList.size()/2; i++){
        e = e.nextCode;
      }

      for (int i = 0; i < g.length; i++){
        g[i] = colors[e.nextCode.code[i]];
      }
      nm.code = e.nextCode.code;
      currentGuess = nm;
      return g;
    }
    else if (codeList.size() == 1){ //if there is only one code, return it
      String[] g = new String[e.code.length];
      for (int i = 0; i < g.length; i++){
        g[i] = colors[e.code[i]];
      }
      return g;
    }
    //otherwise find the code that will remove the most other codes if wrong.
    int max = 0;
    Code next = new Code();
    while(e.code != null){
      int tot = codeList.rightColorRightSpotCount(e, colorCorrect) + codeList.rightColorWrongSpotCount(e, positionsCorrect, colors);
      if (tot >= max){
        max = tot;
        next.code = e.code;
      }
      e = e.nextCode;
    }
    currentGuess = next;
    String[] g = new String[spaces];
    for (int i = 0; i < g.length; i++){
      g[i] = colors[next.code[i]];
    }
    return g;
  }
  //so this uses ints, guess I should make it strings, but...
  /*
  * Ok so I need all the possible guesses right. I was thinking
  * trees, but the TA alluded to a Linked list, so I worked with
  * that. It took me a while, because I focused on using strings,
  * but if it was ints, I could treat it like setting up a truth
  * table. Start with all zeros then add one to the end until you
  * run out of options, then move to the left one possition.
  * So if its 2 colors two spots, set the first one to 0, then
  * move over one. set that one to 0, [0,0], but, becuase you
  * can't move over again, return it. Then increase the counter so
  * that it is [0,1] and again return it, but now we are out of options,
  * so go up a level and change the first one to a 1, so we have [1,x]
  * and then move right a position. So I started with for loops, but that
  * would recuire me to know how many options, so I switched to recursion.
  */
  public void codeGenerator (int[] options, int position){ //create the initial list of codes
    int stop = spaces - 1;
    int next = position + 1;
    //takes the list of piece options, and the positions that will be manipulated
    for(int codeVal = 0; codeVal < colors.length; codeVal++){ //for all the options
      options[position] = codeVal; //set the current position to that option
      if (position != stop){ //check to see if out of positions
        codeGenerator(options, next);
      }
      else{ //if you are push the array into the linked list
        codeList.insert(options);
      }
    }
  }
}
