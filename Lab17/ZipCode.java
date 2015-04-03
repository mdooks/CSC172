/*
* Lab17
*
* Lab 17
*
* Copyright 2015
*
* Course: CSC 172 Spring 2015
*
* Assignment: Lab 17
*
* Author: Nicholas Graham
*
* Email: ngraham@u.rochester.edu
*
* Lab Session: Wednesday 6:15 - 7:30
*
* Lab TA: Kate Zeng Zhiming
*
* Last Revised: Febuary 26, 2015.
*/
import java.util.HashMap;
import java.util.Scanner;
import java.io.File;

public class ZipCode {
  public static Scanner in;
  public static Scanner in2;
  public static void main(String[] args){
    HashMap<Integer, String> tags = new HashMap<Integer, String>();

    try{
      File file = new File("zipcodes.csv");
      if(!file.createNewFile()){
        in = new Scanner(file);
      }
      else{
        in = new Scanner(file);
      }
    }catch (Exception e){
      ;
    }

    try{
      in = new Scanner(new File("zipcodes.csv")).useDelimiter(",|\\v");
    }catch(Exception e){
      System.out.println(e);
    }
    while(in.hasNext()){
      Integer zip = new Integer (in.nextInt());
      String address = in.next() + "," + in.next();
      //System.out.println(zip+ ", "+ address);
      tags.put(zip, address);
    }
    System.out.println(tags.size());

    while (true){
      Scanner user = new Scanner(System.in);
      System.out.print("Enter a Zipcode to search, or type quit to exit: ");
      String input = user.next();
      Integer uZip;

      if (input.equals("quit")){
        break;
      }
      try{
        uZip = new Integer (input);
      }catch(Exception e){
        System.out.println("Invalid Input!");
        continue;
      }
      if (input.length() != 5){
        System.out.println("That is not a valid Zip Code");
        continue;
      }
      if (tags.containsKey(uZip)){
        System.out.println(tags.get(uZip));
      }
      else{
        System.out.println("I'm sorry, that Zip Code was not found.");
      }


    }

    HashMap<String, Integer> slingingSlasher = new HashMap<String, Integer>();

    for (HashMap.Entry<Integer, String> e : tags.entrySet()){ //run through the map and get the values
      Integer zip = e.getKey();
      String address = e.getValue();
      if(!slingingSlasher.containsKey(address))
        slingingSlasher.put(address, 1);
      else{
        int val = ((Integer) slingingSlasher.get(address)).intValue();
        slingingSlasher.put(address, val + 1);
      }
    }

    System.out.println(slingingSlasher.size());
    while (true){
      Scanner user = new Scanner(System.in);
      System.out.print("Enter a City to search, or type quit to exit: ");
      String input = user.nextLine();
      if (input.equals("quit")){
        break;
      }
      if (slingingSlasher.containsKey(input)){
        System.out.println(slingingSlasher.get(input));
      }
      else{
        System.out.println("I'm sorry to say that the city you have entered was not found. I do hope you will try again.");
      }


    }

    try{
      in.close();
    }catch(Exception e){
      ;
    }
  }
}
