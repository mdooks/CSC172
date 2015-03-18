public class myHeap implements Heap {
  Comparable h[];
  public myHeap(){
    h = new Comparable[11]; //11 cause 0 is null so 1-10 gives cap. of 10
  }
  public myHeap(int l){
    h = new Comparable[l];
  }
  public myHeap(Integer[] l){
    h = new Comparable[l.length + 1];
    h[0] = null;
    for(int i = 0; i < l.length; i++){ //shift the thing so that the first one is null.
      h[i+1] = l[i];
    }
    heapify();
  }
  public int size(){
    int s = 0;
    for (Comparable c : h){
      if (c !=null){
        s++;
      }
    }
    return s;
  }

  public boolean isEmpty(){
    return (h[1] == null);
  }

  public void insert(Comparable in){
    if (size() >= h.length - 1){
      expand();
    }
    if(size() + 1 < h.length){
      h[size()+1] = in;
      bubbleUp();
    }
  }
  private void bubbleUp(){
    int index = size();
    while(index != 1){
      if (h[index].compareTo(h[index/2]) == -1){
        Comparable temp = h[index];
        h[index] = h[index/2];
        h[index/2] = temp;
        index = index/2;
      }
      else
        break;
    }
  }
  /*private void bubbleDown(int index){
    int index = 1;
    while(h[2*index] != null || h[2*index+1] != null){
      if(h[index].compareTo(h[2*index])==-1 || h[index].compareTo(h[2*index + 1])==-1){

        if (h[2*index].compareTo(h[2*index + 1]) == 1){
          Comparable temp = h[index];
          h[index] = h[2*index];
          h[2*index] = temp;
          index = 2*index;
        }
        else{
          Comparable temp = h[index];
          h[index] = h[2*index + 1];
          h[2*index + 1] = temp;
          index = 2*index + 1;

        }
      }
    }
  }*/
  public void bubbleDown(int index){ //based off the method from the book.
    Comparable t = h[index];
    int child;
    while (2*index <= size()+1){
      child = index * 2;
      if (child != size() && h[child].compareTo(h[child+1]) > 0){
        child++;
      }
      if (h[index].compareTo(h[child]) > 0){
        h[index] = h[child];
      }
      else{
        break;
      }
      index = child;
      h[index] = t;
    }

  }
  public void printHeap(){
    for (Comparable c : h){
      if (c !=null){
        System.out.println(c);
      }
    }
    System.out.println();
  }
  public Comparable deleteMin(){
    Comparable ans = h[1];
    h[1] = h[size()];
    h[size()] = null;
    bubbleDown(1);
    return ans;
  }
  public void heapify(){ //take n/2 push everithing befor it down
    for (int i = size()/2 ; i > 0; i--){
      bubbleDown(i);
    }
    //bubbleDown(1); //run the bubble down, will force it to heap.
    //bubbleUp();
  }

  public void expand(){
    Comparable new_h[] = new Comparable[2 * h.length];
    for (int i = 0; i < h.length; i++){
      new_h[i] = h[i];
    }
    h = new_h;
  }
}
