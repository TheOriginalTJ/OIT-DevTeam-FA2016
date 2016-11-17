package OIT_Dev;

import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** 	CURRENT CSV FORMAT:
 * 	CLASS:
"Discipline;Section #;Course Name;Instructor ID;Meeting Days;Start Time;End Time;
Seating Type;Amount of Seats;whiteboard;chalkboard;computer/laptop;sound system;cd player;dvd player;
video projector;hearing assisted system;visual optimizer;laptop connectivity;
network connections;overhead projector;podium;projector screen;tv/monitors;piano"
TOTAL CRITERIA: 25
	CLASSROOM:
"Building;Roomnum;Seats;Seatingtype;whiteboard;chalkboard;computer;soundsystem;cdplayer;dvdplayer;
videoprojector;hearingassisted;visualoptimizer;laptopconnectivity;networkconnections;overheadprojector;
podium;projectorscreen;monitors;piano"
TOTAL CRITERIA: 20
**/

public class Parser {

	private final String TAB = "\t";
	private String csvFile;
	List<Class> classList = null;
	List<Classroom> classroomList = null;
	
	public Parser(String fileName) {
		this.csvFile = fileName;
	}
	
	public List<Class> parseClass() {
		
		BufferedReader reader = null;
		classList = new ArrayList<Class>();
		
		try {
			int lineNumber = 1;
			String currentLine = "";
			reader = new BufferedReader(new FileReader(csvFile));
			//Skip first line
			reader.readLine();
			
			while((currentLine = reader.readLine()) != null) {
				
				//Split current line into 'entries' array
				String[] entries = currentLine.split(TAB);
				
				//Check to make sure there is enough criteria to create a Class
				if(entries.length == 9) {
					
					//Call abridged constructor - checkboxes all marked "n"
					/*
					 * [0] = classnum
					 * [1] = sectionnum
					 * [2] = courseName
					 * [3] = instructorID
					 * [4] = meetingDays
					 * [5] = startTime
					 * [6] = endTime
					 * [7] = seatingType
					 * [8] = numseats
					 */
					Class currentClass = new Class(entries[0],entries[1],entries[2],entries[3],entries[4],entries[5],
						entries[6],entries[8],entries[7]);
					
					//Review formatting - close on fail
					if(reviewClass(entries, lineNumber) == false) {
						System.out.println("Please revise CSV format before resubmitting.");
						reader.close();
						return null;
					}
					
					//Add currentClass to classList
					classList.add(currentClass);
					
				} else if(entries.length == 25) {
				
					//Create Class object with currentLine's criteria
					/*
					 * [0] = classnum
					 * [1] = sectionnum
					 * [2] = courseName
					 * [3] = instructorID
					 * [4] = meetingDays
					 * [5] = startTime
					 * [6] = endTime
					 * [7] = seatingType
					 * [8] = numseats
					 */
					Class currentClass = new Class(entries[0],entries[1],entries[2],entries[3],entries[4],entries[5],
						entries[6],entries[8],entries[7],entries[9],entries[10],entries[11],entries[12],entries[13],
						entries[14],entries[15],entries[16],entries[17],entries[18],entries[19],entries[20],entries[21],
						entries[22],entries[23],entries[24]);
					
					//Review formatting - close on fail
					if(reviewClass(entries, lineNumber) == false) {
						System.out.println("Please revise CSV format before resubmitting.");
						reader.close();
						return null;
					}
					
					//Add currentClass to classList
					classList.add(currentClass);
					
				} else {
					//Must be either 9 or 25 entries to construct a Class
					System.out.println("Error in CSV format: Line " + lineNumber);
					System.out.println("Please revise CSV format before resubmitting.");
					reader.close();
					return null;
				}
				
				lineNumber++;
			}
		} catch(Exception e) {
			System.out.println("Generic error in parsing file.");
		}
		
		try {
			reader.close();
		} catch(IOException e) {
			System.out.println("Error in closing BufferedReader");
		}
		
		return classList;
	}
	
	public List<Classroom> parseClassroom() {
		
		BufferedReader reader = null;
		classroomList = new ArrayList<Classroom>();
		
		try {
			int lineNumber = 1;
			String currentLine = "";
			reader = new BufferedReader(new FileReader(csvFile));
			//Skip first line
			reader.readLine();
			
			while((currentLine = reader.readLine()) != null) {
				
				//Split current line into 'entries' array
				String[] entries = currentLine.split(TAB);
				
				//Check to make sure there is enough criteria to create a Classroom
				if(entries.length == 20) {
					
					//Create Classroom object with currentLine's criteria
					/*
					 * [0] = building
					 * [1] = roomnum
					 * [2] = seats
					 * [3] = seatingtype
					 * [4] = whiteboard
					 * [5] = chalkboard
					 * [6] = computer
					 * [7] = soundsystem
					 * [8] = cdplayer
					 * [9] = dvdplayer
					 * [10] = videoprojector
					 * [11] = hearingassisted
					 * [12] = visualoptimizer
					 * [13] = laptopconnectivity
					 * [14] = networkconnections
					 * [15] = overheadprojector
					 * [16] = podium
					 * [17] = projectorscreen
					 * [18] = monitors
					 * [19] = piano
					 */
					Classroom currentClassroom = new Classroom(entries[0],entries[1],entries[2],entries[3],
							entries[4],entries[5],entries[6],entries[7],entries[8],entries[9],entries[10],
							entries[11],entries[12],entries[13],entries[14],entries[15],entries[16],entries[17],
							entries[18],entries[19]);
					
					//Review Classroom formatting - close on fail
					if(reviewClassroom(entries, lineNumber) == false) {
						System.out.println("Please review CSV before resubmitting.");
						reader.close();
						return null;
					}
					
					classroomList.add(currentClassroom);
				}
				
				lineNumber++;
			}
		} catch(Exception e) {
			System.out.println("Generic error in parsing file.");
		}
		
		try {
			reader.close();
		} catch(IOException e) {
			System.out.println("Error in closing BufferedReader");
		}
		
		return classroomList;
	}
	
