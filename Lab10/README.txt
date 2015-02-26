Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 10
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

For this lab a binary search tree was implemented. We started by implementing an insert method. Was done by properly step trough the tree until a null node is found, then the value is inserted there. Then the three print methods are done. These went through the list and either printed out the node then went through its children, went through the all the left children, then printed that last one, then went through the right children of that node, and finally one that printed the right children, before the left children before the parent. Then a lookup method is made which runs through the tree and returns true if the value is found. Finally the delete method was created, which removes a node, and then reconfigures the tree as necessary to make it still a valid BST.

To compile run: javac *.java
to run: java MyBinarySearchTree
