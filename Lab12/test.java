public class test {
  public static void main(String[] args){
    myHeap heap = new myHeap(2);
    heap.insert(10);
    heap.insert(2);
    heap.insert(5);
    heap.insert(3);
    System.out.println("The size is: " + heap.size());
    heap.printHeap();

    heap.insert(7);
    heap.insert(9);
    heap.insert(88);
    heap.insert(4);
    heap.insert(12);
    heap.insert(24);
    heap.insert(1);

    System.out.println("The size is: " + heap.size());
    heap.printHeap();
    heap.deleteMin();
    heap.printHeap();
    Integer[] l = {10,2,5,3,7,9, 88, 4, 12, 24, 1};
    myHeap IntHeap = new myHeap(l);
    IntHeap.printHeap();
  }
}
