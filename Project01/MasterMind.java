public class MasterMind implements mm {
  PossibleCodes codeList;
  int spaces;
  String[] colors;
  boolean won;
  Code currentGuess;
  public MasterMind (String[] tokencolors, int positions){
    won = false;
    colors = tokencolors;
    codeList = new PossibleCodes();
    spaces = positions;
    int[] tokens = new int[spaces];
    codeGenerator(tokens, 0);
  }
  public void printList (){
    codeList.printList();
  }
  public void response(int colorsRightPositionWrong, int positionsAndColorRight) {
    if (positionsAndColorRight == spaces){
      won = true;
      return;
    }
    else {
      codeList.checkBlack(currentGuess, positionsAndColorRight);
      //codeList.checkWhite(currentGuess, colorsRightPositionWrong, positionsAndColorRight);
      codeList.newCheckWhite(currentGuess, colorsRightPositionWrong, colors);
    }
  }

  public void newGame() {
    codeList.clear();
    int[] tokens = new int[spaces];
    codeGenerator(tokens, 0);
    won = false;
    printList();
  }


  public int [] nextMove() { //should be strings, need to change back
    Code e = codeList.first;
    for (int i = 0; i < codeList.size()/2; i++){
      e = e.nextCode;
    }
    return e.nextCode.code;
    /*int[] x = {1, 2, 0};
    currentGuess = new Code();
    currentGuess.code=x;
    return x;*/
  }
  //so this uses ints, guess I should make it strings, but...
  /*
  * Ok so I need all the possible guesses right. I was thinking
  * trees, but the TA alluded to it supposed to be done with a
  * Linked list, so I worked with that. It took me a while, because
  * I focused on using strings, but if it was ints, I could treat it
  * like setting up a truth table. Start with all zeros then add one
  * to the end until you run out of options, then move to the left
  * one possition. So if its 2 colors two spots, set the first one to
  * 0, then move over one. set that one to 0, [0,0], but, becuase you
  * can't move over again, return it. Then increase the counter so
  * that it is [0,1] and again return it, but now we are out of options,
  * so go up a level and change the first one to a 1, so we have [1,x]
  * and then move right a possistion. So I started with loops, but that
  * would recuire me to know how many options, so I switched to recursion.
  */
  public void codeGenerator (int[] options, int position){
    //takes the list of piece options, and the positions that will be manipulated
    for(int i = 0; i< colors.length; i++){ //for all the options
      options[position] = i; //set the current position to that option
      //System.out.println(options[position] + ", " + position);

      if (position == spaces - 1){ //check to see if out of positions
        for (int j =0; j<options.length; j++){
          //System.out.print(options[j] + ",");
        }
        //System.out.println();
        codeList.insert(options);
      }
      else{ //if you aren't go deeper down the list
        codeGenerator(options, position+1);
      }
    }

  }
}
