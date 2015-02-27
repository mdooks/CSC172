public class test{
  public static void main(String[] args){
    ShuntingYard sy = new ShuntingYard();
    System.out.println(sy.presidence("=", "*"));
    sy.postfix();
    sy.expressionStack.printList();
    sy.expressionQueue.printList();
  }
}
