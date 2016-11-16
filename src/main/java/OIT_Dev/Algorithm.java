package OIT_Dev;


public class Algorithm {

	/* GA parameters */
    private static final double uniformRate = 0.5;
    private static final double mutationRate = 0.015;
    private static final int tournamentSize = 5;
    private static final boolean elitism = true;

    /* Public methods */
    
    // Evolve a population
    public static Population evolvePopulation(Population pop) {
        Population newPopulation = new Population(pop.size(), false);

        // Keep our best schedule
        if (elitism) {
            newPopulation.saveSched(0, pop.getFittest());
        }

        // Crossover population
        int elitismOffset;
        if (elitism) {
            elitismOffset = 1;
        } else {
            elitismOffset = 0;
        }
        // Loop over the population size and create new schedules with
        // crossover
        for (int i = elitismOffset; i < pop.size(); i++) {
            Schedule indiv1 = tournamentSelection(pop);
            Schedule indiv2 = tournamentSelection(pop);
            Schedule newIndiv = crossover(indiv1, indiv2);
            newPopulation.saveSched(i, newIndiv);
        }

        // Mutate population
        for (int i = elitismOffset; i < newPopulation.size(); i++) {
            mutate(newPopulation.getSched(i));
        }

        return newPopulation;
    }

    // Crossover schedules
    private static Schedule crossover(Schedule sched1, Schedule sched2) {
        Schedule newSol = new Schedule();
        // Loop through genes
        for (int i = 0; i < sched1.size(); i++) {
            // Crossover
            if (Math.random() <= uniformRate) {
                newSol.setGene(i, sched1.getGene(i));
            } else {
                newSol.setGene(i, sched2.getGene(i));
            }
        }
        for(int i = 0; i < sched1.size(); i++){
        	for(int j = 0; j < sched1.size(); j++){
        		
        	}
        }
        for(int i = 0; i < sched1.size(); i++){
        	for(int j = 0; j < sched1.size(); j++){
        		
        	}
        }
        return newSol;
    }

    // Mutate an ENTIRE SCHEDULE
    private static void mutate(Schedule sched) {
        /*// Loop through genes
        for (int i = 0; i < sched.size(); i++) {
            if (Math.random() <= mutationRate) {
                // Create random gene
            	int newBuilding = (int)(Math.random()*100)%8;
                Class gene = new Class(sched.getGene(i));
                sched.setGene(i, gene);
            }
        }*/
    	for(int i = 0; i < sched.genecount; i++){
    		boolean mutate;
    		if(Math.random() <= mutationRate){
    			mutate = true;
    		}
    		else{
    			mutate = false;
    		}
    		if(mutate){
    			sched.mutateRoom(i);
    		}
		}
    }

    // Select sched for crossover
    private static Schedule tournamentSelection(Population pop) {
        // Create a tournament population
        Population tournament = new Population(tournamentSize, false);
        // For each place in the tournament get a random schedule
        for (int i = 0; i < tournamentSize; i++) {
            int randomId = (int) (Math.random() * pop.size());
            tournament.saveSched(i, pop.getSched(randomId));
        }
        // Get the fittest
        Schedule fittest = tournament.getFittest();
        return fittest;
    }
	
}
