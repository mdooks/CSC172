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
		for(Object o : objArray){
			System.out.println(o);
		}
	}*/
		//Part 2, overloading
		/*
		public static void printarray(Integer[] intArray){
			for (Integer i : intArray){
				System.out.println(i);
			}
		}
		public static void printarray(Double[] doubArray){
			for (Double d : doubArray){
				System.out.println(d);
			}
		}
		public static void printarray(Character[] charArray){
			for (Character c : charArray){
				System.out.println(c);
			}
		}
		public static void printarray(String[] strArray){
			for (String s : strArray){
				System.out.println(s);
			}
		}
		*/

		//part 3, generics
		public static <T> void printarray(T[] inArray){
			for (T t: inArray){
				System.out.println(t);
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
			for(Comparable i : a){
				if (i.compareTo(m) > 0){
					m=i;
				}
			}
			return m;
		}
		*/
		public static <T extends Comparable<? super T>> T getMax(T[] inArray){
			T m = inArray[0];
			for(T i : inArray){
				if (i.compareTo(m) == 1){
					m=i;
				}
			}
			return m;
		}
}
