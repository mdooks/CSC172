Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 09
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

For this lab we looked at pointers to functions. We started by creating a couple functions to help fill an array with random values (Code given to us in the lab assignment). We then added a bubble sort function to order the array from least to greatest (Code given to us in the lab assignment). We then wrote two functions gtc() and ltc() that each took to integers and compared whether or not the first one was greater than the second one, and the same for less than. We then rewrote the bubble sort function to use the gtc() and ltc() functions to test them. We then modified the Bubble sort function so that it would take in a function and use that function to make the comparisons, so that we could use the same function to order them from least to greatest and from greatest to least. We then tested these functions

To compile run: gcc lab09.c
to run: ./a.out

Output:

15765
-20026
-24615
-23626
8226
22144
13486
-31025
-32705
-24406
-32705, -31025, -24615, -24406, -23626, -20026, 8226, 13486, 15765, 22144,
22144, 15765, 13486, 8226, -20026, -23626, -24406, -24615, -31025, -32705,
