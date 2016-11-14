package OIT_Dev;

import java.util.ArrayList;

public class Schedule {

	//static int defaultGeneLength = 64;
	private ArrayList<Class> genes = new ArrayList<Class>();
	private ArrayList<Classroom> rooms = new ArrayList<Classroom>();
	// Cache
	private double fitness = 0;
	
	public Schedule(String fileName, ArrayList<Classroom> roomList)
	{
		Parser myParser = new Parser(fileName);
		genes = new ArrayList<Class>(myParser.parse());
		rooms = new ArrayList<Classroom>(roomList);
	}

	// Create a random schedule
	public void generateSched() {
		
	}

	/* Getters and setters */
	// Use this if you want to create schedule with different gene lengths
	
	/*
	public static void setDefaultGeneLength(int length) {
		defaultGeneLength = length;
	}
	*/

	public Class getGene(int index) {
		return genes.get(index);
	}

	public void setGene(int index, Class course) {
		genes.set(index, course);
		fitness = 0;
	}
	

	/* Public methods */
	public int size() {
		return genes.size();
	}

	public double getFitness() {
		if (fitness == 0) {
			fitness = FitnessCalc.getFitness(this);
		}
		return fitness;
	}

	@Override
	public String toString() {
		String geneString = "";
		for (int i = 0; i < genes.size(); i++) {
			geneString += getGene(i);
		}
		return geneString;
	}
	
	public boolean sameAs(Schedule sched){
		if((this.getFitness() != sched.getFitness())||(this.size() != sched.size())){
			return false;
		}
		else{
			for(int i = 0; i < genes.size(); i++){
				for(int j = 0; j < sched.size(); j++){
					if((this.getGene(i).getDisc().equals(sched.getGene(j).getDisc()))
							&&(this.getGene(i).getClassnum().equals(sched.getGene(j).getClassnum()))
									&&(this.getGene(i).getSectionnum().equals(sched.getGene(j).getSectionnum()))){
						if(this.getGene(i).getRoomchoice().equals(sched.getGene(j).getRoomchoice())){
							//Do nothing, this just means that at least one class is in the same room.
						}
						else{
							return false;//If even ONE CLASS is in a different location, 
											//then the schedules are NOT EQUAL.
						}
					}
				}
			}
		}
		return true;
	}
	
	
	/*
	public boolean sameAs(Schedule sched)
	{
		if(this.getFitness() != sched.getFitness())
		{
			return false;
		}
		else
		{
			for(int i = 0; i < genes.size(); i++)
			{
				if((this.genes.get(i).getDisc().equals(sched.getGene(i).getDisc()))&&
						(this.genes[i].getSection.equal(sched.getSection())))
			
		}
	}
	*/
}


