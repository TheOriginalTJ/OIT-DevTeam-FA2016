
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
	
	//abridged constructor
	public Classroom(String building, String roomnum, String seats, String seatingtype){
		this.building = building;
		this.roomnum = roomnum;
		this.seats = seats;
		this.seatingtype = seatingtype;
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

	public String getSeats() {
		return seats;
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

	public String isWhiteboard() {
		return whiteboard;
	}

	public void setWhiteboard(String whiteboard) {
		this.whiteboard = whiteboard;
	}

	public String isChalkboard() {
		return chalkboard;
	}

	public void setChalkboard(String chalkboard) {
		this.chalkboard = chalkboard;
	}

	public String isComputer() {
		return computer;
	}

	public void setComputer(String computer) {
		this.computer = computer;
	}

	public String isSoundsystem() {
		return soundsystem;
	}

	public void setSoundsystem(String soundsystem) {
		this.soundsystem = soundsystem;
	}

	public String isCdplayer() {
		return cdplayer;
	}

	public void setCdplayer(String cdplayer) {
		this.cdplayer = cdplayer;
	}

	public String isDvdplayer() {
		return dvdplayer;
	}

	public void setDvdplayer(String dvdplayer) {
		this.dvdplayer = dvdplayer;
	}

	public String isVideoprojector() {
		return videoprojector;
	}

	public void setVideoprojector(String videoprojector) {
		this.videoprojector = videoprojector;
	}

	public String isHearingassisted() {
		return hearingassisted;
	}

	public void setHearingassisted(String hearingassisted) {
		this.hearingassisted = hearingassisted;
	}

	public String isVisualoptimizer() {
		return visualoptimizer;
	}

	public void setVisualoptimizer(String visualoptimizer) {
		this.visualoptimizer = visualoptimizer;
	}

	public String isLaptopconnectivity() {
		return laptopconnectivity;
	}

	public void setLaptopconnectivity(String laptopconnectivity) {
		this.laptopconnectivity = laptopconnectivity;
	}

	public String isNetworkconnections() {
		return networkconnections;
	}

	public void setNetworkconnections(String networkconnections) {
		this.networkconnections = networkconnections;
	}

	public String isOverheadprojector() {
		return overheadprojector;
	}

	public void setOverheadprojector(String overheadprojector) {
		this.overheadprojector = overheadprojector;
	}

	public String isPodium() {
		return podium;
	}

	public void setPodium(String podium) {
		this.podium = podium;
	}

	public String isProjectorscreen() {
		return projectorscreen;
	}

	public void setProjectorscreen(String projectorscreen) {
		this.projectorscreen = projectorscreen;
	}

	public String isMonitors() {
		return monitors;
	}

	public void setMonitors(String monitors) {
		this.monitors = monitors;
	}

	public String isPiano() {
		return piano;
	}

	public void setPiano(String piano) {
		this.piano = piano;
	}

	public Class getCurrentclass() {
		return currentclass;
	}

	public void setCurrentclass(Class currentclass) {
		this.currentclass = currentclass;
	}

	
}