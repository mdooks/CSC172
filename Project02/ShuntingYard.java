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

  public ShuntingYard (String inFile, String outFile){
    expressionStack = new Stack<String>();
    expressionQueue = new Queue<String>();
    try{
      writer = new PrintWriter(outFile, "UTF-8");
      in = new BufferedReader(new FileReader( new File(inFile)));
    }catch(FileNotFoundException e){
      System.out.println(e);
    }catch(UnsupportedEncodingException e){
      System.out.println(e);
    }


  }

  public void postfix (){
    //System.out.println(operator("!"));
    //System.out.println(operator("("));
    try {
      while(in.ready()){
        String line = in.readLine();
        //String[] tokens = line.split("\\s");
        String[] tokens = tokenize2(line);

        for(String t : tokens){
          //System.out.print(t);
          //System.out.println(t);
          if(t == (null) || t.equals("")){ //remove the null things added into the list
            //I should work on finding a way that doesn't result in nulls in the array but it works for now so...
          }
          else if (operator(t)){
            //System.out.print("OPERATOR:");
            //expressionStack.printList();
            //expressionQueue.printList();
            if(t.equals(")")){
              //System.out.print("PAREN:");
              while (!expressionStack.isEmpty() && true){
                String temp = expressionStack.pop();
                //System.out.println("TEMP: " + temp);
                if (temp.equals("(")){
                  break;
                }
                expressionQueue.enqueue(temp);
              }
            }
            else if (t.equals("(")){
              //System.out.print("PARENPPUSH:");
              expressionStack.push(t);
            }
            else if (!expressionStack.isEmpty()){
              //System.out.print("PRES:");
              //System.out.println(expressionStack.peek());
              //System.out.println(presidence(t, expressionStack.peek()));
              while(!expressionStack.isEmpty() && presidence(t, expressionStack.peek())){
                expressionQueue.enqueue(expressionStack.pop());
                //expressionQueue.printList();
              }
              //expressionQueue.enqueue(expressionStack.pop());
              expressionStack.push(t);
            }
            else{
              //System.out.print("PUSH:");
              expressionStack.push(t);
            }
          }
          //
          else{
            expressionQueue.enqueue(t);
          }
        }
        while (!expressionStack.isEmpty()){
          expressionQueue.enqueue(expressionStack.pop());
        }
        //pass the queue on to do the actual math here.
        //expressionQueue.printList();
        writer.printf("%.2f\n", calc());
        //System.out.println();
        expressionQueue.clear();
      }
    }catch(IOException e) {
      System.out.println(e);
    }
    writer.close();
  }

  public boolean operator(String t){
    String[] op = {"+", "-", "*", "/", "(", ")", "<", ">", "=", "&", "|", "!"};
    for (String o : op){
      if (o.equals(t))
      return true;
    }
    return false;
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
      else if( !(operator(String.valueOf(t.charAt(i+1)))) && !(operator(String.valueOf(t.charAt(i))))){
        temp = temp + t.charAt(i);
      }
      else if (operator(String.valueOf(t.charAt(i+1)))){
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
        if (operator(String.valueOf(t.charAt(i)))){
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
      else if (operator(String.valueOf(t.charAt(i)))){
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
  public Double calc(){
    expressionStack.clear();
    while (!expressionQueue.isEmpty()){
      if (operator(expressionQueue.peek())){
        String ex = expressionQueue.dequeue();
        String a;
        String b;
        if(ex.equals("!")){
          a = expressionStack.pop();
          b = "";
        }
        else{
          a = expressionStack.pop();
          b = expressionStack.pop();
        }
        expressionStack.push(math(a,b,ex));
      }
      else{
        expressionStack.push(expressionQueue.dequeue());
      }
    }
    return (new Double(expressionStack.pop()));
  }
  public String math(String a, String b, String ex){
    if (ex.equals("!")){
      if(a.equals("1"))
        return("0");
      return ("1");
    }
    Double newA = new Double(a);
    Double newB = new Double(b);
    if (ex.equals("=")){
      if(newA.equals(newB))
        return("1");
      return ("0");
    }
    if (ex.equals("<")){
      if(newB < newA)
        return("1");
      return ("0");
    }
    if (ex.equals(">")){
      if(newB > newA)
        return("1");
      return ("0");
    }
    if (ex.equals("&")){
      if(!a.equals("0") && !b.equals("0"))
        return("1");
      return ("0");
    }
    if (ex.equals("|")){
      if(!a.equals("0") || !b.equals("0"))
        return("1");
      return ("0");
    }
    else if (ex.equals("+")){
      return ("" + (newA + newB));
    }
    else if (ex.equals("-"))
      return("" + (newB - newA));
    else if (ex.equals("*"))
      return("" + (newB * newA));
    else if (ex.equals("/"))
      return("" + (newB / newA));
    else
      return "";
  }
}
