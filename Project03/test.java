public class test {
  public static void main(String[] args){
    point a = new point(0,1);
    point b = new point(1,0);
    point c = new point(0,0);
    point d = new point(1,1);
    //System.out.println(a);
    /*System.out.println(b);
    System.out.println(c);
    System.out.println(d);*/
    /*line one = new line(a,b);
    line two = new line(c,d);
    line three = new line(0, 0.2, 1, 0.7);*/
    /*System.out.println(one);
    System.out.println(two);

    System.out.println(one.start.parent);
    System.out.println(one.end.parent);*/

    //System.out.println(Geometry.intersect(one, two));
    /*
    BinarySearchTree bst = new BinarySearchTree();
    bst.insert(one);
    bst.printInOrder();
    System.out.println();

    bst.insert(two);
    bst.printInOrder();
    System.out.println();

    bst.insert(three);
    bst.printInOrder();
 */
    line one = new line(0, 0, 0.5, 1);
    line two = new line(0, 0, 0.666667, 1);
    line three = new line(0, 0.2, 1, 0.7);

    Geometry.intersect(one, three);
    Geometry.intersect(two, three);

    BinarySearchTree bst = new BinarySearchTree();
    /*
    if (Geometry.ccw(one.start, one.end, three.start) == Geometry.direction.CLOCKWISE){
      System.out.println("Clockwise");
    }
    if (Geometry.ccw(one.start, one.end, three.start) == Geometry.direction.COUNTERCLOCKWISE){
      System.out.println("CClockwise");
    }
    if (Geometry.ccw(one.start, one.end, three.start) == Geometry.direction.COLINEAR){
      System.out.println("Colinear");
    }

    if (Geometry.ccw(one.start, one.end, three.end) == Geometry.direction.CLOCKWISE){
      System.out.println("Clockwise");
    }
    if (Geometry.ccw(one.start, one.end, three.end) == Geometry.direction.COUNTERCLOCKWISE){
      System.out.println("CClockwise");
    }
    if (Geometry.ccw(one.start, one.end, three.end) == Geometry.direction.COLINEAR){
      System.out.println("Colinear");
    }
    */
    
    bst.insert(one);
    bst.printPreOrder();
    System.out.println();

    bst.insert(two);
    bst.printPreOrder();
    System.out.println();

    bst.insert(three);
    bst.printPreOrder();
    System.out.println();

    //System.out.println(bst.getRoot().rightChild.leftChild.data);
  }
}
