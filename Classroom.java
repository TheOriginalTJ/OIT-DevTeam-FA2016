package OIT_Dev;

public class Classroom {
	
	private String building;
	private int roomnum;
	private int seats;
	private String seatingtype;
	private boolean whiteboard;
	private boolean chalkboard;
	private boolean computer;
	private boolean soundsystem;
	private boolean cdplayer;
	private boolean dvdplayer;
	private boolean videoprojector;
	private boolean hearingassisted;
	private boolean visualoptimizer;
	private boolean laptopconnectivity;
	private boolean networkconnections;
	private boolean overheadprojector;
	private boolean podium;
	private boolean projectorscreen;
	private boolean monitors;
	private boolean piano;
	private Class currentclass;
	
	//abridged constructor
	public Classroom(String building, int roomnum, int seats, String seatingtype){
		this.building = building;
		this.roomnum = roomnum;
		this.seats = seats;
		this.seatingtype = seatingtype;
	}// end constructor
	
	//full constructor
	public Classroom(String building, int roomnum, int seats, String seatingtype, boolean w, boolean ch,
			boolean co, boolean s, boolean cd, boolean dvd, boolean v, boolean h, boolean vis, boolean l,
			boolean n, boolean o, boolean pod, boolean ps, boolean m, boolean p) {
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
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public int getRoomnum() {
		return roomnum;
	}

	public void setRoomnum(int roomnum) {
		this.roomnum = roomnum;
	}

	public int getSeats() {
		return seats;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public String getSeatingtype() {
		return seatingtype;
	}

	public void setSeatingtype(String seatingtype) {
		this.seatingtype = seatingtype;
	}

	public boolean isWhiteboard() {
		return whiteboard;
	}

	public void setWhiteboard(boolean whiteboard) {
		this.whiteboard = whiteboard;
	}

	public boolean isChalkboard() {
		return chalkboard;
	}

	public void setChalkboard(boolean chalkboard) {
		this.chalkboard = chalkboard;
	}

	public boolean isComputer() {
		return computer;
	}

	public void setComputer(boolean computer) {
		this.computer = computer;
	}

	public boolean isSoundsystem() {
		return soundsystem;
	}

	public void setSoundsystem(boolean soundsystem) {
		this.soundsystem = soundsystem;
	}

	public boolean isCdplayer() {
		return cdplayer;
	}

	public void setCdplayer(boolean cdplayer) {
		this.cdplayer = cdplayer;
	}

	public boolean isDvdplayer() {
		return dvdplayer;
	}

	public void setDvdplayer(boolean dvdplayer) {
		this.dvdplayer = dvdplayer;
	}

	public boolean isVideoprojector() {
		return videoprojector;
	}

	public void setVideoprojector(boolean videoprojector) {
		this.videoprojector = videoprojector;
	}

	public boolean isHearingassisted() {
		return hearingassisted;
	}

	public void setHearingassisted(boolean hearingassisted) {
		this.hearingassisted = hearingassisted;
	}

	public boolean isVisualoptimizer() {
		return visualoptimizer;
	}

	public void setVisualoptimizer(boolean visualoptimizer) {
		this.visualoptimizer = visualoptimizer;
	}

	public boolean isLaptopconnectivity() {
		return laptopconnectivity;
	}

	public void setLaptopconnectivity(boolean laptopconnectivity) {
		this.laptopconnectivity = laptopconnectivity;
	}

	public boolean isNetworkconnections() {
		return networkconnections;
	}

	public void setNetworkconnections(boolean networkconnections) {
		this.networkconnections = networkconnections;
	}

	public boolean isOverheadprojector() {
		return overheadprojector;
	}

	public void setOverheadprojector(boolean overheadprojector) {
		this.overheadprojector = overheadprojector;
	}

	public boolean isPodium() {
		return podium;
	}

	public void setPodium(boolean podium) {
		this.podium = podium;
	}

	public boolean isProjectorscreen() {
		return projectorscreen;
	}

	public void setProjectorscreen(boolean projectorscreen) {
		this.projectorscreen = projectorscreen;
	}

	public boolean isMonitors() {
		return monitors;
	}

	public void setMonitors(boolean monitors) {
		this.monitors = monitors;
	}

	public boolean isPiano() {
		return piano;
	}

	public void setPiano(boolean piano) {
		this.piano = piano;
	}

	public Class getCurrentclass() {
		return currentclass;
	}

	public void setCurrentclass(Class currentclass) {
		this.currentclass = currentclass;
	}

	
}
