public class QueueTest {
  public static void main(String[] args){
    MyQueue<String> test = new MyQueue<String>();
    test.enqueue("H");
    test.enqueue("e");
    test.enqueue("l");
    test.enqueue("o");
    System.out.println("Is the stack empty? " + test.isEmpty());
    System.out.println("Peek at the first item: " + test.peek());
    System.out.println("Pop: " + test.dequeue());
    System.out.println("Pop: " + test.dequeue());
    System.out.println("Peek again: " + test.peek());
  }
}
