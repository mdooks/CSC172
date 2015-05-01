import java.awt.Color; //import Color
import java.awt.Graphics; //import Graphics
import java.awt.Graphics2D; //import 2D graphics
import java.awt.event.KeyEvent; //import KeyEvent
import java.awt.event.KeyListener; //import KeyListener
import javax.swing.JPanel; //import JPanel
import java.util.HashMap;

public class Canvas extends JPanel {

  HashMap<String, Node> nodeMap;
  HashMap<String, Edge> edgeMap;

  private double minLat;
  private double minLong;
  private double maxLat;
  private double maxLong;

  private double yUnit;
  private double xUnit;


  public Canvas(HashMap<String, Node> nM, HashMap<String, Edge> eM){
    setFocusable(true);
    nodeMap = nM;
    edgeMap = eM;
    double[] extreme = extrema();
    minLat = extreme[0];
    maxLat = extreme[1];
    minLong = extreme[2];
    maxLong = extreme[3];
  }

  protected void paintComponent(Graphics g){
    super.paintComponent(g);
    Graphics2D g2d = (Graphics2D) g.create();
    //yUnit = getHeight()/(maxLong - minLong);
    //xUnit = getWidth()/(maxLat - minLat);

    xUnit = getWidth()/(maxLong - minLong);
    yUnit = getHeight()/(maxLat - minLat);
    
    System.out.println("xUnit " + xUnit + " yUnit " + yUnit);
    System.out.println("minLat: " + minLat + " maxLat: " + maxLat + " minLong: " + minLong + " maxLong: " + maxLong);
    edgePainter(g2d);
    //g2d.drawLine((int) (maxLong * xUnit - minLong * xUnit), (int) ((Math.abs(-1*maxLat + Math.abs(minLat)) * yUnit)) , (int) (minLong * xUnit - minLong * xUnit),(int) (( Math.abs(minLat - Math.abs(minLat)) * yUnit)));

  }

  public void edgePainter(Graphics g2d){
    for (Edge e : edgeMap.values()){
      Node a = nodeMap.get(e.w);
      Node b = nodeMap.get(e.v);
      //System.out.println((a.lon * xUnit) + " " + (a.lat * yUnit) + getHeight() );
      int x1 = (int) ((getHeight() - Math.abs(a.lat - Math.abs(minLat)) * yUnit));
      int y1 = (int) (((a.lon * xUnit)) - minLong * xUnit);
      int x2 = (int) ((getHeight() - Math.abs(b.lat - Math.abs(minLat)) * yUnit));
      int y2 = (int) (((b.lon * xUnit)) - minLong * xUnit);
      System.out.println(y1 + " " + x1 + " " +  y2 + " " + x2 );
      g2d.drawLine(y1,x1, y2,x2);
    }
  }

  public double[] extrema(){
    double[] ex = {Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
    for (Node n : nodeMap.values()){
      if (n.lat < ex[0]){
        ex[0]=n.lat;
      }
      if (n.lat > ex[1]){
        ex[1]=n.lat;
      }
      if (n.lon < ex[2]){
        ex[2]=n.lon;
      }
      if (n.lon > ex[3]){
        ex[3]=n.lon;
      }
    }
    return ex;
  }
}
