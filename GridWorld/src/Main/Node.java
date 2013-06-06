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
	
	protected HashMap neighbors;
	private boolean isHere;
	private boolean isGoal;

	//Constructor: initializes a node and the variables isHere and isGoal to false
	public Node(){
		
		isHere = false;
		isGoal = false;
		
	}

	public HashMap getNeighbors() {
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
	
}
