package OIT_Dev;


public class Class {
	
	private String classnum;
	private String sectionnum;
	private String courseName;
	private String instructorID;
	private String meetingDays;
	private String startTime;
	private String endTime;
	private String seatingType;
	private String numseats;
	private String cb_whiteboard;
	private String cb_chalkboard;
	private String cb_computer;
	private String cb_soundsystem;
	private String cb_cdplayer;
	private String cb_dvdplayer;
	private String cb_videoprojector;
	private String cb_hearingassisted;
	private String cb_visualoptimizer;
	private String cb_laptopconnectivity;
	private String cb_networkconnections;
	private String cb_overheadprojector;
	private String cb_podium;
	private String cb_projectorscreen;
	private String cb_monitors;
	private String cb_piano;
	private Classroom roomchoice;
	private double score;

	//constructor
	public Class(String classnum, String sectionnum, String courseName, 
			String instructorID, String meetingDays, String startTime, String endTime, String seatingType, 
			String numseats, String cb_whiteboard, String cb_chalkboard,
			String cb_computer, String cb_soundsystem, String cb_cdplayer,
			String cb_dvdplayer, String cb_videoprojector, String cb_hearingassisted,
			String cb_visualoptimizer, String cb_laptopconnectivity,
			String cb_networkconnections, String cb_overheadprojector,
			String cb_podium, String cb_projectorscreen, String cb_monitors, String cb_piano) { 
		this.classnum = classnum;
		this.sectionnum = sectionnum;
		this.courseName = courseName;
		this.instructorID = instructorID;
		this.meetingDays = meetingDays;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seatingType = seatingType;
		this.numseats = numseats;
		this.cb_whiteboard = cb_whiteboard;
		this.cb_chalkboard = cb_chalkboard;
		this.cb_computer = cb_computer;
		this.cb_soundsystem = cb_soundsystem;
		this.cb_cdplayer = cb_cdplayer;
		this.cb_dvdplayer = cb_dvdplayer;
		this.cb_videoprojector = cb_videoprojector;
		this.cb_hearingassisted = cb_hearingassisted;
		this.cb_visualoptimizer = cb_visualoptimizer;
		this.cb_laptopconnectivity = cb_laptopconnectivity;
		this.cb_networkconnections = cb_networkconnections;
		this.cb_overheadprojector = cb_overheadprojector;
		this.cb_podium = cb_podium;
		this.cb_projectorscreen = cb_projectorscreen;
		this.cb_monitors = cb_monitors;
		this.cb_piano = cb_piano;
		this.score = 0;
	} // end constructor
	
	//abridged constructor
	public Class(String classnum, String sectionnum, String courseName, 
			String instructorID, String meetingDays, String startTime, String endTime, String seatingType, 
			String numseats) {
		this.classnum = classnum;
		this.sectionnum = sectionnum;
		this.courseName = courseName;
		this.instructorID = instructorID;
		this.meetingDays = meetingDays;
		this.startTime = startTime;
		this.endTime = endTime;
		this.seatingType = seatingType;
		this.numseats = numseats;
		this.cb_whiteboard = "n";
		this.cb_chalkboard = "n";
		this.cb_computer = "n";
		this.cb_soundsystem = "n";
		this.cb_cdplayer = "n";
		this.cb_dvdplayer = "n";
		this.cb_videoprojector = "n";
		this.cb_hearingassisted = "n";
		this.cb_visualoptimizer = "n";
		this.cb_laptopconnectivity = "n";
		this.cb_networkconnections = "n";
		this.cb_overheadprojector = "n";
		this.cb_podium = "n";
		this.cb_projectorscreen = "n";
		this.cb_monitors = "n";
		this.cb_piano = "n";
	}
	
