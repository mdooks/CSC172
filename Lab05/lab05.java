public class lab05{
  public static void main (String[] args){
    System.out.println(identicalOrder("error"));
    System.out.println (5, [1,3,1]);
    System.out.println(bins(6,4));
    System.out.println(bins(4,6));
  }

  public static double identicalOrder (String in){
    double top = permutations(in.length());
    double denom = 1;
    char[] inChar = in.toCharArray();
    for (int i=0; i < inChar.length; i++){
      char c= inChar[i];
      int tot = 1;
      for (int j = i+1; j < inChar.length; j++){
        char e = inChar[j];
        if (c == e){
          tot++;
          System.out.println(c+" "+ e);
        }
      }
      //System.out.println(tot);
      denom *= permutations(tot);
      System.out.println(denom);
    }
    return top/denom;
  }

  public static double newIdenticalOrder (int n, int[] d){
    double num = permutations (n);
    double denom = 1;
    for (int i : d){
      denom *= permutations (i);
    }
    return (num/denom);
  }

  public static double bins (int items, int bins){
    return (permutations(items+bins-1))/(permutations(items));
  }

  private static double permutations (int n){
    if (n == 1)
      return 1;
    else if (n==0)
      return 1;
    else
      return (n * permutations(n-1));
  }
}
