import java.math.BigInteger;
public class lab05{
  public static void main (String[] args){
    //System.out.println(identicalOrder("error"));
    System.out.println("There are " + newIdenticalOrder("error") + " anagrams of 'error'");
    System.out.println("There are " + newIdenticalOrder("street") + " anagrams of 'street'");
    System.out.println("There are " + newIdenticalOrder("allele") + " anagrams of 'allele'");
    System.out.println("There are " + newIdenticalOrder("Mississippi") + " anagrams of 'Mississippi'");

    System.out.println("How many ways can we distribute six apples to four children? " + BinCombo(new BigInteger("6"), new BigInteger("4")));
    System.out.println("How many ways can we distribute four apples to six children? " + BinCombo(new BigInteger("4"), new BigInteger("6")));

    System.out.println();

    BigInteger[] list = new BigInteger[2];
    list[0] = new BigInteger("6");
    list[1] = new BigInteger("3");
    System.out.println("How many ways can we distribute  six apples and three pears to five children? " + distinguishableBins(list, new BigInteger("5")));

    BigInteger[] list2 = new BigInteger[3];
    list2[0] = new BigInteger("2");
    list2[1] = new BigInteger("5");
    list2[2] = new BigInteger("6");
    System.out.println("How many ways can we distribute  two apples, five pears and six bananas to three children " + distinguishableBins(list, new BigInteger("3")));
  }

  public static BigInteger newIdenticalOrder (String input){ //part 1
    BigInteger top = permutations(BigInteger.valueOf(input.length()));
    BigInteger denom = BigInteger.ONE;
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
      denom.multiply(BigInteger.valueOf(tot));
    }
    return (top.divide(denom));
  }

  public static BigInteger BinCombo (BigInteger items, BigInteger bins){ //part 2
    BigInteger n = items.add(bins).subtract(BigInteger.ONE);
    BigInteger m = items;
    return unorderedSelection(n,m);
  }

  private static BigInteger permutations (BigInteger n){  //helper from lab 4
    if (n.intValue() == 1)
      return BigInteger.ONE;
    else if (n.intValue()==0)
      return BigInteger.ONE;
    else
      return (n.multiply(permutations(n.subtract(BigInteger.ONE))));
  }
  private static BigInteger unorderedSelection (BigInteger n, BigInteger m){ //helper from lab 4
    if (m.intValue() == 0 || n.equals(m)){
      return BigInteger.ONE;
    }
    else{
      return (unorderedSelection(n.subtract(BigInteger.ONE), m.subtract(BigInteger.ONE)).add(unorderedSelection(n.subtract(BigInteger.ONE), m)));

    }
  }

  private static BigInteger distinguishableBins (BigInteger[] objects, BigInteger bins){ //part 3
    BigInteger tot = new BigInteger("0");
    BigInteger dmul = BigInteger.ONE;
    for (BigInteger o : objects){
      tot = tot.add(o);
      dmul = dmul.multiply(permutations(o));
    }
    return permutations(tot.add(bins).subtract(BigInteger.ONE)).divide(permutations(bins.subtract(BigInteger.ONE)).multiply(dmul));

  }
}
