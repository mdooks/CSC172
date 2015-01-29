Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 02
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

In this lab I created a double linked list by using a class for the nodes,
MyDoubleNode.java, and an interface setup, DoublyLinkedList.java, for the
linked list. When implementing the linked list in MyLinkedList.java,
the isEmpty function was created first. To do this it checked if the
second item after the start was null, because the second node should be the
end node. if the second item after start is null, then the only items in
the list are the start and the end node. Then the insert function was
constructed. To to this is starts at the end node, links the one before that
to the new node, then links the new node to the end node, then finally links
the end node back to the new node. The next method created was the printList.
This method started at the start node and checked to see if the second next node
was null, if it wasn't it printed the data in the next node, if it was the method
ended. A very similar process was used for the printListRev method, but it started
with the end node, and checked to see if the node 2 before it was null. Then the
lookup method was created. This ran through the list similarly to printList, but
this timed checked each value to see if it was the desired value if it was the
program returned true, if the it reached the end and the value was not found it
returned false. The insert method was then modified to check if the item being
added was already in the list and if it was it wouldn't add it a second time.
Finally the delete method was created that checked if the item was in the list,
and if was, found it then made the node after it point to the node behind it and
then made the node behind it point to the node in front of it, effectively cutting
out that node. node point to the node after it. The runtime of the insert method
was O(n) if the lookup function is to be included in the calculation. Otherwise
the rest of the insert is all constant. A test file, test.java, was then created
that tested all the methods of the linked list.

The node class was created in the MyDoubleNode.java file, the interface was
created in the DoublyLinkedList.java file. The linked list was implemented
in the MyDoublyLinkedList.jave file. The linked list was then tested in the
test.java file.

The output can be found in the OUTPUT.txt file. To compile run javac *.java
then run using java test.
