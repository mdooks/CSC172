import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;

public class test{
  public static BufferedReader in;
  public static PrintWriter writer;
  public static void main(String[] args){
    if (args.length < 2){
      System.out.println("I'm sorry there aren't enough arguments. Please enter the source file and destination file when you run the program.");
    }
    else{

      ShuntingYard sy = new ShuntingYard();
      try{
        writer = new PrintWriter(args[1], "UTF-8");
        in = new BufferedReader(new FileReader( new File(args[0])));
      }catch(FileNotFoundException e){
        System.out.println(e);
      }catch(UnsupportedEncodingException e){
        System.out.println(e);
      }
      try{
        while(in.ready()){
          String t = in.readLine();
          //System.out.println(t);
          Double ans = Calc.calc(sy.postfix(t));
          writer.printf("%.2f\n", ans);
        }
      }catch(IOException e){
        System.out.println(e);
      }
      //ShuntingYard sy = new ShuntingYard();
      writer.close();
    }
  }
}
