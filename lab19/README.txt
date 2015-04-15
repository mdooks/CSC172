Nicholas Graham
ngraham@u.rochester.edu
CSC 172
Lab 19
Lab TA: Kate Zeng Zhiming
Lab Session: Wednesday 6:15 - 7:30

For this lab we used the base of the code from lab 18 and added a few methods. The first was a static method that Read in a file with the number of nodes, whether it was directed or not, and then a list of the connections, or Edges. Then I used the sudo code given to me to implement a way to find the shortest path from one node to another. While I probably should have rewritten the graph portion to contain an object type vertex, I instead used arrays to hold the data I would need to find the path. I had one array of booleans, one for parents, and one for the number of nodes down it was, or distance. To find the path, I first find the levels of each node from the start node down until all the nodes are found. This sort of tree structure will give the shortest path from any node back to the first one. This operation takes O(n^3) time. Then using the data gathered from this structure. Starting at the second node, you find your way up through the parents back to the first node. I implemented this using two different methods. One that checked the initial conditions, and if it was okay, would send it to the helper method which tunnels its way up recursively, then prints the values out in order, unless it hits a point where the path cannot be completed, then it informs the user.

I set up the three test cases given, as well as created my own. I have the test class print out the representation of the graph before printing out the paths connecting points. I have also included pictures of the Graphs I made. My First graph I made is a directed graph that forms two overlapping circular paths such that it is possible to get to any value. The second Graph I was undirected and had 2 semiconnected regions that were then joined through one main node. Again, it is possible to connect any nodes. The Last Graph I made I set up two triangles such that the tips were connected, to the others. This graph was directed, and it is not possible to make it to every possible node from a given starting point. Overall I would say that this lab worked out pretty well, but I really should have used a class for the vertices.

To compile: javac *.java
to run: java MyGraph
