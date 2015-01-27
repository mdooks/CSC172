public class test {
  public static void main (String[] args){
    //set up list with String an Integer to test, but other classes could be used
    MyLinkedList<String> t = new MyLinkedList<String>();
    MyLinkedList<Integer> i = new MyLinkedList<Integer>();

    if(t.isEmpty()){
      System.out.println("The String list is empty");
    }
    else{
      System.out.println("The String list is not empty");
    }
    if(i.isEmpty()){
      System.out.println("The Int list is empty");
    }
    else{
      System.out.println("The Int list is not empty");
    }

    //Add Items to the String list
    t.insert("h");
    t.insert("e");
    t.insert("l");
    t.insert("l"); //this will not be added because there is already an l
    t.insert("o");
    t.insert("1");
    t.insert("2");
    t.insert("3");
    t.printList();
    i.insert(1);
    i.insert(2);
    i.insert(3);
    i.insert(4); //this will not be added because there is already an l
    i.insert(5);
    i.insert(6);
    i.insert(7);
    i.insert(8);
    i.printList();

    //Test the lookup function
    if(t.lookup("r")){
      System.out.println("There is an 'r' in the String list");
    }
    else{
      System.out.println("There is no 'r' in the String list");
    }
    if(t.lookup("o")){
      System.out.println("There is an 'o' in the String list");
    }
    else{
      System.out.println("There is no 'o' in the String list");
    }
    if(i.lookup(2)){
      System.out.println("There is an '2' in the Int list");
    }
    else{
      System.out.println("There is no '2' in the int list");
    }
    if(i.lookup(13)){
      System.out.println("There is an '13' in the Int list");
    }
    else{
      System.out.println("There is no '13' in the Int list");
    }

    //test the delete function
    t.delete("l");
    t.printList();
    System.out.println();

    t.delete("0"); //will do nothing because the is no 0
    t.printList();
    System.out.println();

    t.delete("o");
    t.printList();

    t.insert("pop"); //insert something in the list
    System.out.println();

    t.printList();
    System.out.println();

    t.delete("h"); //continue deleting
    t.printList();
    System.out.println();

    t.delete("e");
    t.printList();
    System.out.println();

    i.delete(1);
    i.printList();
    System.out.println();

    i.delete(3); //will do nothing because the is no 0
    i.printList();
    System.out.println();

    i.delete(5);
    i.printList();

    i.insert(100); //insert something in the list
    System.out.println();

  }
}
