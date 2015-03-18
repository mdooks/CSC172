Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 12
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

This lab we implemented a heap. I started by making a default constructor that would create a heap of size 10, and then another one that let you specify the length of the array. Then I wrote a method that returns the size of the heap, or the number of items actually in the heap. it does this by running through until it finds a null element, or it hits the end, then returning. I then started a test class to test my implementation of a heap. Next I created an insert method which put the value at the first null space then called a method, bubbleUp, to make sure that it was still in the heap form. this method compared the new value to it parent at the index one half of its value, and if it was smaller then its parent, they traded places. It then continued until the new value was at 1 or it was larger than its parent. Then I made a printHeap method which printed every non null element in the array. I then made a method that increased the size of the array by copying it over to an array with twice the length whenever something was inserted into a full heap. Then I made a method to delete the first item, and replace it with the last one, then another method to bring that new first element down to make sure it still met the conditions of the heap. The bubbleDown method was based of the example from the textbook. I then wrote a method that would take an unsorted array and turn it into a heap by bubbling down the first half of the array. I then implemented tests for all of these methods.

Compile by running: javac *.java
run by: java test
