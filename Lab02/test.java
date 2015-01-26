public class test {
  public static void main (String[] args){
    lab02 t = new lab02();
    System.out.println(t.isEmpty());
    t.insert("h");
    t.insert("e");
    t.insert("l");
    t.insert("l");
    t.insert("o");
    t.printlist();
    System.out.println(t.lookup("r"));
    t.delete("l");
    t.printlist();
    System.out.println();
    t.delete("0");
    t.printlist();
    System.out.println();
    t.delete("o");
    t.printlist();
    System.out.println();
    t.delete("h");
    t.printlist();
    System.out.println();
    t.delete("e");
    t.printlist();
    System.out.println();
  }
}
