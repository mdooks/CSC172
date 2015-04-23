Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 20
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

For this lab I looked into dynamic programming. The problem given asked us to find the minimum number of coins required to make the given amount of change. I started by setting up the denominations of money and the general outline of the main function as it was given to me in the lab. I was then asked to write How I would go about solving this problem. If I were to approach it, I would start by subtracting the largest amount possible then continuing to do so for the new value, then printing out the results. While this method would work for the way the US currency is set up, if another coin was added in, it may not give the smallest number of coins. Then I started following the lab instructions on how to best implement this. I started by creating a helper method that would make a new array the length of the change desired plus one, so in the worst case we could return just pennies. Then the array is passed into another method that subtracts each possible amount then passes that on with the new value, until the final result is reached. This is done for every possible solution and the minimum coin solution is returned. As the lab states, this works, but, it is terribly slow. To fix this an a 2D array is built and in it once the minimum coin possibility is found for a given value it is stored, so that if that value is checked again it can be accessed in constant time. This dramatically decreases the number of redundant recursive calls, and speeds up the program immensely. The runtime for the original way ended up growing exponentially as the number increased. Once dynamic programing had been introduced, it was more or less a linear increase.

To Compile: javac *.java
To run: java Change <amount>

Ex: java Change 1230
