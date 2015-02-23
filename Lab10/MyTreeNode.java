//from lab writeup
public class MyTreeNode<T extends Comparable<T>>{
  public T data;
  public MyTreeNode<T> leftChild;
  public MyTreeNode<T> rightChild;
  public MyTreeNode<T> parent;

  public MyTreeNode insert(MyTreeNode<T> n, T in){
    if (n == null){
      n = new MyTreeNode<T>();
      n.data = in;
    }

    else if (in.compareTo(n.data) > 0){
      n.rightChild = insert(n.rightChild, in);
      n.rightChild.parent = n;
    }
    else {
      n.leftChild = insert(n.leftChild, in);
      n.leftChild.parent = n;
    }

    return n;
  }

  public void printInOrder(){
    if(leftChild !=null)
      leftChild.printInOrder();
    System.out.println(data);
    if (rightChild !=null)
      rightChild.printInOrder();
  }
  public void printPostOrder(){
    if(leftChild !=null)
      leftChild.printInOrder();

    if (rightChild !=null)
      rightChild.printInOrder();
    System.out.println(data);
  }
  public void printPreOrder(){
    System.out.println(data);
    if(leftChild !=null)
      leftChild.printInOrder();

    if (rightChild !=null)
      rightChild.printInOrder();
  }

  public boolean lookup(T x){
    if (x.equals(data)){
      return true;
    }
    else if (x.compareTo(data) > 0 && rightChild != null)
      return rightChild.lookup(x);
    else if ((x.compareTo(data) < 0 && leftChild != null))
      return leftChild.lookup(x);

    return false;
  }

  public void delete(T x){
    if (x.equals(data)){

      if (leftChild == null && rightChild == null){
        if (parent.leftChild == this){
          parent.leftChild = null;
        }
        else{
          parent.rightChild = null;
        }
      }
      else if(leftChild == null){
        if (parent.leftChild == this){
          parent.leftChild = rightChild;
          if(rightChild !=null)
            rightChild.parent = parent;
        }
        else{
          parent.rightChild = rightChild;
          if(rightChild !=null)
            rightChild.parent = parent;
        }
      }
      else if(rightChild == null){
        if (parent.leftChild == this){
          parent.leftChild = leftChild;
          if(leftChild != null)
            leftChild.parent = parent;
        }
        else{
          parent.rightChild = leftChild;
          if(leftChild != null)
            leftChild.parent = parent;
        }
      }

      else{
        MyTreeNode<T> e = LmostRchild();
        T temp = e.data;
        delete(e.data);
        data = temp;
        /*if (e.parent.leftChild == this){
          if (e.rightChild != null){
            e.parent.leftChild = e.rightChild;
            e.rightChild.parent = e.parent;
          }
          else{
            e.parent.leftChild = null;
          }
        }
        else{
          if(e.rightChild != null){
            e.parent.rightChild = e.rightChild;
            e.rightChild.parent = e.parent;
          }
          else{
            e.parent.rightChild = null;
          }
        }
        e.data = null;*/
      }
    }
    else if (x.compareTo(data) > 0 && rightChild != null)
      rightChild.delete(x);
    else if ((x.compareTo(data) < 0 && leftChild != null))
      leftChild.delete(x);
  }
  public MyTreeNode<T> LmostRchild(){
    MyTreeNode e = rightChild;

    while (e.leftChild != null){
      e = e.leftChild;
    }
    return e;
  }
}
