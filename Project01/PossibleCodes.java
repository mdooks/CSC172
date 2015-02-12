public class PossibleCodes {
  Code first;
  Code last;
  public PossibleCodes(){
    first = new Code();
    last = new Code();
    first.nextCode = last;
    last.prevCode = first;
  }

  public void insert(int[] x){
    Code e = last;
    Code in = new Code();
    int[] y = x.clone();
    in.code = y;
    in.prevCode = e.prevCode;
    in.nextCode = e;
    e.prevCode.nextCode = in;
    e.prevCode = in;
  }

  public void delete(Code x){
    Code e = first;
    while(e.nextCode.nextCode != null){ //run through the elements
      if (e.nextCode == x){ //ounce found remove it
        e.nextCode.nextCode.prevCode = e;
        e.nextCode = e.nextCode.nextCode;
        return;
      }
      e = e.nextCode;
    }
  }
  public void printList(){
    Code e = first;
    while (e.nextCode != last){ //run through the elements and print each one
      for(int i = 0; i < e.nextCode.code.length; i++){
        //System.out.println(i);
        System.out.print(e.nextCode.code[i]);
      }
      System.out.println();
      e = e.nextCode;
    }
    System.out.println();
  }
  public boolean isEmpty(){
    return (first.nextCode == last);
  }
  public boolean lookup(int[] x){
    Code e = first;
    boolean res = false;

    while (e.nextCode != last && !res){
      for(int i =0; i<x.length; i++){
        if (e.nextCode.code[i] != x[i]){
          res = false;
          i = x.length;
        }
        else{
          res = true;
        }
      }
      e = e.nextCode;
    }
    return res;
  }
  public void checkBlack(Code guess, int blackPegs){ //move to PossibleCodes
    Code e = first;
    while (e.nextCode != last){
      int b = 0;
      for(int i =0; i<guess.code.length; i++){
        if (e.nextCode.code[i] == guess.code[i]){
          b++;
        }
      }
      if (b != blackPegs){
        delete(e.nextCode);
      }
      e = e.nextCode;
    }
  }
  public void checkWhite (Code guess, int whitePegs, int blackPegs){
    Code e = first;
    while (e.nextCode != last){
      int w = 0;
      for (int i = 0; i<guess.code.length; i++){
        for(int j = 0; j<e.nextCode.code.length; j++){
          if(guess.code[i] == e.nextCode.code[j]){
            w++;
          }
        }
      }
      if (whitePegs != w-blackPegs){
        delete(e.nextCode);
      }
      e = e.nextCode;
    }
  }
}