	//abridged constructor
		public Class(Class oldClass) {
			this.classnum = oldClass.classnum;
			this.sectionnum = oldClass.sectionnum;
			this.courseName = oldClass.courseName;
			this.instructorID = oldClass.instructorID;
			this.meetingDays = oldClass.meetingDays;
			this.startTime = oldClass.startTime;
			this.endTime = oldClass.endTime;
			this.seatingType = oldClass.seatingType;
			this.numseats = oldClass.numseats;
			this.cb_whiteboard = oldClass.cb_whiteboard;
			this.cb_chalkboard = oldClass.cb_chalkboard;
			this.cb_computer = oldClass.cb_computer;
			this.cb_soundsystem = oldClass.cb_soundsystem;
			this.cb_cdplayer = oldClass.cb_cdplayer;
			this.cb_dvdplayer = oldClass.cb_dvdplayer;
			this.cb_videoprojector = oldClass.cb_videoprojector;
			this.cb_hearingassisted = oldClass.cb_hearingassisted;
			this.cb_visualoptimizer = oldClass.cb_visualoptimizer;
			this.cb_laptopconnectivity = oldClass.cb_laptopconnectivity;
			this.cb_networkconnections = oldClass.cb_networkconnections;
			this.cb_overheadprojector = oldClass.cb_overheadprojector;
			this.cb_podium = oldClass.cb_podium;
			this.cb_projectorscreen = oldClass.cb_projectorscreen;
			this.cb_monitors = oldClass.cb_monitors;
			this.cb_piano = oldClass.cb_piano;
			this.score = 0;
		}

