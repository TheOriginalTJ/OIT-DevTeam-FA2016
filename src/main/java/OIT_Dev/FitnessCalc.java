package OIT_Dev;


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