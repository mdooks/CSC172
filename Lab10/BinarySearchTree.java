public class BinarySearchTree<T extends Comparable<T>> implements BST<T>{
  private MyTreeNode<T> root;

  public BinarySearchTree(){
    root = new MyTreeNode<T>();
  }

  public void insert(T in){
    if ((lookup(in))){
      return;
    }
    if (root.data == null){
      root.data = in;
    }
    else
      root.insert(root, in);
  }

  public void printPreOrder(){
    if (root.data != null)
      root.printPreOrder();
  }
  public void printInOrder(){
    if (root.data != null)
      root.printInOrder();
  }
  public void printPostOrder(){
    if(root.data != null)
      root.printPostOrder();
  }
  public void delete(T x){
    if (!(lookup(x)) || root == null){
      return;
    }
    else{
      root.delete(x);
    }
  }
  public boolean lookup(T x){
    if (root.data !=null)
      if(root.lookup(x))
        return true;

    return false;
  }

}
