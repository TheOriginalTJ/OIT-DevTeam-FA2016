package OIT_Dev;

import java.util.ArrayList;

public class Schedule {

	//static int defaultGeneLength = 64;
	private ArrayList<Class> genes = new ArrayList<Class>();
	private ArrayList<Classroom> rooms = new ArrayList<Classroom>();
	// Cache
	private double fitness = 0;
	
	public int roomlength;
	public int genecount;
	
	public Schedule(){
		
	}
	
	public void mutateRoom(int index){
		Classroom initial = getGene(index).getRoomchoice();
		int j = (int) (Math.random()*100)%roomlength;
		
		if(getRoom(j).isTaken()){
			Class replace = getRoom(j).getCurrentclass();
			for(int i = 0; i < genecount; i++){
				if(getGene(i).equalTo(replace)){
					//Swap classes
					initial.setCurrentclass(replace);
					getRoom(j).setCurrentclass(getGene(index));
					//Swap Classrooms
					getGene(index).setRoomchoice(getRoom(j));
					replace.setRoomchoice(initial);
					//Exit for-loop.
					break;
				}
				else{
					//do nothing and progress through loop.
				}
			}
		}else{//If room is empty, simply update items and move rooms.
			genes.get(index).setRoomchoice(rooms.get(j));
			rooms.get(j).setCurrentclass(genes.get(index));
		}
	}
	
	
	//Need this resources object to reference throughout code
	private GUI_Dev.Resource res = new GUI_Dev.Resource();

	//This is in place of the current loadSchedule()

	public void loadSchedule(){
		genes = new ArrayList<Class>(res.classList.getClassList());
		genecount = genes.size();
		rooms = new ArrayList<Classroom>(res.roomList.getRoomList());
		roomlength = rooms.size();
	}

	// Create a random schedule
	public void generateSched() {
		for(int i = 0; i < size(); i++){
			int j = (int) (Math.random()*100)%rooms.size();
			int count = 0;
			while(rooms.get(j).isTaken()){
				if(j < rooms.size()-1){
					j++;
				}else{
					j = 0;
				}
				count += 1;
				if(count == rooms.size()){
					break;//HERE WE WILL THROW AN ERROR LATER ON.
				}
			}
			genes.get(i).setRoomchoice(rooms.get(j));
			rooms.get(j).setCurrentclass(genes.get(i));
		}
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
	
	public Classroom getRoom(int index) {
		return rooms.get(index);
	}

	public void setRoom(int index, Classroom room) {
		rooms.set(index, room);
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
			geneString += getGene(i).toString();
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
					if((this.getGene(i).getClassnum().equals(sched.getGene(j).getClassnum()))
									&&(this.getGene(i).getSectionnum().equals(sched.getGene(j).getSectionnum()))){
						if(this.getGene(i).getRoomchoice().equals(sched.getGene(j).getRoomchoice())){
							//Do nothing, this just means that at least one class is in the same room.
						}
						else{
							return false;//If even ONE CLASS is in a different location, 
						}//then the schedules are NOT EQUAL.
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


