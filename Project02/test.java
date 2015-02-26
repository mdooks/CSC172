public class test{
  public static void main(String[] args){
    ShuntingYard sy = new ShuntingYard();
    sy.postfix();
    sy.expressionStack.printList();
    sy.expressionQueue.printList();
  }
}
