package OIT_Dev;

import java.util.ArrayList;

public class Population {

	Schedule[] schedules;
	ArrayList<Classroom> rooms = new ArrayList<Classroom>();

	/*
	 * Constructors
	 */
	// Create a population
	public Population(int populationSize, boolean initialize) {
		schedules = new Schedule[populationSize];
		// Initialize population
		if (initialize) {
			// Loop and create schedule
			for (int i = 0; i < size(); i++) {
				Schedule newSched = new Schedule();
				newSched.generateSched();
				saveSched(i, newSched);
			}
		}
	}

	/* Getters */
	public Schedule getSched(int index) {
		return schedules[index];
	}

	public Schedule getFittest() {
		Schedule fittest = schedules[0];
		// Loop through population to find fittest
		for (int i = 0; i < size(); i++) {
			if (fittest.getFitness() <= getSched(i).getFitness()) {
				fittest = getSched(i);
			}
		}
		return fittest;
	}

	/* Public methods */
	// Get population size
	public int size() {
		return schedules.length;
	}

	// Save schedule
	public void saveSched(int index, Schedule sch) {
		schedules[index] = sch;
	}
	
	
	public void evolve(int i, Population myPop){
		for (int j = 0; j < i; j++) {
            myPop = Algorithm.evolvePopulation(myPop);
        }
		
		System.out.println("Fitness: " + myPop.getFittest().getFitness()
			+ "\nSchedule:\n" + myPop.getFittest().toString());
	}
}