Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 18
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

For this lab we had to look at how to implement a graph. The basic outline was given in the lab write up, with three classes. One for the edges, one for the Graph, and one was an interface to be used in a private class for the Adjacency List. I started the lab by implementing the simple easy methods for getting variables. I then wrote the insert and delete methods, that checked if the list was directed or not, and then if the edge had hot already been inserted, inserted it. If the graph wasn't directed it insert it for both directions. Once that was done I started implementing the AdjList, based off of the interface given. In this there was a begin, next, and end method, to make an iterator. The begin method set an internal counter to -1, and then returned the a call to next. The end method checked to see if the counter had hit the end of the graph vertices, and returned a boolean to indicate that. The next method ran through the possible connections and returned the index of the next one it found that was connected. This iterator was then used to run through and print out an adjacency list representation of the Graph. A lot of this code was given and/or hinted at in the lab writeup.

To compile: javac *.java
to run: java MyGraph
