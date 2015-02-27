public class test{
  public static void main(String[] args){
    if (args.length < 2){
      System.out.println("I'm sorry there aren't enough arguments. Please enter the source file and destination file when you run the program.");
    }
    else{
      ShuntingYard sy = new ShuntingYard(args[0], args [1]);
      //System.out.println(sy.presidence("=", "*"));
      sy.postfix();
      sy.expressionStack.printList();
      sy.expressionQueue.printList();
    }
  }
}
