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
    System.out.println(first.nextCode.code[0]);
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
    while (e.nextCode != null){ //run through the elements and check the data
      for(int i=0; i<x.length; i++){
      if (e.nextCode.code[i]== x[i]){
      }
      else{
        return false;
      }
      e = e.nextCode;
    }
    }
    return true;
  }
}
