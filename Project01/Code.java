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
