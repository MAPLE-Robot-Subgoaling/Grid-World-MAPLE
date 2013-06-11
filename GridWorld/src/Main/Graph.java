package Main;

import java.util.*;
import java.util.Map.Entry;
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
	
	private ArrayList<Node> nodes = new ArrayList<Node>();
	
	/**
	 * Creates the Graph Node Application
	 */
	public Graph(){
		
		//Creates the nodes and their
		Node s0 = new Node("s0");
		nodes.add(s0);
		Node s1 = new Node("s1");
		nodes.add(s1);
		Node s2 = new Node("s2");
		nodes.add(s2);
		Node s3 = new Node("s3");
		nodes.add(s3);
		Node s4 = new Node("s4");
		nodes.add(s4);
		Node s5 = new Node("s5");
		nodes.add(s5);
		Node s6 = new Node("s6");
		nodes.add(s6);
		Node s7 = new Node("s7");
		nodes.add(s7);
		Node s8 = new Node("s8");
		nodes.add(s8);
		
		//sets up the start state and the goal state 
		nodes.get(0).setHere(true);
		nodes.get(nodes.size() - 1).setGoal(true);
	}
	
	public void chooseScenario(int num){

		switch(num){
			case 1: setNeighbors();
			case 2: setNeighborsRandom();
			case 3: this.setNeighborsMatch();
		}
		
		
	}
	
	/**
	 * resetSim() - Prepares the Environment for the next Simulation
	 */
	public void resetSim(){
		nodes.get(0).setHere(true);
		nodes.get(nodes.size() - 1).setGoal(true);
		
		for(Node n: nodes){
			n.visiting(false);
		}
	}
	
	/**
	 * move() - Moves the agent from one state to the next
	 * by simply collecting the state from each of the it
	 * @param index - checks for the index of the node
	 * @return none
	 */
	public void move(int index){
		/*
		 * access the node on the hashmap
		 * looks for the smallest value in the map (behavior) - collects the node's index/state
		 * sets the agent to false in old node, and true in the new node
		 * print out the node
		 */
		
		nodes.get(index).neighbors.entrySet();
		Node temp = nodes.get(index);
		TreeSet<Double> val = new TreeSet<Double>(); //Sorts them automatically
		
		//Creates the list of values for that node
		Iterator<Entry<Node, Double>> itr = nodes.get(index).neighbors.entrySet().iterator();
		while(itr.hasNext()){
			Map.Entry<Node, Double> pairs = (Map.Entry<Node, Double>)itr.next();
			if(pairs.getKey().isVisited() != true){ //checks to see if the agent has visited that node
				val.add(pairs.getValue()); //adds available node values
			}
		}
		
		if(val.size() == 0){//No more nodes to go to
			System.out.println("Stuck at " + nodes.get(index).toString() + "\n");
		}else{//An available node to move to
			Double value = val.first(); //returns the smallest double
			Double max = val.last(); //returns the largest double value
			
			//Return the corresponding key
			Node nextStep = getKeyfromVal(index , nodes.get(index).neighbors , value);
			
			int newIndex = 0;
			if(nextStep == null){
				System.out.println("Step Unsuccessful"); //Big Problem (Never suppose to happen)!
			}else{ 
				//Makes the move
				newIndex = nodes.indexOf(nextStep);
				nodes.get(index).setHere(false);
				nodes.get(newIndex).setHere(true); //Moves the Agent
				nodes.get(index).visiting(true); //marks the location the agent has been to
				
				//Prints the transisiton
				System.out.println("Agent Moved from Here " + nodes.get(index).toString() + " to Here " + nodes.get(newIndex).toString());
				
				//Updates the Q-values for the learning algorithm 
				Double qval = this.updateQVal(value, max);
				nodes.get(index).neighbors.put(nextStep, qval);
				nodes.get(newIndex).neighbors.put(temp, qval);
				
				//Prints the result
				System.out.print("Node Chosen: " + nextStep + "\t");
				
				System.out.print("\tOld Q-Value: ");
				System.out.printf("%.3f", value);
				
				System.out.print("\tMax Q-Neighbor-Value: ");
				System.out.printf("%.3f", max);
				
				System.out.print("\tNew Q-Value: ");
				System.out.printf("%.3f%n", qval);
				System.out.println();
				
			}
		}
		
		
	}
	
	/**
	 * updateQVal() - changes the QVal according the the learning equation
	 * @param qOld - the older QValue
	 * @param qMax - the Max QValue in the set of all possible next states
	 * @return - the updated QValue
	 */
	private Double updateQVal(Double qOld, Double qMax){	
		return qOld + 0.99 * (-1 + 0.95 * (qMax - qOld));
	}
	
	/**
	 * getKeyfromVal() - find the corresponding key value from the value passed in
	 * @param index - index of the node
	 * @param map - the entire HashMap passed in from the index
	 * @param value - the value we are looking for
	 * @return - the corresponding neighbor key
	 */
	private Node getKeyfromVal(int index, Map<Node,Double> map, Double value){
		for(Entry<Node, Double> entry: nodes.get(index).neighbors.entrySet()){
			if(value.equals(entry.getValue()))
				return entry.getKey();
		}
		return null;
	}
	
	/**
	 * setNeighbors() - sets up the neighborhood of all the
	 * node elements
	 */
	private void setNeighbors(){
		
		System.out.println("Creating relation according to predefined optimal path\n");
		
		nodes.get(0).neighbors.put(nodes.get(1), 3.0);
		nodes.get(0).neighbors.put(nodes.get(3), 1.0);
		
		nodes.get(1).neighbors.put(nodes.get(0), 3.0);
		nodes.get(1).neighbors.put(nodes.get(2), 7.0);
		nodes.get(1).neighbors.put(nodes.get(4), 5.0);
		
		nodes.get(2).neighbors.put(nodes.get(1), 7.0);
		nodes.get(2).neighbors.put(nodes.get(5), 6.0);
		
		nodes.get(3).neighbors.put(nodes.get(0), 1.0);
		nodes.get(3).neighbors.put(nodes.get(4), 8.0);
		nodes.get(3).neighbors.put(nodes.get(6), 0.9);
		
		nodes.get(4).neighbors.put(nodes.get(1), 5.0);
		nodes.get(4).neighbors.put(nodes.get(3), 8.0);
		nodes.get(4).neighbors.put(nodes.get(5), 7.0);
		nodes.get(4).neighbors.put(nodes.get(7), 6.0);
		
		nodes.get(5).neighbors.put(nodes.get(2), 6.0);
		nodes.get(5).neighbors.put(nodes.get(4), 7.0);
		nodes.get(5).neighbors.put(nodes.get(8), 10.0);
		
		nodes.get(6).neighbors.put(nodes.get(3), 0.9);
		nodes.get(6).neighbors.put(nodes.get(7), 0.8);
		
		nodes.get(7).neighbors.put(nodes.get(4), 6.0);
		nodes.get(7).neighbors.put(nodes.get(6), 0.8);
		nodes.get(7).neighbors.put(nodes.get(8), 0.7);
		
		nodes.get(8).neighbors.put(nodes.get(5), 10.0);
		nodes.get(8).neighbors.put(nodes.get(7), 0.7);
	}
	
	/**
	 * setNeighborsRandom() - sets up the neighborhood of all the
	 * node elements, but with Random Numbers
	 */
	private void setNeighborsRandom(){
		/*
		 * 	for each node in nodes
		 * 		add HashMap entries of neighboring Nodes and their corresponding Q-Values
		 * 			note: could add random number generator for the random numbers.
		 */
		
		System.out.println("Creating relations according to randomized numbers\n");
		
		Double s0s3 = Math.random() * 12;
		Double s0s1 = Math.random() * 12;
		Double s3s4 = Math.random() * 12;
		Double s1s4 = Math.random() * 12;
		Double s1s2 = Math.random() * 12;
		Double s4s5 = Math.random() * 12;
		Double s2s5 = Math.random() * 12;
		Double s3s6 = Math.random() * 12;
		Double s4s7 = Math.random() * 12;
		Double s6s7 = Math.random() * 12;
		Double s7s8 = Math.random() * 12;
		Double s5s8 = Math.random() * 12;

		nodes.get(0).neighbors.put(nodes.get(1), s0s1);
		nodes.get(0).neighbors.put(nodes.get(3), s0s3);
		
		nodes.get(1).neighbors.put(nodes.get(0), s0s1);
		nodes.get(1).neighbors.put(nodes.get(2), s1s2);
		nodes.get(1).neighbors.put(nodes.get(4), s1s4);
		
		nodes.get(2).neighbors.put(nodes.get(1), s1s2);
		nodes.get(2).neighbors.put(nodes.get(5), s2s5);
		
		nodes.get(3).neighbors.put(nodes.get(0), s0s3);
		nodes.get(3).neighbors.put(nodes.get(4), s3s4);
		nodes.get(3).neighbors.put(nodes.get(6), s3s6);
		
		nodes.get(4).neighbors.put(nodes.get(1), s1s4);
		nodes.get(4).neighbors.put(nodes.get(3), s3s4);
		nodes.get(4).neighbors.put(nodes.get(5), s4s5);
		nodes.get(4).neighbors.put(nodes.get(7), s4s7);
		
		nodes.get(5).neighbors.put(nodes.get(2), s2s5);
		nodes.get(5).neighbors.put(nodes.get(4), s4s5);
		nodes.get(5).neighbors.put(nodes.get(8), s5s8);
		
		nodes.get(6).neighbors.put(nodes.get(3), s3s6);
		nodes.get(6).neighbors.put(nodes.get(7), s6s7);
		
		nodes.get(7).neighbors.put(nodes.get(4), s4s7);
		nodes.get(7).neighbors.put(nodes.get(6), s6s7);
		nodes.get(7).neighbors.put(nodes.get(8), s7s8);
		
		nodes.get(8).neighbors.put(nodes.get(5), s5s8);
		nodes.get(8).neighbors.put(nodes.get(7), s7s8);
	}
	
	private void setNeighborsMatch(){
		
		System.out.println("Setting the enivronment based on Q-Values as all 5.0\n");
		
		nodes.get(0).neighbors.put(nodes.get(1), 5.0);
		nodes.get(0).neighbors.put(nodes.get(3), 5.0);
		
		nodes.get(1).neighbors.put(nodes.get(0), 5.0);
		nodes.get(1).neighbors.put(nodes.get(2), 5.0);
		nodes.get(1).neighbors.put(nodes.get(4), 5.0);
		
		nodes.get(2).neighbors.put(nodes.get(1), 5.0);
		nodes.get(2).neighbors.put(nodes.get(5), 5.0);
		
		nodes.get(3).neighbors.put(nodes.get(0), 5.0);
		nodes.get(3).neighbors.put(nodes.get(4), 5.0);
		nodes.get(3).neighbors.put(nodes.get(6), 5.);
		
		nodes.get(4).neighbors.put(nodes.get(1), 5.0);
		nodes.get(4).neighbors.put(nodes.get(3), 5.0);
		nodes.get(4).neighbors.put(nodes.get(5), 5.0);
		nodes.get(4).neighbors.put(nodes.get(7), 5.0);
		
		nodes.get(5).neighbors.put(nodes.get(2), 5.0);
		nodes.get(5).neighbors.put(nodes.get(4), 5.0);
		nodes.get(5).neighbors.put(nodes.get(8), 5.0);
		
		nodes.get(6).neighbors.put(nodes.get(3), 5.0);
		nodes.get(6).neighbors.put(nodes.get(7), 5.0);
		
		nodes.get(7).neighbors.put(nodes.get(4), 5.0);
		nodes.get(7).neighbors.put(nodes.get(6), 5.0);
		nodes.get(7).neighbors.put(nodes.get(8), 5.0);
		
		nodes.get(8).neighbors.put(nodes.get(5), 5.0);
		nodes.get(8).neighbors.put(nodes.get(7), 5.0);
	}
	
	/**
	 * isWinner() - checks to see if agent is at goal state
	 * @param index - index of the node we are checking
	 * @return - true or false
	 */
	public boolean isWinner(int index){
		return nodes.get(index).isHere() && nodes.get(index).isGoal();
	}
	
	/**
	 * findAgent() - scans the arraylist for the agent location
	 * @return - index of the agent's locations
	 */
	public int findAgent(){
		for(int i = 0; i < nodes.size(); i++){
			if(nodes.get(i).isHere())
				return i;
		}
		return -1;
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
	
	public String printNodeAttributes(){
		StringBuilder str = new StringBuilder();
		for(int i = 0; i < nodes.size(); i++)
			str.append(nodes.get(i).printNode());
		return str.toString();
	}
	
}
