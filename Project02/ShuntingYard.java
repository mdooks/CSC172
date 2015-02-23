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
      in = new BufferedReader(new FileReader( new File("./equations.txt")));
    }catch(FileNotFoundException e){

    }
  }

  public void postfix (){
    try {
      while(in.ready()){
        String line = in.readLine();
        String[] tokens = line.split(" ");
        if
      }
    }catch(IOException e) {

    }
  }
}
