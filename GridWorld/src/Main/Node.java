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
	
	protected HashMap<Node, Double> neighbors = new HashMap<Node, Double>();
	private String name;
	private boolean isHere;
	private boolean isGoal;

	//Constructor: initializes a node and the variables isHere and isGoal to false
	public Node(String name){
		
		this.name = name;
		isHere = false;
		isGoal = false;
		
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
		
		String nodeInfo = new String();
		
		nodeInfo += "The current state you are at is " + this.name ;
		
		
		return nodeInfo;
	}
	
}
