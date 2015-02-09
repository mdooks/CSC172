/*
* Lab4
*
* Lab 4
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Lab 4
*
* Author: Nicholas Graham
*
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: Febuary 4, 2015.
*/

import java.math.BigInteger;

public class lab04{
  public static void main (String[] args){
    BigInteger colors = new BigInteger("4");
    BigInteger houses = new BigInteger ("3");
    System.out.println("How many ways can we paint three houses in any of four colors? " + assignments(colors, houses));

    BigInteger characters = new BigInteger("62");
    BigInteger passwordLength = new BigInteger("8");
    System.out.println("Suppose a computer password consists of eight to ten letters and/or digits. How many different passwords are there? " + assignments(characters, passwordLength));

    System.out.println("If we have 9 players for a baseball team, how many possible batting orders are there? " + permutations(new BigInteger("9")));

    System.out.println("In a class of 200 students, we wish to elect a President, Vice President, Secretary and Treasurer. In haw many ways can these four officers be selected? " + orderedSelection(new BigInteger("200"), new BigInteger("4")));

    System.out.println("How many ways are there to form a sequence of m letters out of the 26 letters, if no letter is allowed to appear more than once for m=3? " + orderedSelection(new BigInteger("26"), new BigInteger("3")));

    System.out.println("How many ways are there to form a sequence of m letters out of the 26 letters, if no letter is allowed to appear more than once for m=5? " + orderedSelection(new BigInteger("26"), new BigInteger("5")));

    System.out.println("In poker, each player is dealt five cards from a 52 card deck. How many different possible hands are there?  " + unorderedSelection(new BigInteger("52"), new BigInteger ("5")));
  }

  private static BigInteger assignments(BigInteger k, BigInteger n){ //part 1
    BigInteger out = new BigInteger("1");
    //System.out.println(n.intValue());
    for (int i = 0; i < n.intValue(); i++){
      out = out.multiply(k);
    }
    return out;
  }

  private static BigInteger permutations (BigInteger n){ //part 2
    if (n.intValue() == 1)
    return BigInteger.ONE;
    else
    return (n.multiply(permutations(n.subtract(BigInteger.ONE))));
  }

  private static BigInteger orderedSelection (BigInteger n, BigInteger m){ //part 3
    BigInteger product = BigInteger.ONE;
    for (BigInteger i = n; i.intValue() > (n.subtract(m)).intValue(); i = i.subtract(BigInteger.ONE)){
      product = product.multiply(i);
    }
    return (product);
  }

  private static BigInteger unorderedSelection (BigInteger n, BigInteger m){ //part 4
    if (m.intValue() == 0 || n.equals(m)){
      return BigInteger.ONE;
    }
    else{
      return (unorderedSelection(n.subtract(BigInteger.ONE), m.subtract(BigInteger.ONE)).add(unorderedSelection(n.subtract(BigInteger.ONE), m)));

    }
  }
}
