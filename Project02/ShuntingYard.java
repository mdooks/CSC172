import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
public class ShuntingYard {
  public Stack<String> expressionStack;
  public Queue<String> expressionQueue;
  public BufferedReader in;
  public PrintWriter writer;

  public ShuntingYard (){
    expressionStack = new Stack<String>();
    expressionQueue = new Queue<String>();
  }

  public Queue postfix (String eq){
    expressionQueue.clear();
    String[] tokens = tokenize2(eq);

    for(String t : tokens){
      if(t == (null) || t.equals("")){ //remove the null things added into the list
        //I should work on finding a way that doesn't result in nulls in the array but it works for now so...
      }
      else if (Calc.operator(t)){
        if(t.equals(")")){
          while (!expressionStack.isEmpty() && true){
            String temp = expressionStack.pop();
            if (temp.equals("(")){
              break;
            }
            expressionQueue.enqueue(temp);
          }
        }
        else if (t.equals("(")){
          expressionStack.push(t);
        }
        else if (!expressionStack.isEmpty()){
          while(!expressionStack.isEmpty() && presidence(t, expressionStack.peek())){
            expressionQueue.enqueue(expressionStack.pop());
          }
          expressionStack.push(t);
        }
        else{
          expressionStack.push(t);
        }
      }
      else{
        expressionQueue.enqueue(t);
      }
    }
    while (!expressionStack.isEmpty()){
      expressionQueue.enqueue(expressionStack.pop());
    }
    return expressionQueue;
  }

  public boolean presidence(String a, String b){
    int presA = 0;
    int presB = 0;
    String top[] = {"^"}; //will have top presidence, in this case 8
    String mul[] = {"*", "/"}; //will have presidence 7
    String add[] = {"+", "-"}; //presidence 6
    String not[] = {"!"}; //presidence 5
    String com[] = {"<", ">"}; //presidence 4
    String equ[] = {"="}; //presidence 3
    String and[] = {"&"}; //presidence 2
    String or[] = {"|"}; //presidence 1
    String paren[] = {"(", ")"};
    for (String o : top){
      if (a.equals(o))
      presA = 8;
      if (b.equals(o))
      presB = 8;
    }
    for (String o : mul){
      if (a.equals(o))
      presA = 7;
      if (b.equals(o))
      presB = 7;
    }
    for (String o : add){
      if (a.equals(o))
      presA = 6;
      if (b.equals(o))
      presB = 6;
    }
    for (String o : not){
      if (a.equals(o))
      presA = 5;
      if (b.equals(o))
      presB = 5;
    }
    for (String o : com){
      if (a.equals(o))
      presA = 4;
      if (b.equals(o))
      presB = 4;
    }
    for (String o : equ){
      if (a.equals(o))
      presA = 10;
      if (b.equals(o))
      presB = 10;
    }
    for (String o : and){
      if (a.equals(o))
      presA = 2;
      if (b.equals(o))
      presB = 2;
    }
    for (String o : or){
      if (a.equals(o))
      presA = 1;
      if (b.equals(o))
      presB = 1;
    }
    //System.out.println("A:" + presA + " B:" + presB);
    for (String o : paren){
      if (a.equals(o))
      return false;
      if (b.equals(o))
      return false;
    }
    if (presA > presB)
    return true;
    else
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
      else if( !(Calc.operator(String.valueOf(t.charAt(i+1)))) && !(Calc.operator(String.valueOf(t.charAt(i))))){
        temp = temp + t.charAt(i);
      }
      else if (Calc.operator(String.valueOf(t.charAt(i+1)))){
        res[pos] = temp;
        temp = "";
        pos++;
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

  public String[] tokenize2(String t){
    String[] res = new String[t.length()];
    int pos = 0;
    String temp = "";
    for (int i = 0; i<t.length(); i++){
      if(i == (t.length()-1)){ //test to see what is in here!
        if (Calc.operator(String.valueOf(t.charAt(i)))){
          res[pos] = temp;
          temp ="";
          pos++;
        }
        temp = temp+t.charAt(i);
        res[pos] = temp;
        temp = "";
        pos++;
      }
      else if(t.charAt(i) == ' '){
        res[pos] = temp;
        temp ="";
        pos++;
      }
      else if (Calc.operator(String.valueOf(t.charAt(i)))){
        if (!(temp.equals(""))){
          res[pos] = temp;
          temp ="";
          pos++;
        }

        res[pos] = String.valueOf(t.charAt(i));
        temp = "";
        pos++;
      }
      else{
        temp = temp+t.charAt(i);
      }
    }
    return res;
  }

}
