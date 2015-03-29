public class Geometry {
  public enum direction{
    CLOCKWISE, COUNTERCLOCKWISE, COLINEAR
  }
  public static direction ccw (point p0, point p1, point p2){ //method taken from the lab assignment
    double dx1 = p1.getX() - p0.getX(); //get the slope of the line made by points 0 & 1
    double dy1 = p1.getY() - p0.getY();

    double dx2 = p2.getX() - p0.getX(); //get slope of line made by points 0 & 2
    double dy2 = p2.getY() - p0.getY();

    //System.out.println(dx1 + ", " + dy1 + ", " + dx2 + ", " + dy2 + ", ");

    if (dx1*dy2 > dx2*dy1) {
      //System.out.println("First");
      return direction.COUNTERCLOCKWISE;
    }
    else if (dx1*dy2 < dx2*dy1){
      //System.out.println("Second");
      return direction.CLOCKWISE;
    }
    else if ((dx1*dx2 < 0) || (dy1 * dy2 < 0)){
      //System.out.println("Third");
      return direction.CLOCKWISE;
    }
    else if ((dx1*dx1 + dy1*dy1) < (dx2*dx2 + dy2*dy2)){
      //System.out.println("Fourth");
      return direction.COUNTERCLOCKWISE;
    }
    else {
      //System.out.println("Fifth");
      return direction.COLINEAR;
    }

  }

  public static point intersect (line a, line b){
    double m1 = slope(a); // find the slopes of the line
    double m2 = slope(b);

    double x01 = a.start.getX(); //get the starting x points
    double x02 = b.start.getX();

    double y01 = a.start.getY(); //and the starting y points
    double y02 = b.start.getY();

    double ansX = ((m1 * x01 - y01 - m2*x02 + y02)/(m1-m2));
    double ansY = m1 * (ansX - x01) + y01;
    System.out.println(ansX + ", " + ansY);
    point ans = new point(ansX, ansY);
    if (a.start.getX() > ans.getX() || a.end.getX() < ans.getX()){
      System.out.println("Out of bounds: " + ans);

      return new point (-10, -10);
    }
    if (a.start.equals(ans) || a.end.equals(ans)){
      System.out.println("end point");
      return new point (-10,-10);
    }
    return ans;

  }
  public static double slope (line a){
    double dx = a.end.getX() - a.start.getX();
    double dy = a.end.getY() - a.start.getY();
    return (dy/dx);
  }
}
