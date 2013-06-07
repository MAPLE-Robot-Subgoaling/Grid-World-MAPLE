package Main;

import java.util.*;

/**
 * 
 * @author Tenji Tembo
 * Class Details:
 * 	This class is designed to contain the Node for the Graph ADT
 * Attributes:
 * 	Neighbors - HashMap of all neighbors for that particular 
 * 	object and corresponding edge weights (Q-values)
 */

public class Node {
	
	protected HashMap<Node, Double> neighbors;
	private String name;
	private boolean isHere;
	private boolean isGoal;

	//Constructor: initializes a node and the variables isHere and isGoal to false
	public Node(String name){
		
		this.name = name;
		isHere = false;
		isGoal = false;
		neighbors = new HashMap<Node, Double>();
	}
	
	//Shallow Copy Constructor
	public Node(Node other){
		this.name = other.name;
		this.isGoal = other.isGoal;
		this.isHere = other.isHere;
		this.neighbors = other.neighbors;
	}

	public HashMap<Node, Double> getNeighbors() {
		return neighbors;
	}

	public boolean isHere() {
		return isHere;
	}

	public void setHere(boolean isHere) {
		this.isHere = isHere;
	}

	public boolean isGoal() {
		return isGoal;
	}

	public void setGoal(boolean isGoal) {
		this.isGoal = isGoal;
	}
	
	/**
	 * toString() - returns the toString of the entire Graph
	 * @return - tostring of the entire graph
	 */
	public String toString(){
		
<<<<<<< HEAD
		return name;
=======
		String nodeInfo = new String();
		
		nodeInfo +=  this.name + "\n";
		
		return nodeInfo;
>>>>>>> af21dd630e9f7d449e1d5b9ba7fb1cb990142152
	}
	
}
