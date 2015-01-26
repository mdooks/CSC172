public class test {
  public static void main (String[] args){
    MyLinkedList t = new MyLinkedList(); //set up the list

    if(t.isEmpty()){
      System.out.println("The list is empty");
    }

    //Add Items to the list
    t.insert("h");
    t.insert("e");
    t.insert("l");
    t.insert("l"); //this will not be added because there is already an l
    t.insert("o");
    t.insert("1");
    t.insert("2");
    t.insert("3");
    t.printlist();

    //Test the lookup function
    if(t.lookup("r")){
      System.out.println("There is an 'r' in the list");
    }
    else{
      System.out.println("There is no 'r' in the list");
    }
    if(t.lookup("o")){
      System.out.println("There is an 'o' in the list");
    }
    else{
      System.out.println("There is no 'o' in the list");
    }

    //test the delete function
    t.delete("l");
    t.printlist();
    System.out.println();

    t.delete("0"); //will do nothing because the is no 0
    t.printlist();
    System.out.println();

    t.delete("o");
    t.printlist();

    t.insert("pop"); //insert something in the list
    System.out.println();

    t.printlist();
    System.out.println();

    t.delete("h"); //continue deleting
    t.printlist();
    System.out.println();

    t.delete("e");
    t.printlist();
    System.out.println();
  }
}
