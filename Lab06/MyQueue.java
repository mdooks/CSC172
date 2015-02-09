public class MyQueue<AnyType> implements Queue<AnyType>{
  MyDoublyLinkedList<AnyType> queueList;
  public MyQueue() {
    queueList = new MyDoublyLinkedList<AnyType>();
  }
  public boolean isEmpty(){
    return queueList.isEmpty();
  }
  public void enqueue(AnyType x){
    queueList.insert(x);
  }
  public AnyType dequeue(){
    if(! isEmpty()){
      AnyType ans = queueList.firstItem();
      queueList.delete();
      return ans;
    }
    else{
      return null;
    }
  }
  public AnyType peek(){
    if (! isEmpty()){
      return queueList.firstItem();
    }
    else{
      return null;
    }
  }
}
