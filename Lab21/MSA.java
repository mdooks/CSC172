import java.util.Random;

public class MSA {
  public static void main(String[] args){
    Random rand = new Random(System.currentTimeMillis());

    if(args.length != 1){ //from assignment
      System.out.println("Usage: java MSA <arraySize>");
      System.exit(1);
    }
    Integer len = new Integer(args[0]);
    System.out.println(len);
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
      //System.out.println(array[i]);
    }

    System.out.println();


    long startTime = System.currentTimeMillis();
    double subMax = easyAns(array);//call method here
    long endTime = System.currentTimeMillis();
    long elapsedTime = endTime - startTime;

    System.out.println("The max is: " + subMax + " and it took: " + elapsedTime + "ms to find with the easy way.");

    startTime = System.currentTimeMillis();
    subMax = divconq(array, 0, array.length - 1);//call method here
    endTime = System.currentTimeMillis();
    elapsedTime = endTime - startTime;

    //System.out.println(subMax);
    System.out.println("The max is: " + subMax + " and it took: " + elapsedTime + "ms to find with divide and conquor.");
  }

  public static double easyAns(double[] arr){
    double maxSum = 0;
    for (int i = 0; i < arr.length; i++){
      for (int j = arr.length - 1; j >= 0; j--){
        double sum = 0;
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

  public static double divconq(double[] arr, int lower, int upper){ //built from sudo-code given
    if (lower > upper){
      return 0;
    }

    if(lower == upper){
      return (Math.max(arr[lower], 0));
    }

    int median = (lower + upper)/2;
    double max_lower = 0;
    double sum_lower = 0;
    for (int i = median; i >= lower; i--){
      sum_lower += arr[i];
      max_lower = Math.max(sum_lower, max_lower);
    }

    double max_upper = 0;
    double sum_upper = 0;
    for (int i = median + 1; i <= upper; i++){
      sum_upper += arr[i];
      max_upper = Math.max(sum_upper, max_upper);
    }

    double  cur_max = max_lower + max_upper;

    double rec_max_lower = divconq(arr, lower, median);
    double rec_max_upper = divconq(arr, median + 1, upper);

    return (Math.max(Math.max(rec_max_lower, rec_max_upper), cur_max));

  }
}
