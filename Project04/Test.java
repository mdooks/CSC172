import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test {
  public static void main (String[] args){
    long s = System.currentTimeMillis();
    Graph t = Graph.createFromFile("CSC172SP15_project4_data/ur.txt");
    /*for (Node n : t.nodeMap.values()){
      //System.out.println(n.name);
    }*/
    System.out.println(t.vertices()+ " Vert");
    long e = System.currentTimeMillis();
    System.out.println(e-s);
    //t.shortPath("GOERGEN-ATHLETIC", "CSB");
    t.shortPath("i15", "i32");
    long e2 = System.currentTimeMillis();
    System.out.println(e2-s);
    //t.Kruskal(new ArrayList<Edge>(t.edgeMap.values()), t.vertices());
    ArrayList<Edge> ans = t.Prim("i15");

    for(Edge r : ans){
      System.out.println(r.name);
    }
    //t.parentPrinter();

    Atlas window = new Atlas("Test");
    Canvas theMap = new Canvas(t.nodeMap, t.edgeMap);
    window.add(theMap);
    window.setLayout(new BorderLayout());
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //exit program when the windiow is closed
		window.setResizable(true); 
    window.pack(); //prepare window to be displayed
    window.setSize(400,400); //set size
    window.add(theMap);
    window.setVisible(true);
  }
}
