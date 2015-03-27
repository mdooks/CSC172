public class test {
  public static void main(String[] args){
    point a = new point(0,1);
    point b = new point(1,0);
    point c = new point(0,0);
    point d = new point(1,1);
    System.out.println(a);
    System.out.println(b);
    System.out.println(c);
    System.out.println(d);
    line one = new line(a,b);
    line two = new line(c,d);
    System.out.println(one);
    System.out.println(two);

    System.out.println(Geometry.intersect(one, two));
  }
}
