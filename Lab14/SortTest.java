import java.util.Arrays;
public class SortTest {
  private static int count;
  public static void main(String args[]) {
    long startTime, endTime, elapsedTime;
    int size = Integer.parseInt(args[0]);

    Integer [] a = new Integer[size];
    Integer [] b = new Integer[size];

    for (int i = 0; i < size; i++) {
      a[i] = b[i] = (int)(Math.random() * 100);
    }


    //System.out.println(Arrays.toString(a));
    count = 0;
    startTime = System.currentTimeMillis();
    bubblesort(a);
    endTime = System.currentTimeMillis();
    elapsedTime = endTime - startTime;
    //System.out.println(Arrays.toString(a));
    System.out.println("bubblesort took "+ count + " moves to sort "+ size + " items");
    System.out.println("\t in : "+ elapsedTime + " millesec");

    // Reset count and array
    count = 0;
    for (int i = 0; i < size; i++)
    a[i] = b[i];

    //System.out.println(Arrays.toString(a));
    count = 0;
    startTime = System.currentTimeMillis();
    insertionSort(a);
    endTime = System.currentTimeMillis();
    elapsedTime = endTime - startTime;
    //System.out.println(Arrays.toString(a));
    System.out.println("Insertion Sort took "+ count + " moves to sort "+ size + " items");
    System.out.println("\t in : "+ elapsedTime + " millesec");

    count = 0;
    for (int i = 0; i < size; i++)
    a[i] = b[i];

    //System.out.println(Arrays.toString(a));
    count = 0;
    startTime = System.currentTimeMillis();
    shellSort(a);
    endTime = System.currentTimeMillis();
    elapsedTime = endTime - startTime;
    //System.out.println(Arrays.toString(a));
    System.out.println("Shell Sort took "+ count + " moves to sort "+ size + " items");
    System.out.println("\t in : "+ elapsedTime + " millesec");

    count = 0;
    for (int i = 0; i < size; i++)
    a[i] = b[i];

    //System.out.println(Arrays.toString(a));
    count = 0;
    startTime = System.currentTimeMillis();
    Arrays.sort(a);
    endTime = System.currentTimeMillis();
    elapsedTime = endTime - startTime;
    //System.out.println(Arrays.toString(a));
    System.out.println("sort "+ size + " items");
    System.out.println("\t in : "+ elapsedTime + " millesec");

  }
  public static <AnyType extends Comparable<? super AnyType>>
  void bubblesort(AnyType[] a) { //Runtime of O(n^2)
    for (int i = 0; i < a.length; i++) {
      for (int j = 0; j < a.length - 1; j++) {
        if (a[j].compareTo(a[j + 1]) > 0) {
          AnyType tmp = a[j];
          count++;
          a[j] = a[j + 1];
          count++;
          a[j + 1] = tmp;
          count++;
        }
      }
    }
  }
  public static <AnyType extends Comparable<? super AnyType>> void insertionSort(AnyType[] a){ //big O(n^2)
    for(int i = 1; i < a.length; i++){
      int j = i;
      while (j > 0 && (a[j-1].compareTo(a[j]) > 0)){
        AnyType temp = a[j];
        a[j] = a[j-1];
        count++;
        a[j-1] = temp;
        count++;
        j--;
      }
    }
  }
  public static <AnyType extends Comparable<? super AnyType>> void shellSort(AnyType[] a){ //based off of code from the textbook
    //O(n^3/2)
    //as apposed to the standard O(n^2) of shell sort
    int j;
    for(int x = (int) Math.log(a.length) + 1; x > 0; x--){
      int gap = (int) Math.pow(2,x) - 1;
      for(int i = gap; i < a.length; i++){
        AnyType temp = a[i];
        for (j = i; j >= gap && temp.compareTo(a[j-gap])<0; j -= gap){
          a[ j ] = a[ j - gap ];
          count++;
        }
        a[ j ] = temp;
        count++;
      }
    }
  }
}
