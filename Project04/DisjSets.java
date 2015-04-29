
import java.util.HashMap;
public class DisjSets { //based off the code in the book

  HashMap<String, SetNode> nodeMap;
  private int[] s;
  public DisjSets(int num){
    nodeMap = new HashMap<String, SetNode>();
    s = new int[num];
    for (int i =0; i< s.length; i++){
      s[i] = -1;
    }
  }
  public void union(String r1, String r2){
    SetNode one = nodeMap.get(r1);
    SetNode two = nodeMap.get(r2);
    two.union(one);
    //s[r2] = r1;
  }

  public SetNode find (String x){
    return nodeMap.get(x);
  }
}
