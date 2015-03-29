public class line {
  point start;
  point end;

  public line (point xval, point yval){
    start = xval;
    end = yval;

    start.parent = this;
    end.parent = this;
  }

  public line (double s1, double s2, double e1, double e2){
    start = new point (s1, s2);
    end = new point (e1, e2);

    start.parent = this;
    end.parent = this;
  }

  public boolean equals (Object o){
    line b = (line) o;
    if ((start.x == b.start.x) && (start.y == b.start.y) && (end.x == b.end.x) && (end.y == b.end.y)) {
      return true;
    }
    return false;
  }

  public String toString (){
    return ("(" + start + " " + end + ")");
  }

}
