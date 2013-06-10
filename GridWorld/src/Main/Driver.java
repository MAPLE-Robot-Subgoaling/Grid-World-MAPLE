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
		
		//Create a Graph Object
		Graph enviro = new Graph();
		System.out.println(enviro.printNodeAttributes());
		
		for(int i = 1; i <= 100; i++){ //records trials
			for(int j = 0; j < 10; j++){ //possible number of steps he can take
				int currentLocation = enviro.findAgent();
				if(enviro.isWinner(currentLocation)){ //End the Episode - the Agent found the goal.
					System.out.println("Simulation Over");
					System.out.println("Agent Located at: " + enviro.printNode(currentLocation));
					break;
				}else{
					enviro.move(currentLocation); //not at the goal state yet
				}
			}
			
			System.out.println("--Simulation Reset: Round " + i + " Complete--\n");
			enviro.resetSim(); //begin the next episode
		}
		
		System.out.println(enviro.printNodeAttributes());
		
	}

}
