package Main;
import java.util.*;

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
		
		Scanner input = new Scanner(System.in);
		System.out.print("Enter in Scenario\n\t1) - Predetermined Q-Value Path\n\t2) - Randomized Q-Value Path\n\t3) - Consistent Q-Value Path\nEnter in here:");
		int num = input.nextInt();
		System.out.print("Enter in number of trials: ");
		int trials =  input.nextInt();
		input.close();
		
		//Create a Graph Object
		Graph enviro = new Graph();
		System.out.println(enviro.printNodeAttributes());
		enviro.chooseScenario(num);
		
		for(int i = 1; i <= trials; i++){ //records trials
			for(int j = 0; j < 10; j++){ //possible number of steps he can take
				int currentLocation = enviro.findAgent();
				if(enviro.isWinner(currentLocation)){ //End the Episode - the Agent found the goal.
					System.out.println("Simulation Over");
					System.out.println("Agent Located at: " + enviro.printNode(currentLocation) + "\n");
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
