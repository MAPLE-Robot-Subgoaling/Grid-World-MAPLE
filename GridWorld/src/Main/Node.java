package Main;

import java.util.*;
import java.util.Map.Entry;

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
	
	//Attributes of the class
	protected HashMap<Node, Double> neighbors; 
	private String name;
	private boolean isHere;
	private boolean isGoal;
	private boolean isVisited;

	//Constructor: initializes a node and the variables isHere and isGoal to false
	public Node(String name){
		
		this.name = name;
		isHere = false;
		isGoal = false;
		isVisited = false;
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
	
	public boolean isVisited(){
		return isVisited;
	}
	
	public void visiting(boolean isVisited){
		this.isVisited = isVisited;
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
		StringBuilder str = new StringBuilder();
		
		str.append(name);
		//str.append("Goal State: " + isGoal() + "\n");
		//str.append("Agent State: " + isHere() + "\n");
		//str.append("Neighbor \tQ-Value\n");
		
		
		return name;
	}
	
}
