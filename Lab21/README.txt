Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 21
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

For this lab I implemented a divide and conquer algorithm to find the maximum subarray in random array. I started by doing it the intuitive way, which was by using 3 for loops, two to run through the possible sub arrays, and the third to find the sum. It saved the smallest sum it found them returned it. This way, while effective, has runtime of n^3 and ends up being terrible for large values of n. Next I implemented the divide and conquer method that was outlined in the lab right up. In this method it splits the array in half and works it way down chunk by chunk until there are two empty arrays. Once that is done it goes back up the recursive calls and return the maximum sum it found, the one in the left array, the right array, or the current array. The end result is the largest possible sum. The code for this method was outlined in the lab assignment. The run time of the second endud up being nlog(n). This is because there was an n/2 for loop required for each one, and after that the data set was split in half each respective call, giving the O(log(n)). Together these gave the O(nlog(n)).

To Compile: javac *.java
To Run: java MSA <array size>

example: java MSA 20
