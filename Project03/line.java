public class line {
  point start;
  point end;

  public line (point xval, point yval){
    start = xval;
    end = yval;
  }

  public line (double s1, double s2, double e1, double e2){
    start = new point (s1, s2);
    end = new point (e1, e2);
  }

  public String toString (){
    return ("(" + start + " " + end + ")");
  }

}
