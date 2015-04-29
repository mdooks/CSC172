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
    return (id.equals(that));
  }
}
