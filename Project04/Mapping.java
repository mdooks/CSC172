/*
* Project 4
*
* Project 4
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Project 4
*
* Author: Nicholas Graham
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: May 2, 2015
*/
import java.util.ArrayList;

public class Mapping {
  public static void main(String[] args){
    String filename = args[0];
    boolean mmap = false;
    boolean direction = false;
    boolean show = false;
    String start ="", end = "";
    try{
      if(args[1].equals("-show")){
        show = true;
        if (args[2].equals("-meridianmap")){
          mmap = true;
        }
        else if(args[2].equals("-directions")){
          direction = true;
          start = args[3];
          end = args[4];
        }
      }
      else{
        if (args[1].equals("-meridianmap")){
          mmap = true;
        }
        else if(args[1].equals("-directions")){
          direction = true;
          start = args[2];
          end = args[3];
        }
      }

      Graph t = Graph.createFromFile(filename);
      if (mmap == true){
        ArrayList<Edge> ans = t.Prim("i15");
        if(show){
          t.mspShow();
        }
        else{
          for (Edge e : ans){
            System.out.print(e.name + ", ");
          }
          System.out.println();
        }
      }
      else if (direction == true){
        if(show){
          t.shortPath(start, end, false);
          t.directionShow();
        }
        else{
          t.shortPath(start, end, true);
        }
      }
      else{
        throw new Exception();
      }


    }catch(Exception l){
      System.out.println("That was not a valid input. Please use the following format:");
      System.out.println("java Mapping map.txt [-show] [-directions startingIntersection endingIntersection] [-meridianmap]");
    }
  }
}
