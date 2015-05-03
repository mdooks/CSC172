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

public class SetNode {
  String id;
  SetNode SetLeader;
  public SetNode(String i){
    id = i;
  }

  public void union (SetNode x){
    SetLeader = x;
  }

  public boolean equals(SetNode that){
    return (id.equals(that.id));
  }
}
