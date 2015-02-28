public class Calc {
  public static Double calc(Queue<String> expressionQueue){
    Stack<String> expressionStack = new Stack<String>();
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

  public static boolean operator(String t){
    String[] op = {"+", "-", "*", "/", "(", ")", "<", ">", "=", "&", "|", "!"};
    for (String o : op){
      if (o.equals(t))
      return true;
    }
    return false;
  }

  public static String math(String a, String b, String ex){
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
