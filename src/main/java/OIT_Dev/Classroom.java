package OIT_Dev;

public class Classroom {
	
	private String building;
	private String roomnum;
	private String seats;
	private String seatingtype;
	private String whiteboard;
	private String chalkboard;
	private String computer;
	private String soundsystem;
	private String cdplayer;
	private String dvdplayer;
	private String videoprojector;
	private String hearingassisted;
	private String visualoptimizer;
	private String laptopconnectivity;
	private String networkconnections;
	private String overheadprojector;
	private String podium;
	private String projectorscreen;
	private String monitors;
	private String piano;
	private Class currentclass;
	Time times;
	
	//abridged constructor
	public Classroom(String building, String roomnum, String seats, String seatingtype){
		this.building = building;
		this.roomnum = roomnum;
		this.seats = seats;
		this.seatingtype = seatingtype;
		this.times = new Time();
	}// end constructor
	
	//full constructor
	public Classroom(String building, String roomnum, String seats, String seatingtype, String w, String ch,
			String co, String s, String cd, String dvd, String v, String h, String vis, String l,
			String n, String o, String pod, String ps, String m, String p) {
		this.building = building;
		this.roomnum = roomnum;
		this.seats = seats;
		this.seatingtype = seatingtype;
		this.whiteboard = w;
		this.chalkboard = ch;
		this.computer = co;
		this.soundsystem = s;
		this.cdplayer = cd;
		this.dvdplayer = dvd;
		this.videoprojector = v;
		this.hearingassisted = h;
		this.visualoptimizer = vis;
		this.laptopconnectivity = l;
		this.networkconnections = n;
		this.overheadprojector = o;
		this.podium = pod;
		this.projectorscreen = ps;
		this.monitors = m;
		this.piano = p;
		this.times = new Time();
	}
	
	
	public Classroom(Classroom oldClassroom){
		this.building = oldClassroom.getBuilding();
		this.roomnum = oldClassroom.getRoomnum();
		this.seats = "" + oldClassroom.getSeats();
		this.seatingtype = oldClassroom.getSeatingtype();
		if(oldClassroom.isWhiteboard()){
			this.whiteboard = "y";
		}else{
			this.whiteboard = "n";
		}
		if(oldClassroom.isChalkboard()){
			this.chalkboard = "y";
		}else{
			this.chalkboard = "n";
		}
		if(oldClassroom.isComputer()){
			this.computer = "y";
		}else{
			this.computer = "n";
		}
		if(oldClassroom.isSoundsystem()){
			this.soundsystem = "y";
		}else{
			this.soundsystem = "n";
		}
		if(oldClassroom.isCdplayer()){
			this.cdplayer = "y";
		}else{
			this.cdplayer = "n";
		}
		if(oldClassroom.isDvdplayer()){
			this.dvdplayer = "y";
		}else{
			this.dvdplayer = "n";
		}
		if(oldClassroom.isVideoprojector()){
			this.videoprojector = "y";
		}else{
			this.videoprojector = "n";
		}
		if(oldClassroom.isHearingassisted()){
			this.hearingassisted = "y";
		}else{
			this.hearingassisted = "n";
		}
		if(oldClassroom.isVisualoptimizer()){
			this.visualoptimizer = "y";
		}else{
			this.visualoptimizer = "n";
		}
		if(oldClassroom.isLaptopconnectivity()){
			this.laptopconnectivity = "y";
		}else{
			this.laptopconnectivity = "n";
		}
		if(oldClassroom.isNetworkconnections()){
			this.networkconnections = "y";
		}else{
			this.networkconnections = "n";
		}
		if(oldClassroom.isOverheadprojector()){
			this.overheadprojector = "y";
		}else{
			this.overheadprojector = "n";
		}
		if(oldClassroom.isPodium()){
			this.podium = "y";
		}else{
			this.podium = "n";
		}
		if(oldClassroom.isProjectorscreen()){
			this.projectorscreen = "y";
		}else{
			this.projectorscreen = "n";
		}
		if(oldClassroom.isMonitors()){
			this.monitors = "y";
		}else{
			this.monitors = "n";
		}
		if(oldClassroom.isPiano()){
			this.piano = "y";
		}else{
			this.piano = "n";
		}
		this.currentclass = new Class(oldClassroom.getCurrentclass());
	}
	

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(String roomnum) {
		this.roomnum = roomnum;
	}

	public int getSeats() {
		return Integer.parseInt(seats);
	}

	public void setSeats(String seats) {
		this.seats = seats;
	}

	public String getSeatingtype() {
		return seatingtype;
	}

	public void setSeatingtype(String seatingtype) {
		this.seatingtype = seatingtype;
	}

