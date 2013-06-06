THIS IS THE README FOR GRIDWORLD 1.0 (yes I did say 1.0)...

All of this was in an email sent out earlier. It also is the source of documentation. Even though We will throw it away
anyway.

//
For the Code, we have about 3 classes set up (Main, Graph, and Node) - this is our current idea of what we plan to do 
so far.

The Node class will contain a location, a boolean value to tell if the agent is in that position, a reward value, 
a boolean goal state, and a Hash-Map containing a list of the neighboring nodes and their corresponding Q-Values 
(edge weights). 

The Graph class will contain an arraylist of all the nodes (approximately 9) and a simple move function that changes 
the states of the  agent boolean in each of the node, as well as prints out information concerning the node's location.

The main class will contain a Graph Object. We will manually set the agent, the goal, and all of the corresponding 
neighbors and Q-Values for now. We will then call move. What move does is check the graph to find the agent state 
and the goal state and see if they are in the same node (ie both are true for that node). If not, the agent has not 
reached the goal state, it will choose a path based on the values of the Q-Learning (smaller is better). Change the 
boolean values of the agent and print out the results.

For now, no Q-Learning updates. Let's just get this Repo thing working and our bare bones implementation out of the way. 
//
