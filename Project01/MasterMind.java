public class MasterMind implements mm {
  public MasterMind (String[] tokencolors, int positions){

  }
  public void response(int colorsRightPositionWrong, int positionsAndColorRight) {

  }
  public void newGame() {

  }
  public String [] nextMove() {
    String[] x = {"s", "d"};
    return x;
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
  * and then move over a possistion. So I started with loops, but that
  * would recuire me to know how many options, so I switched to recursion.
  */
  public void guessGenerator (int[] colors, int position){
    for(int i = 0; i< colors.length; i++){
      colors[position] = i;
      if (position == colors.length - 1){
        //add the guess to a list(?)
      }
      else{
        guessGenerator(colors, ++index);
      }
    }

  }
}
