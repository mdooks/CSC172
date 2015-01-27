Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 02

In this lab I created a linked list by using a class for the nodes,
MyNode.java, and an interface setup, SimpleLinkedList.java, for the
linked list. When implementing the linked list in MyLinkedList.java,
the isEmpty function was created first. To do this itchecked if the
next element of the starting node was null, if it was then there were
no items in the list. Then the insert function was constructed. It
followed the list, starting at the "start" node, and kept going until
it found a node that pointed nothing, the last item, and had it point
to the new item. The next method created was the printList. This
method started at the start node and checked to see if the next node
was null, if it wasn't it printed the data in it, if it was the method
ended. Then the lookup method was created. this ran through the list
similarly to printList, but this timed checked each value to see if it
was the desired value if it was the program returned true, if the it
hit the end and the value was not found it returned false. The insert
method was then modified to check if the item being added was already
in the list and if it was it wouldn't add it a second time. Finally
the delete method was created that checked if the item was in the list,
and if was, found it then made the previous node point to the node after it.
The runtime of the insert method was O(n) because it had to search through
the whole list until it found the end then added the new element. A test
file, test.java, was then created that tested all the methods of the
linked list.

The node class was created in the MyNode.java file, the interface was
created in the SimpleLinkedList.java file. The linked list was implemented
in the MyLinkedList.jave file. The linked list was then tested in the
test.java file.

The output can be found in the OUTPUT.txt file. To compile run javac *.java
then run using java test.