	public boolean isWhiteboard() {
		if(whiteboard.equals("y")){
			return true;
		}
		return false;
	}

	public void setWhiteboard(String whiteboard) {
		this.whiteboard = whiteboard;
	}

	public boolean isChalkboard() {
		if(chalkboard.equals("y")){
			return true;
		}
		return false;
	}

	public void setChalkboard(String chalkboard) {
		this.chalkboard = chalkboard;
	}

	public boolean isComputer() {
		if(computer.equals("y")){
			return true;
		}
		return false;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public boolean isSoundsystem() {
		if(soundsystem.equals("y")){
			return true;
		}
		return false;
	}

	public void setSoundsystem(String soundsystem) {
		this.soundsystem = soundsystem;
	}

	public boolean isCdplayer() {
		if(cdplayer.equals("y")){
			return true;
		}
		return false;
	}

	public void setCdplayer(String cdplayer) {
		this.cdplayer = cdplayer;
	}

	public boolean isDvdplayer() {
		if(dvdplayer.equals("y")){
			return true;
		}
		return false;
	}

	public void setDvdplayer(String dvdplayer) {
		this.dvdplayer = dvdplayer;
	}

	public boolean isVideoprojector() {
		if(videoprojector.equals("y")){
			return true;
		}
		return false;
	}

	public void setVideoprojector(String videoprojector) {
		this.videoprojector = videoprojector;
	}

	public boolean isHearingassisted() {
		if(hearingassisted.equals("y")){
			return true;
		}
		return false;
	}

	public void setHearingassisted(String hearingassisted) {
		this.hearingassisted = hearingassisted;
	}

	public boolean isVisualoptimizer() {
		if(visualoptimizer.equals("y")){
			return true;
		}
		return false;
	}

	public void setVisualoptimizer(String visualoptimizer) {
		this.visualoptimizer = visualoptimizer;
	}

	public boolean isLaptopconnectivity() {
		if(laptopconnectivity.equals("y")){
			return true;
		}
		return false;
	}

	public void setLaptopconnectivity(String laptopconnectivity) {
		this.laptopconnectivity = laptopconnectivity;
	}

	public boolean isNetworkconnections() {
		if(networkconnections.equals("y")){
			return true;
		}
		return false;
	}

	public void setNetworkconnections(String networkconnections) {
		this.networkconnections = networkconnections;
	}

	public boolean isOverheadprojector() {
		if(overheadprojector.equals("y")){
			return true;
		}
		return false;
	}

	public void setOverheadprojector(String overheadprojector) {
		this.overheadprojector = overheadprojector;
	}

	public boolean isPodium() {
		if(podium.equals("y")){
			return true;
		}
		return false;
	}

	public void setPodium(String podium) {
		this.podium = podium;
	}

	public boolean isProjectorscreen() {
		if(projectorscreen.equals("y")){
			return true;
		}
		return false;
	}

	public void setProjectorscreen(String projectorscreen) {
		this.projectorscreen = projectorscreen;
	}

	public boolean isMonitors() {
		if(monitors.equals("y")){
			return true;
		}
		return false;
	}

	public void setMonitors(String monitors) {
		this.monitors = monitors;
	}

	public boolean isPiano() {
		if(piano.equals("y")){
			return true;
		}
		return false;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	public Class getCurrentclass() {
		return this.currentclass;
	}

	public void setCurrentclass(Class currentclass) {
		this.currentclass = currentclass;
	}

	public boolean isTaken(){
		if(this.currentclass == null){
			return false;
		}
		return true;
	}
	
	public boolean equalTo(Classroom cmpr){//Pass in the comparative class so we can check.
		if((this.getBuilding().equals(cmpr.getBuilding()))//A really, really
			&&(this.getRoomnum() == cmpr.getRoomnum())){//long if statement.
			return true;
		}
		else
			return false;
	}
	
	public String toString(){
	
		String seatingtype;
		
		if(getSeatingtype().equals("Group Seating")){
			seatingtype="group";
		}else{
			seatingtype="individual";
		}
		
		String build = getBuilding() + "\t" + getRoomnum() + "\t" + getSeats() + "\t" + seatingtype + "\t" +
				this.whiteboard + "\t" + this.chalkboard + "\t" + this.computer + "\t" +
				this.soundsystem + "\t" + this.cdplayer + "\t" + this.dvdplayer + "\t" +
				this.videoprojector + "\t" + this.hearingassisted + "\t" + this.visualoptimizer + "\t" +
				this.laptopconnectivity + "\t" + this.networkconnections + "\t" + this.overheadprojector + "\t" +
				this.podium + "\t" + this.projectorscreen + "\t" + this.monitors + "\t" + this.piano;
		return build;
	
	}
	
}