package Main;

/**
 * 
 * @author Tenji Tembo
 * Class Details:
 * 	This is main driver class to run the simulation
 * Attributes:
 * 	None
 */

public class Driver {

	public static void main(String[] args) {
		
		/*
		 * Step one:
		 * Create the Graph Object
		 */
		
		Graph enviro = new Graph();
		enviro.nodes.get(0).setHere(true);
		enviro.nodes.get(8).setGoal(true);
		/*
		 * Step two:
		 * 	for int i = 0 -> 100 (episodes/trials) ----------->
		 * 
		 * 		find the agent - searches the graph for the agent, returns the state/node/index
		 * 		--store in a temp node?--
		 * 
		 * 		check to see if agent is at the goal state
		 * 		graph calls isWinner() (takes in a state/node/index)
		 * 			true? - toString(), end of trial
		 * 			false? - 
		 * 				do
		 * 					call Graph.move() passes in the node/index/state
		 * 					findAgent() - agent index
		 * 					check isWinner() - do they match?
		 * 						if true: print, break
		 * 						if false: continue
		 * 				while isAgent && isGoal != true
		 *	<-------------				
		 */
		
		for(int i =0; i < 1; i++){
			while(!enviro.isWinner(enviro.findAgent())){
				enviro.move(enviro.findAgent());
			}
			enviro.nodes.get(2).setHere(true);
			enviro.nodes.get(7).setHere(false);
		}
	}

	}
