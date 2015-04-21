public class Change {
  public static int calls;
  public static int[][] table;
  public static void main(String[] args){
    int[] denominations = {100000, 50000, 2000, 1000, 500, 100, 25, 10, 5, 1};
    calls = 0;
    int amount = 348;
    if (args.length == 1){
      amount = Integer.parseInt(args[0]);
    }
    int[] change = makeChange(amount, denominations);

    System.out.print("Change for " + amount + " is {");

    for (int a : change){
      System.out.print(a +", ");
    }
    System.out.println("}");

    System.out.println("calls: " + calls);
  }

  public static int[] makeChange(int a, int[] d){
    table = new int[a + 1][];


    int[] count = new int[d.length + 1];
    recMakeChange(a, d, count);
    int[] ans = expandArray(count, d);
    return ans;
  }

  public static int[] expandArray(int[] c, int[] denom){
    int[] ans = new int[c[c.length - 1]];

    int pos = 0;
    for (int i = 0; i < c.length - 1; i++){
      for (int j = c[i]; j > 0; j--){
        ans[pos] = denom[i];
        pos++;
      }
    }
    return ans;
  }

  public static boolean recMakeChange(int amount, int[] denom, int[] count){

    calls++;
    boolean succsess = false;
    if(amount == 0){
      return true;
    }
    else if(amount < 0){
      return false;
    }
    if(table[amount] != null){
      for(int k = 0; k<count.length; k++){
        count[k] = table[amount][k];
      }
      return true;
    }

    int[] temp = new int[count.length];
    int[] best = new int[count.length];
    best[count.length - 1] = amount + 1;

    for (int i = 0; i < denom.length; i++){
      if (recMakeChange(amount - denom[i], denom, temp)){
        succsess = true;
        if (temp[temp.length - 1] < best[best.length - 1]){
          temp[i] = temp[i] + 1;
          temp[temp.length - 1] = temp[temp.length - 1] + 1;
          for (int j = 0; j < temp.length; j++){
            best[j] = temp[j];
          }
        }
      }
    }

    if(succsess){
      table[amount] = new int[count.length];
      for (int k = 0; k < count.length; k++){
        table[amount][k] = count[k] = best[k];
      }

    }
    return succsess;
  }
}
