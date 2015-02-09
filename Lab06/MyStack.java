public class MyStack<AnyType> implements Stack<AnyType> {
  MyLinkedList<AnyType> stackList;
  public MyStack(){
    stackList = new MyLinkedList<AnyType>();
  }

  public boolean isEmpty(){
    return stackList.isEmpty();
  }
  public void push(AnyType x){
    stackList.insert(x);
  }

  public AnyType pop() {
    if (! isEmpty()){
      AnyType ans = stackList.firstItem();
      stackList.delete();
      return ans;
    }
    return null;

  }
  public AnyType peek(){
    if (! isEmpty()){
      return stackList.firstItem();
    }
    return null;
  }
}
