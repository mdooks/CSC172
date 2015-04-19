Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 20
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

For this lab we used the base of the code from labs 18 and 19 and added a few methods. I started by modifying the create graph from file to also read in edge weights, as well as the two vertex's. After that was done I started implementing the sudo-code given for Dijkstra's Algorithem. Just like in lab 19 all the values were stored in arrays, and this time a two dimensional array was added to store the edge weights. After implementing the algorigthem, I set up the shortest path method based off of the method used in lab 19. From there I implemented the given test case, as well as 3 of my own. My first two test cases look at standard graphs, while the third graph looks at one with many negative edges. Dijkstra's Algorithem does not hold for graphs with negative edges, and while many of the trials do give the correct result the last one does not. It gives a path with weight 3 as apposed to a "longer" one with a weight -2. The runtime of the algorithem is O(n^2), which is what the book got for dense graphs. They were able to get it down for sparse graphs, but I was unable to get it down to there.

To Compile: javac *.java
To Run: java MyGraph
