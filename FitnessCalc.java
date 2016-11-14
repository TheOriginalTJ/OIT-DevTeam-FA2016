package OIT_Dev;
/*
public class FitnessCalc {

	static byte[] solution = new byte[64];

	/* Public methods */
	// Set a candidate solution as a byte array
/*	public static void setSolution(byte[] newSolution) {
		solution = newSolution;
	}

	// To make it easier we can use this method to set our candidate solution
	// with string of 0s and 1s
	static void setSolution(String newSolution) {
		solution = new byte[newSolution.length()];
		// Loop through each character of our string and save it in our byte
		// array
		for (int i = 0; i < newSolution.length(); i++) {
			String character = newSolution.substring(i, i + 1);
			if (character.contains("0") || character.contains("1")) {
				solution[i] = Byte.parseByte(character);
			} else {
				solution[i] = 0;
			}
		}
	}

	// Calculate schedules fitness by comparing it to our candidate solution
	static int getFitness(Schedule sched) {
		int fitness = 0;
		// Loop through our schedules genes and compare them to our cadidates
		for (int i = 0; i < sched.size() && i < solution.length; i++) {
			if (sched.getGene(i) == solution[i]) {
				fitness++;
			}
		}
		return fitness;
	}

	// Get optimum fitness
	static int getMaxFitness() {
		int maxFitness = solution.length;
		return maxFitness;
	}

}
*/

public class FitnessCalc {

	static double solution = 0.1;
	Schedule currentBest = new Schedule();
	
	/* Public methods */
	// Set a candidate solution as a byte array
	public static void setSolution(double newSolution) {
		solution = newSolution;
	}

	// Calculate schedules fitness by checking which classroom attributes match the class requirements.
	static double getFitness(Schedule sched) {
		for (int i = 0; i < sched.size(); i++)
		//Make sure each gene HAS a score to work with.
			sched.getGene(i).calcScore();
		double total = 0;
		double count = 0;
		double fitness = 0;
		// Loop through our genes and add points to our fitness for each classes individual fitness.
		for (int i = 0; i < sched.size(); i++) {
			total += sched.getGene(i).getScore();//Get the fitness score from the i'th class in our schedule.
			count += 1;//ALWAYS INCREMENT COUNT IN ORDER TO TRACK SIZE EASILY.
		}//Fitness is a ratio, registering our total score of individual fitnesses over our potential perfect score.
		fitness = total/count;//The reult will always be less than or equal to 1.
		return fitness;//Return fitness as a double (decimal) which show percentage of needs met.
	}

	// Get optimum fitness
	static double crntOptFitness(Schedule scheds[]) {
		double currentOpt = 0;
		for(int i = 0; i < scheds.length; i++)
		{
			if(FitnessCalc.getFitness(scheds[i]) > currentOpt)
			{
				currentOpt = FitnessCalc.getFitness(scheds[i]);
			}
			
		}
		return currentOpt;
	}

	static double getMaxFitness(){
		return solution;
	}

	public boolean validSolution(double score){
		if(score >= solution)//If our 'score' meets the goal, return true.
			return true;
		else//If the score is less than the goal, return false.
			return false;
	}

}