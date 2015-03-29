public class point {
  double x;
  double y;

  line parent;
  public point (double xval, double yval){
    setX(xval);
    setY(yval);
  }

  public double getX(){
    return x;
  }
  public double getY(){
    return y;
  }

  public void setX(double a){
    if (a >= 0 && a <= 1 && y !=-10){
      x = a;
    }
    else{
      x = -10;
      y = -10;
      //System.out.println("Invalid input point");
    }
  }
  public void setY(double a){
    if (a >= 0 && a <= 1 && x != -10){
      y = a;
    }
    else{
      y = -10;
      //System.out.println("Invalid input point");
    }
  }

  public boolean equals(Object o){
    point b = (point) o;
    if (this.x == b.x && this.y == b.y){
      return true;
    }
    return false;
  }
  public String toString() {
    return ("(" + this.getX() + "," + this.getY() +")");
  }
}
