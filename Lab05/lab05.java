import java.math.BigInteger;
public class lab05{
  public static void main (String[] args){
    //System.out.println(identicalOrder("error"));
    System.out.println("There are " + newIdenticalOrder("error") + " anagrams of 'error'");
    System.out.println("There are " + newIdenticalOrder("street") + " anagrams of 'street'");
    System.out.println("There are " + newIdenticalOrder("allele") + " anagrams of 'allele'");
    System.out.println("There are " + newIdenticalOrder("Mississippi") + " anagrams of 'Mississippi'");
    //System.out.println(bins(new BigInteger("6"), new BigInteger("4")));
    //System.out.println(bins(new BigInteger("4"), new BigInteger("6")));
  }

  public static BigInteger newIdenticalOrder (String input){
    long top = permutations(input.length());
    long denom = 1;
    char[] inChar = input.toCharArray();
    for (int i=0; i < inChar.length; i++){
      char c= inChar[i];
      int tot = 1;
      for (int j = i+1; j < inChar.length; j++){
        char e = inChar[j];
        if (c == e){
          tot++;
        }
      }
      denom *= tot;
    }
    return BigInteger.valueOf(top/denom);
  }

  public static BigInteger bins (BigInteger items, BigInteger bins){
    if (items.intValue() == 0 || bins.equals(items)){
      return BigInteger.ONE;
    }
    else{
      return (bins(items.subtract(BigInteger.ONE), bins.subtract(BigInteger.ONE)).add(bins(items.subtract(BigInteger.ONE), bins)));
    }
    //return (permutations(items+bins-1))/(permutations(items));
  }

  private static long permutations (int n){
    if (n == 1)
      return 1;
    else if (n==0)
      return 1;
    else
      return (n * permutations(n-1));
  }
}
