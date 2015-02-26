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
        String[] tokens = line.split("\\s");
        for(String t : tokens){
          System.out.println(t);
          if(t.equals("")){ //remove the null things added into the list

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
}
