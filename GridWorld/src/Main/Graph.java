package Main;

import java.util.*;
/**
 * 
 * @author Robot-Subgoaling
 * Class Details:
 * 	This is the actual Graph API. Using the nodes, 
 * 	it will create a graph Data Structure to be able to
 * 	simulate the agent moving through the environment
 * Attributes:
 * 	environment - an Arraylist of Nodes containing all 
 * 	the available nodes in the 
 */

public class Graph {
	
	private ArrayList<Node> nodes;
	
	public Graph(){
		/*
		 * 9 different nodes - hand coded?
		 * call setNeighbors()
		 */
	}
	
	/**
	 * move() - Moves the agent from one state to the next
	 * by simply collecting the state from each of the it
	 */
	public void move(int index){
		/*
		 * access the node on the hashmap
		 * looks for the smallest value in the map (behavior) - collects the node's index/state
		 * sets the agent to false in old node, and true in the new node
		 * print out the node
		 */
	}
	
	/**
	 * setNeighbors() - sets up the neighborhood of all the
	 * node elements
	 */
	public void setNeighbors(){
		/*
		 * 	for each node in nodes
		 * 		add HashMap entries of neighboring Nodes and their corresponding Q-Values
		 * 			note: could add random number generator for the random numbers.
		 */
	}
	
	/**
	 * isWinner() - checks to see if agent is at goal state
	 * @param index - index of the node we are checking
	 * @return - true or false
	 */
	public boolean isWinner(int index){
		return true;
	}
	
	/**
	 * findAgent() - scans the arraylist for the agent location
	 * @return - index of the agent's locations
	 */
	public int findAgent(){
		return 0;
	}
	
	/**
	 * toString() - returns the toString of the entire Graph
	 * @return - tostring of the entire graph
	 */
	public String toString(){
		StringBuilder str = new StringBuilder();
		
		for(int i = 0; i < nodes.size(); i++)
			str.append(printNode(i));
		
		return str.toString();
	}
	
	/**
	 * printNode() - returns the toString of just a single node element
	 * @param index - index of the node
	 * @return - toString variable
	 */
	public String printNode(int index){
		return nodes.get(index).toString();
	}
}
