import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
public class ShuntingYard {
  public Stack<String> expressionStack;
  public Queue<String> expressionQueue;
  public BufferedReader in;

  public ShuntingYard (){
    expressionStack = new Stack<String>();
    expressionQueue = new Queue<String>();
    try{
      in = new BufferedReader(new FileReader( new File("equations.txt")));
    }catch(FileNotFoundException e){
      System.out.println(e);
    }
  }

  public void postfix (){
    try {
      while(in.ready()){
        String line = in.readLine();
        //String[] tokens = line.split("\\s");
        String[] tokens = tokenize(line);
        for(String t : tokens){
          System.out.println(t);
          if(t == (null)){ //remove the null things added into the list
            //I should work on finding a way that doesn't result in nulls in the array but it works for now so...
          }
          else if (operator(t))
            expressionStack.push(t);
          else
            expressionQueue.enqueue(t);
        }
      }
    }catch(IOException e) {
      System.out.println(e);
    }
  }

  public boolean operator(String t){
    String[] op = {"+", "-", "*", "/", "(", ")", "<", ">", "=", "&", "|", "!"};
    for (String o : op){
      if (o.equals(t))
        return true;
    }
    return false;
  }

  public String[] tokenize(String t){
    String[] res = new String[t.length()];
    int pos = 0;
    String temp = "";
    for (int i = 0; i<t.length(); i++){
      if(i == (t.length()-1)){
        temp = temp+t.charAt(i);
        res[pos] = temp;
        temp = "";
        pos++;
      }
      else if(t.charAt(i) == ' '){
        //do nothing
      }
      else if (t.charAt(i+1) == '.' || t.charAt(i) == '.'){
        temp = temp + t.charAt(i);
      }
      else{
        temp = temp + t.charAt(i);
        res[pos] = temp;
        temp = "";
        pos++;
      }
    }
    return res;
  }
}
