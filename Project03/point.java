public class point {
  double x;
  double y;
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
    if (a >= 0 && a <= 1){
      x = a;
    }
    else{
      System.out.println("Invalid input point");
    }
  }
  public void setY(double a){
    if (a >= 0 && a <= 1){
      y = a;
    }
    else{
      System.out.println("Invalid input point");
    }
  }

  public String toString() {
    return ("(" + this.getX() + "," + this.getY() +")");
  }
}
