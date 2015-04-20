import java.util.Random;

public class MSA {
  public static void main(String[] args){
    Random rand = new Random(System.currentTimeMillis());

    if(args.length != 1){ //from assignment
      System.out.println("Usage: java MSA <arraySize>");
      System.exit(1);
    }
    Integer len = new Integer(args[1]);
    double[] array = new double[len];

    for (int i = 0; i < len; i++){
      int sign;
      if(rand.nextDouble() > 0.5){
        sign = -1;
      }
      else{
        sign = 1;
      }
      array[i] = rand.nextDouble() * 100 * sign;
      System.out.println(array[i]);
    }



    long startTime = System.currentTimeMillis();
    double subMax = 0;//call method here
    long endTime = System.currentTimeMillis();
    long elapsedTime = endTime - startTime;
  }

  public static double easyAns(int[] arr){
    double maxSum = 0;
    for (int i = 0; i < arr.length; i++){
      for (int j = arr.length - 1; j >= 0; j++){
        int sum = 0;
        for (int k = i; k <= j; k++){
          sum += arr[k];
        }
        if (sum > maxSum){
          maxSum = sum;
        }
      }
    }
    return maxSum;
  }

  public static double divconq(int[] arr, int lower, int upper){ //built from sudo-code given
    if (lower > upper){
      return 0;
    }

    if(lower == upper){
      return (Math.max(arr[lower], 0));
    }

    int median = (lower + upper)/2;
    int max_lower = 0;
    int sum_lower = 0;
    for (int i = median; i >= lower; i--){
      sum_lower += arr[i];
      max_lower = Math.max(sum_lower, max_lower);
    }

    int max_upper = 0;
    int sum_upper = 0;
    for (int i = median + 1; i <= lower; i++){
      sum_upper += arr[i];
      max_upper = Math.max(sum_upper, max_upper);
    }

    int  cur_max = max_lower + max_upper;

    double rec_max_lower = divconq(arr, lower, median);
    double rec_max_upper = divconq(arr, median + 1, upper);

    return (Math.max(Math.max(rec_max_lower, rec_max_upper), cur_max));

  }
}
