import java.util.Scanner;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class Hash{
  public static Scanner in;
  String[] table;

  public Hash (int size){
    table = new String[size];
  }
  public void insert(String item){
    if(! lookup(item)){
      if(getLoad() > 0.5){
        rehash();
      }
      int in = Hash.hash(item, table.length);

      while (true){
        if (table[in] == null){
          table[in] = item;
          break;
        }
        else{
          if (in == table.length - 1){
            in =0;
          }
          else{
            in++;
          }
        }
      }
    }
  }

  public boolean lookup(String item){
    for(String s : table){
      if(item.equals(s)){
        return true;
      }
    }
    return false;
  }
  public void print(){
    for (String e : table){
      if (e != null){
        System.out.print(e +", ");
      }
    }
    System.out.println();
  }

  public int getCapacity(){
    return table.length;
  }

  public int getNumElements(){
    int sum = 0;
    for (String s : table){
      if (s != null)
      sum++;
    }
    return sum;
  }

  public float getLoad(){
    return (float) getNumElements() / (float) getCapacity();
  }
  public static int hash(String key, int tableSize){ //taken directly from the book as instructed
    int hashVal = 0;

    for (int i = 0; i < key.length(); i++){
      hashVal = 37*hashVal + key.charAt(i);
    }

    hashVal %= tableSize;
    if (hashVal < 0){
      hashVal += tableSize;
    }

    return hashVal;
  }
  public void rehash(){
    String[] temp = new String[table.length * 2];
    for (String s : table){
      if (s != null){
        int in = Hash.hash(s, temp.length);
        if (temp[in] == null){
          temp[in] = s;
        }
        else {
          while (true){
            if(temp[in] != null){
              temp[in] = s;
              break;
            }
            else{
              if(in == temp.length -1){
                in = 0;
              }
              else {
                in++;
              }
            }
          }
        }
      }
    }
    table = temp;
  }

  public static void main(String args[]){
    int words = 0;
    try{
      File file = new File("LoremIpsum.txt");
      if(!file.createNewFile()){
        in = new Scanner(file).useDelimiter("\\.|,|\\s");
      }
      else{
        in = new Scanner(file);
      }
    }catch (Exception e){
      ;
    }

    Hash browns = new Hash(13);

    while(in.hasNext()){
      browns.insert(in.next());
      words++;
    }
    in.close();
    browns.print();
    System.out.println(browns.getNumElements() + " Unique words.");
    System.out.println(browns.getCapacity() + " totals spots in the heap");
    System.out.println(words + " words read in");

    /*
    browns.insert("John");
    browns.insert("Mary");
    browns.print();
    browns.insert("Larry");
    browns.insert("Marissa");
    browns.insert("Mo");
    browns.print();
    browns.insert("Joe");
    System.out.println(browns.getLoad());
    browns.insert("Maria");
    System.out.println(browns.getLoad());
    browns.insert("Nick");
    System.out.println(browns.getLoad());
    browns.print();*/

  }
}
