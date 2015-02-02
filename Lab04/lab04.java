public class lab04{
  public static void main (String[] args){
    int colors = 4;
    int houses = 3;
    System.out.println("How many ways can we paint three houses in any of four colors? " + assignments(colors, houses));

    int characters = 26 + 26 + 10;
    int passwordLength = 8;
    System.out.println("Suppose a computer password consists of eight to ten letters and/or digits. How many different passwords are there? " + assignments(characters, passwordLength));

    System.out.println("If we have 9 players for a baseball team, how many possible batting orders are there? " + permutations(9));

    System.out.println("In a class of 200 students, we wish to elect a President, Vice President, Secretary and Treasurer. In haw many ways can these four officers be selected? " + orderedSelection(200, 4));

    System.out.println("How many ways are there to form a sequence of m letters out of the 26 letters, if no letter is allowed to appera more than once for m=3? " + orderedSelection(26, 3));

System.out.println("How many ways are there to form a sequence of m letters out of the 26 letters, if no letter is allowed to appera more than once for m=5? " + orderedSelection(26, 5));

    System.out.println("In poker, each player is dealt five cards from a 52 card deck. How many different possible hands are there?  " + unorderedSelection(25, 5));
  }

  private static double assignments(double k, double n){
    return Math.pow(k,n);
  }

  private static double permutations (int n){
    if (n == 1)
      return 1;
    else
      return (n * permutations(n-1));
  }

  private static double orderedSelection (int n, int m){
    int product = 1;
    for (int i = n; i > n-m; i--){
      product*=i;
    }
    return (product);
  }

  private static double unorderedSelection (int n, int m){
    if (m == 0)
      return 1;
    else if(n == m)
      return 1;
    else
      return unorderedSelection(n-1, m) + unorderedSelection(n-1, m-1);
  }
}