	public boolean reviewClass(String[] e, int line) {
		//e[0] = classnum
		//Classnum length check
		if(e[0].length() < 4) {
			System.out.println("Error in 'classnum' format (Line: " + line + ")");
			return false;
		}
		
		/* REDACTED 11/11
		//e[1] = Course number
		//Course number length check
		if(e[1].length() != 3) {
			System.out.println("Error in 'course #' format. (Line: " + line + ")");
			return false;
		}
		//Course number isNumeric check
		if(isNumeric(e[1]) == false) {
			System.out.println("Error in 'course #' format; ensure all 3 characters are digits. (Line: " + line + ")");
			return false;
		}
		*/
		
		//e[1] = Section number
		//Section number length check
		//TO-DO: if sectionnum is 1 character, append '0' to beginning (ie. '1' --> '01')
		if(e[1].length() > 2) {
			System.out.println("Error in 'section #' format. (Line: " + line + ")");
			return false;
		}
		//Section number isNumeric check
		if(isNumeric(e[1]) == false) {
			System.out.println("Error in 'section #' format; ensure characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[2] = Course name
		//e[3] = Instructor id
		//Instructor id length check
		if(e[3].length() != 6) {
			System.out.println("Error in 'instructor id' format. (Line: " + line + ")");
			return false;
		}
		//Instructor id isNumeric check
		if(isNumeric(e[3]) == false) {
			System.out.println("Error in 'instructor id' format; ensure all 6 characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[4] = Meeting days
		//Meeting days length check
		if(e[4].length() != 7) {
			System.out.println("Error in 'meeting days' format; ensure it is seven (7) characters. (Line: " + line + ")");
			return false;
		}
		//e[5] = Start time
		//Start time length check
		if(e[5].length() > 4) {
			System.out.println("Error in 'start time' format; ensure military format. (Line: " + line + ")");
			return false;
		}
		//Start time isNumeric check
		if(isNumeric(e[5]) == false) {
			System.out.println("Error in 'start time' format; ensure all characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[6] = End time
		//End time length check
		if(e[6].length() > 4) {
			System.out.println("Error in 'end time' format; ensure military format. (Line: " + line + ")");
			return false;
		}
		//End time isNumeric check
		if(isNumeric(e[6]) == false) {
			System.out.println("Error in 'end time' format; ensure all characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[7] = Seating type
		//Seating type format check
		if(e[8].toLowerCase().equals("group") && e[8].toLowerCase().equals("individual")) {
			System.out.println("Error in 'seating type' format (Line: " + line + ") (please use 'group' or 'individual').");
			return false;
		}
		//e[8] = Seat amount
		//Seat amount isNumeric check
		if(isNumeric(e[7]) == false) {
			System.out.println("Error in 'seat amount' format; ensure all characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[9] to e[24] are y/n - format check
		for(int i = 9; i < e.length; i++) {
			//Length check
			if(e[i].length() > 1) {
				System.out.println("Error in checkbox criteria length - line: " + line + "/entry: " + i + " (please "
						+ "use 'y' or 'n' only for checkbox criteria.");
				return false;
			}
			//Character check
			if(e[i] != "y" && e[i] != "n") {
				System.out.println("Error in checkbox criteria format - line: " + line + "/entry: " + i + " (please "
						+ "use 'y' or 'n' only for checkbox criteria.");
				return false;
			}
		}
		return true;
	}
	
	public boolean reviewClassroom(String[] e, int line) {
		//e[0] = building
		//e[1] = roomnum
		//Room number isNumeric check
		if(isNumeric(e[1]) == false) {
			System.out.println("Error in room number format; ensure all characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[2] = seats
		//Seat amount isNumeric check
		if(isNumeric(e[2]) == false) {
			System.out.println("Error in seat amount format; ensure all characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[3] = seatingtype
		//Seating type format check
		if(e[3].toLowerCase() != "group" && e[3].toLowerCase() != "individual") {
			System.out.println("Error in 'seating type' format (Line: " + line + ") (please use 'group' or 'individual').");
			return false;
		}
		//e[4] to e[19] are y/n - format check
		for(int i = 4; i < e.length; i++) {
			//Length check
			if(e[i].length() > 1) {
				System.out.println("Error in checkbox criteria length - line: " + line + "/entry: " + i + " (please "
						+ "use 'y' or 'n' only for checkbox criteria.");
				return false;
			}
			//Character check
			if(e[i] != "y" && e[i] != "n") {
				System.out.println("Error in checkbox criteria format - line: " + line + "/entry: " + i + " (please "
						+ "use 'y' or 'n' only for checkbox criteria.");
				return false;
			}
		}
		return true;
	}
	
	//Simple method for checking if a String is numeric
	//FROM: http://stackoverflow.com/questions/1102891/how-to-check-if-a-string-is-numeric-in-java
	public static boolean isNumeric(String str)  {  
	  try {  
		  double d = Double.parseDouble(str);  
	  } catch(NumberFormatException nfe) {  
		  return false;
	  }  
	  return true;  
	}
	
	public String getCsvFile() {
		return csvFile;
	}
	
	public List<Class> getClassList() {
		return classList;
	}
	
	public void setClassList(List<Class> classList) {
		this.classList = classList;
	}
	
	public List<Classroom> getClassroomList() {
		return classroomList;
	}
	
	public void setClassroomList(List<Classroom> classroomList) {
		this.classroomList = classroomList;
	}
}