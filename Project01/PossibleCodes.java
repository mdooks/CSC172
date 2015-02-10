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
    in.code = x;
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

  public boolean isEmpty(){
    return (first.nextCode == last);
  }
}
