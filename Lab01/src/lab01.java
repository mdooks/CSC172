/*
 * Lab1
 *
 * Lab 1 version 1
 *
 * Copyright 2015
 *
 * Course: CSC 172 Spring 2015
 *
 * Assignment: Lab 1
 *
 * Author: Nicholas Graham
 *
 * Lab Session:
 *
 * Lab TA:
 *
 * Last Revised: January 19, 2014.
 */

public class lab01 {
	public static void main (String[] args) {
		Integer [] intArray = { 1, 2, 3, 4, 5 };
		Double [] doubArray = { 1.1, 2.2, 3.3, 4.4 };
		Character [] charArray = { 'H', 'E', 'L', 'L', 'O' };
		String [] strArray = { "once", "upon", "a", "time" };
		printarray(intArray);
		printarray(doubArray);
		printarray(charArray);
		printarray(strArray);
		System.out.println("max Integer is " + getMax(intArray));
		System.out.println("max Double is " + getMax(doubArray));
		System.out.println("max Character is " + getMax(charArray));
		System.out.println("max String is " + getMax(strArray));
	}
	//part one Object method
	/*public static void printarray (Object[] objArray){
		for(int i=0; i< objArray.length; i++){
			System.out.println(objArray[i]);
		}*/

		//Part 2, overloading
		/*
		public static void printarray(Integer[] intArray){
			for (int i=0; i < intArray.length; i++){
				System.out.println(intArray[i]);
			}
		}
		public static void printarray(Double[] doubArray){
			for (int i=0; i < doubArray.length; i++){
				System.out.println(doubArray[i]);
			}
		}
		public static void printarray(Character[] charArray){
			for (int i=0; i < charArray.length; i++){
				System.out.println(charArray[i]);
			}
		}
		public static void printarray(String[] strArray){
			for (int i=0; i < strArray.length; i++){
				System.out.println(strArray[i]);
			}
		}
		*/

		//part 3, generics
		public static <T> void printarray(T[] inArray){
			//for (T t: inArray)
			for (int i=0; i<inArray.length; i++){
				System.out.println(inArray[i]);
			}
		}

		//part 4, get max non-generic
		/*
		public static Comparable getMax(Comparable[] a){
			/*
			Note: lab01.java uses unchecked or unsafe operations.
			Note: Recompile with -Xlint:unchecked for details.
			*/
			/*
			Comparable m = a[0];
			for(int i=0; i<a.length; i++){
				if (a[i].compareTo(m) > 0){
					m=a[i];
				}
			}
			return m;
		}
		*/
		public static <T extends Comparable<? super T>> T getMax(T[] inArray){
			T m = inArray[0];
			for(int i=0; i<inArray.length; i++){
				if (inArray[i].compareTo(m) == 1){
					m=inArray[i];
				}
			}
			return m;
		}
}
