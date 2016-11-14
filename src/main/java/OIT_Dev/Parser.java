package OIT_Dev;
import java.util.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/** 	CURRENT CSV FORMAT:
"Discipline;Course #;Section #;Course Name;Instructor ID;Meeting Days;Class Times;
Seating Type;Amount of Seats;whiteboard;chalkboard;computer/laptop;sound system;cd player;dvd player;
video projector;hearing assisted system;visual optimizer;laptop connectivity;
network connections;overhead projector;podium;projector screen;tv/monitors;piano"
TOTAL CRITERIA: 25
**/

public class Parser {

	private final String COMMA = ",";
	private String csvFile;
	private List<Class> classList = new ArrayList<Class>();
	
	public Parser(String fileName) {
		this.csvFile = fileName;
	}
	
	public List<Class> parse() {
		
		BufferedReader reader = null;
		
		try {
			int lineNumber = 1;
			String currentLine = "";
			reader = new BufferedReader(new FileReader(csvFile));
			
			while((currentLine = reader.readLine()) != null) {
				
				//Split current line into 'entries' array
				String[] entries = currentLine.split(COMMA);
				
				//Check to make sure there is enough criteria to create a Class
				if(entries.length == 9) {
					
					//Call abridged constructor - checkboxes all marked "n"
					Class currentClass = new Class(entries[0],entries[1],entries[2],entries[3],entries[4],entries[5],
						entries[6],entries[7],entries[8]);
					
					//Review formatting - close on fail
					if(review(entries, lineNumber) == false) {
						System.out.println("Please revise CSV format before resubmitting.");
						reader.close();
						return null;
					}
					
					//Add currentClass to classList
					classList.add(currentClass);
					
				} else if(entries.length == 24) {
				
					//Create Class object with currentLine's criteria
					Class currentClass = new Class(entries[0],entries[1],entries[2],entries[3],entries[4],entries[5],
						entries[6],entries[7],entries[8],entries[9],entries[10],entries[11],entries[12],entries[13],
						entries[14],entries[15],entries[16],entries[17],entries[18],entries[19],entries[20],entries[21],
						entries[22],entries[23],entries[24], 0);
					
					//Review formatting - close on fail
					if(review(entries, lineNumber) == false) {
						System.out.println("Please revise CSV format before resubmitting.");
						reader.close();
						return null;
					}
					
					//Add currentClass to classList
					classList.add(currentClass);
					
				} else {
					//Must be either 9 or 24 entries to construct a Class
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
	
	public boolean review(String[] e, int line) {
		//e[0] = Discipline
		//Discipline length check
		if(e[0].length() != 4) {
			System.out.println("Error in 'discipline' format (Line: " + line + ")");
			return false;
		}
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
		//e[2] = Section number
		//Section number length check
		if(e[2].length() > 2) {
			System.out.println("Error in 'section #' format. (Line: " + line + ")");
			return false;
		}
		//Section number isNumeric check
		if(isNumeric(e[2]) == false) {
			System.out.println("Error in 'section #' format; ensure both characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[3] = Course name
		//e[4] = Instructor id
		//Instructor id length check
		if(e[4].length() != 6) {
			System.out.println("Error in 'instructor id' format. (Line: " + line + ")");
			return false;
		}
		//Instructor id isNumeric check
		if(isNumeric(e[4]) == false) {
			System.out.println("Error in 'instructor id' format; ensure all 6 characters are digits. (Line: " + line + ")");
			return false;
		}
		//e[5] = Meeting days
		//Meeting days length check
		if(e[5].length() > 3) {
			System.out.println("Error in 'meeting days' format. (Line: " + line + ")");
			return false;
		}
		//e[6] = Class times
		//Seating type format check
		if(e[7].toLowerCase() != "group" || e[7].toLowerCase() != "individual") {
			System.out.println("Error in 'seating type' format (Line: " + line + ") (please use 'group' or 'individual').");
			return false;
		}
		//e[8] = Seat amount
		//Seat amount isNumeric check
		if(isNumeric(e[8]) == false) {
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
}