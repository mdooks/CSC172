Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 08
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

For this lab a linked list was implemented in c. We started by creating a Struct to define the node. the struct contained an integer value and a pointer to the next Struct. Next an insert method was created. If the pointer passed in was null, we allocated memory for it, then added the value into the list, otherwise we moved forward one value in the list and called the function again. Then a printList method was created that printed each value in the list. These were then tested by filling the linked list with every odd value from 1 to 20, then printing it out. Next a lookup method was created, which was similar to the print method, but instead of printing out the values it would check each value to the inserted value to see if the matched. if it did it returned "True" (which we set to 1) or if it didn't match anything in the list it returned "False" (0). We then used that to check to see if any of the values between 0 and 20 were in the list and printed out the results. Finally a delete function was written to remove an element from the list. This was done by going through the list a looking for the value, and once it was found, storing the next node to a temp spot, freeing the memory of the struct being deleted, then pointing the previous one to the temp variable.


Compile: gcc lab08.c
run: ./a.out
