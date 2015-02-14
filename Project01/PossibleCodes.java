public class PossibleCodes {
  Code first;
  Code last;
  int size;
  public PossibleCodes(){
    first = new Code();
    last = new Code();
    first.nextCode = last;
    last.prevCode = first;
    size = 0;
  }
  public void clear(){
    first.nextCode = last;
    last.prevCode = first;
    size = 0;
  }
  public int size(){
    return size;
  }
  public void insert(int[] x){
    size++;
    Code e = last;
    Code in = new Code();
    int[] y = x.clone();
    in.code = y;
    in.prevCode = e.prevCode;
    in.nextCode = e;
    e.prevCode.nextCode = in;
    e.prevCode = in;
  }
  public boolean arrayEqual(int[] a, int[] b){
    for(int i = 0; i<a.length; i++){
      if (a[i] != b[i]){
        return false;
      }
    }
    return true;
  }
  public void delete(int[] x){
    size--;
    Code e = first;
    while(e.nextCode != last){ //run through the elements
      if (arrayEqual(x, e.nextCode.code)){
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
      if(e.nextCode == last || e.nextCode == null){
        return;
      }
      if (b != blackPegs){
        //printCode(e.nextCode);
        //System.out.print(" ");
        //printCode(guess);
        //System.out.print(" black");
        //System.out.println(" ");
        delete(e.nextCode.code);
      }
      else{
        e = e.nextCode;
      }
    }
  }
  public void checkWhite (Code guess, int whitePegs, int blackPegs){ //still not working
    Code e = first;
    while (e.nextCode != last){
      int w_tot = 0;
      int c = 0;
      int w = 0;
      for (int i = 0; i<guess.code.length; i++){
        w = 0;
        for(int j = 0; j<e.nextCode.code.length; j++){
          if(guess.code[i] == e.nextCode.code[j] && guess.code[j] != e.nextCode.code[j] && guess.code[i] != e.nextCode.code[i]){
              w++;
              j = e.nextCode.code.length;
          }
        }

      }
      for (int k : guess.code){
        //System.out.print(k);
        for(int l : guess.code){
          //System.out.println(" " + l);
          if (k == l){
            //System.out.print(k+"+"+l + ": ");
            c++;
            //System.out.println(c);
          }
        }
      }
      System.out.println(w + "/" + c + "=" + w/c);
      w_tot += w/c;
      if (whitePegs != w_tot){
        System.out.println(whitePegs + " " + (w_tot));
        printCode(e.nextCode);
        System.out.print(" ");
        printCode(guess);
        System.out.println(" ");
        delete(e.nextCode.code);
      }
      else{
        e = e.nextCode;
      }
    }
  }
  public void newCheckWhite(Code guess, int whitePegs, String[] colors){
    Code e = first;
    int[] copies = new int[colors.length];
    int[] test_copies = new int[colors.length];
    int[] w_vals = new int[colors.length];
    int[] w_res = new int[colors.length];

    for (int h = 0; h < copies.length; h++){
      copies[h] = 0;
      test_copies[h] = 0;
      w_vals[h] = 0;
    }
    for (int v : guess.code){
      copies[v]++;
    }

    while (e.nextCode != last){
      for (int h = 0; h < copies.length; h++){
        test_copies[h] = 0;
        w_res[h] = 0;
        w_vals[h] = 0;
      }
      for (int v : e.nextCode.code){
        test_copies[v]++;
      }
      for (int i = 0; i<guess.code.length; i++){
        for(int j = 0; j<e.nextCode.code.length; j++){
          if(guess.code[i] == e.nextCode.code[j] && guess.code[j] != e.nextCode.code[j] && guess.code[i] != e.nextCode.code[i]){
            w_vals[guess.code[i]]++;
          }
        }
      }


      for (int h = 0; h < w_res.length; h++){
        if(copies[h] != 0 && copies[h] > test_copies[h]){
          //System.out.println(w_vals[h]+ "/" + copies[h]);
          w_res[h] = w_vals[h]/copies[h];
        }
        else if(test_copies[h] != 0 && test_copies[h] >= copies[h]){
          //System.out.println(w_vals[h]+ "/" + copies[h]);
          w_res[h] = w_vals[h]/test_copies[h];
        }
      }
      int w = 0;
      for (int y : w_res){
        w += y;
      }

      if (whitePegs != w){
        //System.out.println(whitePegs + " " + (w));
        //printCode(e.nextCode);
        //System.out.print(" ");
        //printCode(guess);
        //System.out.println(" ");
        delete(e.nextCode.code);
      }
      else{
        e = e.nextCode;
      }
    }
  }
  public void printCode(Code x){
    for (int c : x.code){
      System.out.print(c);
    }
  }
}
