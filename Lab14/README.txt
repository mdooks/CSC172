Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 14
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

This lab focuses on sorting and the runtimes of the different algorithms. All these algorithms were implemented based off of the code in the book. First the code given for bubble sort was tested to see how long it would take to sort different numbers of elements. Then a method for insertion sort was created, and set up so that it counted the number of swaps required. This method was then tested and the results plotted to see how it compared to bubble sort. Then a shell sort was implemented using Hibbard's increments. The increments were set up so that it stated at the largest power of 2 is the starting place and then it steps down through the powers of 2. Then the java implementation of sort for arrays was tested and the results plotted to compare to the others. The plots are shown in BubbleSort.jpg, InsertionSort.jpg, ShellSort.jpg, and ArraySort.jpg. The first two appear to be polynomial, and the last one appears to be n*log(n). Shell Sort appears to be a polynomial less then n^2, around n^1.5. These match up with the theory.

Compile: javac *.java
Run: java SortTest.java 500
