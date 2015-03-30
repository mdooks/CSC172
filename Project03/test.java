import java.util.Scanner;

public class test {
  public static void main(String[] args){
    Scanner input = new Scanner(System.in); //set up scanner

    System.out.println("Enter the number of lines, then enter the lines in the following format:\n#\nx1 y1 x2 y2");
    int num_lines = input.nextInt();

    line L[] = new line[num_lines];

    for(int i = 0; i < num_lines; i++){
      L[i] = new line(input.nextFloat(), input.nextFloat(), input.nextFloat(), input.nextFloat());
    }

    BinarySearchTree bst = new BinarySearchTree();

    for (line l : L){
      bst.insert(l);
    }
    bst.printInOrder();

    System.out.println("Enter the points you want to test in the same way as before:");

    while (true) {
      bst.sameRegion(new point(input.nextFloat(), input.nextFloat()), new point (input.nextFloat(), input.nextFloat()));
    }
    /*
    point a = new point(0,1);
    point b = new point(1,0);
    point c = new point(0,0);
    point d = new point(1,1);

    BinarySearchTree bst = new BinarySearchTree();
    line l1 = new line(a, b);
    line l2 = new line(c, d);
    bst.insert(l1);
    bst.sameRegion(new point(0.25, 0.5), new point (0.5, 0.75));
    bst.sameRegion(new point(0.25, 0.5), new point (0.5, 0.25));

    System.out.println();

    bst.insert(l2);
    bst.sameRegion(new point(0.25, 0.5), new point (0.5, 0.75));
    bst.sameRegion(new point(0.25, 0.5), new point (0.5, 0.25));
    bst.sameRegion(new point(0.25, 0.5), new point (0.1, 0.6));

    System.out.println();

    line one = new line(0, 0, 0.5, 1);

    bst.insert(one);
    bst.clear();

    line two = new line(0, 0, 0.666667, 1);
    line three = new line(0, 0.2, 1, 0.7);


    bst.insert(one);
    bst.insert(two);
    bst.insert(three);

    bst.sameRegion(new point(0.2, 0.1), new point(0.4, 0.1));
    bst.sameRegion(new point(0.2, 0.1), new point(0.4, 0.5));
    bst.sameRegion(new point(0.4, 0.4), new point(0.1, 0.4));

    bst.clear();
    */

  }
}
