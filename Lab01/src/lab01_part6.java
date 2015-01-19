/** Lab1** Lab 1 version 1** Copyright 2015** Course: CSC 172 Spring 2015** Assignment: Lab 1** Author: Nicholas Graham** Lab Session:** Lab TA:** Last Revised: January 19, 2014.*/// Generic findMax, with a function object.// Precondition: a.size( ) > 0.// Code is from the Addison Wesley Data Structures and Algorithm Analysis in Java 3rd Edition Nov 2011// with addition of the Charater compare by me.import java.util.Comparator;class CaseInsensitiveCompare implements Comparator<String>{  public int compare( String lhs, String rhs )  {    {return lhs.compareToIgnoreCase( rhs ); }  }}class CharInsensitiveCompare implements Comparator<Character>{  public int compare (Character lhs, Character rhs) {    { return lhs.compareTo ( rhs ); }  }}class lab01_part6 {  public static void main( String [ ] args )  {    String [ ] arr = { "ZEBRA", "alligator", "crocodile" };    System.out.println( findMax( arr, new CaseInsensitiveCompare()));    Character [] charArr = { 'T', 'E', 'O', 'Z', 'L'};    System.out.println( findMax( charArr, new CharInsensitiveCompare()));  }  public static <AnyType> AnyType findMax( AnyType [ ] arr, Comparator<? super AnyType> cmp ){    int maxIndex = 0;    for(int i=1;i<arr.length;i++)    if ( cmp.compare( arr[ i ], arr[ maxIndex ] ) > 0 )    maxIndex = i;    return arr[ maxIndex ];  }}