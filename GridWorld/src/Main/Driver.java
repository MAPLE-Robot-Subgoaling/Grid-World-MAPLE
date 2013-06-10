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
		
		for(int i = 1; i < 3; i++){ //records trials
			for(int j = 0; j < 10; j++){ //possible number of steps he can take
				int currentLocation = enviro.findAgent();
				if(enviro.isWinner(currentLocation)){
					System.out.println("Simulation Over");
					System.out.println("Agent Located at: " + enviro.printNode(currentLocation));
					break;
				}else{
					enviro.move(currentLocation);
				}
			}
			
			System.out.println("--------Simulation Reset: Round " + i + " Complete---------");
			enviro.resetSim();
		}
		
	}

}
