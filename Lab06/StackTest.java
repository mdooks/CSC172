public class StackTest {
  public static void main(String[] args){
    MyStack<String> test = new MyStack<String>();
    test.push("H");
    test.push("e");
    test.push("l");
    test.push("o");
    System.out.println("Is the stack empty? " + test.isEmpty());
    System.out.println("Peak at the first item: " + test.peek());
    System.out.println("Pop: " + test.pop());
    System.out.println("Pop: " + test.pop());
    System.out.println("Peak again: " + test.peek());
  }
}