	public void calcScore(){
		double actual = 0;
		double possible = 0;
		
		Classroom room = this.getRoomchoice();
		
		if(this.getSeatingType().equals(room.getSeatingtype())){
			possible++;
			actual++;
		}else{
			possible++;
		}

		if(this.getNumseats() <= room.getSeats() + 5){
			possible++;
			actual++;
		}else{
			possible++;
		}
		
		if(this.getCb_whiteboard().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_whiteboard().equals("y") && room.isWhiteboard()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
		
		if(this.getCb_chalkboard().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_chalkboard().equals("y") && room.isChalkboard()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}

		if(this.getCb_computer().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_computer().equals("y") && room.isComputer()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
		
		if(this.getCb_soundsystem().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_soundsystem().equals("y") && room.isSoundsystem()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
	
		if(this.getCb_cdplayer().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_cdplayer().equals("y") && room.isCdplayer()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
	
		if(this.getCb_dvdplayer().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_dvdplayer().equals("y") && room.isDvdplayer()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
		
		if(this.getCb_videoprojector().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_videoprojector().equals("y") && room.isVideoprojector()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
		
		if(this.getCb_hearingassisted().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_hearingassisted().equals("y") && room.isHearingassisted()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
	
		if(this.getCb_visualoptimizer().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_visualoptimizer().equals("y") && room.isVisualoptimizer()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
		
		if(this.getCb_laptopconnectivity().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_laptopconnectivity().equals("y") && room.isLaptopconnectivity()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
	
		if(this.getCb_networkconnections().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_networkconnections().equals("y") && room.isNetworkconnections()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}

		if(this.getCb_overheadprojector().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_overheadprojector().equals("y") && room.isOverheadprojector()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}

		if(this.getCb_podium().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_podium().equals("y") && room.isPodium()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
		
		if(this.getCb_monitors().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_monitors().equals("y") && room.isMonitors()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
		
		if(this.getCb_piano().equals("n")){
			//DON'T ADD TO TOTAL ACTUAL OR TOTAL POSSIBLE.
		}else if(this.getCb_piano().equals("y") && room.isPiano()){
			possible++;
			actual++;
		}else{//Increment possible and not total to denote a failure to meet a requirement.
			possible++;
		}
		
		if(possible == 0){//If the class required no attributes.
			score = 1;
		}else{//If there are required attributes, we will calculate the score as a percentage.
			score = actual/possible;
		}
	}

	public String getClassnum() {
		return classnum;
	}

	public void setClassnum(String classnum) {
		this.classnum = classnum;
	}

	public String getSectionnum() {
		return sectionnum;
	}

	public void setSectionnum(String sectionnum) {
		this.sectionnum = sectionnum;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getInstructorID() {
		return instructorID;
	}

	public void setInstructorID(String instructorID) {
		this.instructorID = instructorID;
	}

	public String getMeetingDays() {
		return meetingDays;
	}

	public void setMeetingDays(String meetingDays) {
		this.meetingDays = meetingDays;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	
	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getSeatingType() {
		return seatingType;
	}

	public void setSeatingType(String seatingType) {
		this.seatingType = seatingType;
	}

	public int getNumseats() {
		int seats = Integer.parseInt(numseats);
		return seats;
	}

	public void setNumseats(String numseats) {
		this.numseats = numseats;
	}

	public String getCb_whiteboard() {
		return cb_whiteboard;
	}

	public void setCb_whiteboard(String cb_whiteboard) {
		this.cb_whiteboard = cb_whiteboard;
	}

	public String getCb_chalkboard() {
		return cb_chalkboard;
	}

	public void setCb_chalkboard(String cb_chalkboard) {
		this.cb_chalkboard = cb_chalkboard;
	}

	public String getCb_computer() {
		return cb_computer;
	}

	public void setCb_computer(String cb_computer) {
		this.cb_computer = cb_computer;
	}

	public String getCb_soundsystem() {
		return cb_soundsystem;
	}

	public void setCb_soundsystem(String cb_soundsystem) {
		this.cb_soundsystem = cb_soundsystem;
	}

	public String getCb_cdplayer() {
		return cb_cdplayer;
	}

	public void setCb_cdplayer(String cb_cdplayer) {
		this.cb_cdplayer = cb_cdplayer;
	}

	public String getCb_dvdplayer() {
		return cb_dvdplayer;
	}

	public void setCb_dvdplayer(String cb_dvdplayer) {
		this.cb_dvdplayer = cb_dvdplayer;
	}

	public String getCb_videoprojector() {
		return cb_videoprojector;
	}

	public void setCb_videoprojector(String cb_videoprojector) {
		this.cb_videoprojector = cb_videoprojector;
	}

	public String getCb_hearingassisted() {
		return cb_hearingassisted;
	}

	public void setCb_hearingassisted(String cb_hearingassisted) {
		this.cb_hearingassisted = cb_hearingassisted;
	}

	public String getCb_visualoptimizer() {
		return cb_visualoptimizer;
	}

	public void setCb_visualoptimizer(String cb_visualoptimizer) {
		this.cb_visualoptimizer = cb_visualoptimizer;
	}

	public String getCb_laptopconnectivity() {
		return cb_laptopconnectivity;
	}

	public void setCb_laptopconnectivity(String cb_laptopconnectivity) {
		this.cb_laptopconnectivity = cb_laptopconnectivity;
	}

	public String getCb_networkconnections() {
		return cb_networkconnections;
	}

	public void setCb_networkconnections(String cb_networkconnections) {
		this.cb_networkconnections = cb_networkconnections;
	}

	public String getCb_overheadprojector() {
		return cb_overheadprojector;
	}

	public void setCb_overheadprojector(String cb_overheadprojector) {
		this.cb_overheadprojector = cb_overheadprojector;
	}

	public String getCb_podium() {
		return cb_podium;
	}

	public void setCb_podium(String cb_podium) {
		this.cb_podium = cb_podium;
	}

	public String getCb_projectorscreen() {
		return cb_projectorscreen;
	}

	public void setCb_projectorscreen(String cb_projectorscreen) {
		this.cb_projectorscreen = cb_projectorscreen;
	}

	public String getCb_monitors() {
		return cb_monitors;
	}

	public void setCb_monitors(String cb_monitors) {
		this.cb_monitors = cb_monitors;
	}

	public String getCb_piano() {
		return cb_piano;
	}

	public void setCb_piano(String cb_piano) {
		this.cb_piano = cb_piano;
	}

	public Classroom getRoomchoice() {
		return roomchoice;
	}

	public void setRoomchoice(Classroom roomchoice) {
		this.roomchoice = roomchoice;
	}
	
	public void setScore(double rating){
	    score = rating;
	}

	public double getScore(){
	    return score;
	}
	
	public boolean equalTo(Class cmpr){//Pass in the comparative class so we can check.
			if(this.getClassnum().equals(cmpr.getClassnum())//Really...
				&&(this.getSectionnum().equals(cmpr.getSectionnum()))){//long if statement.
			return true;
		}
		else
			return false;
	}
	
	public String toString(){
		return getClassnum() + "-" + getSectionnum();
		
	}
	
}