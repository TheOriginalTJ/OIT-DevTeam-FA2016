package GUI_Dev;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AddClassroomServlet extends HttpServlet {

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String building = request.getParameter("building");
        String classroom_number = request.getParameter("classroom_number");
        String number_of_slots = request.getParameter("number_of_slots_classroom");
        String chairs = request.getParameter("chairs_classroom");
     
        String[] checkbox = {"whiteboard", "chalkBoard", "computerLaptop", "soundSystem", "cd", "dvd", "dataVideoProjector",
                "hearingAssisted", "visualOptimizer", "laptopConnectivity", "networkConnection", "overhearProjector", "podium",
                "projectorScreen", "tvMonitors", "piano"};

        String cb_whiteboard=null;
        String cb_chalkBoard=null;
        String cb_computerLaptop=null;
        String cb_soundSystem=null;
        String cb_cd=null;
        String cb_dvd=null;
        String cb_dataVideoProjector=null;
        String cb_hearingAssisted=null;
        String cb_visualOptimizer=null;
        String cb_laptopConnectivity=null;
        String cb_networkConnection=null;
        String cb_overhearProjector=null;
        String cb_podium=null;
        String cb_projectorScreen=null;
        String cb_tvMonitors=null;
        String cb_piano=null;

        String parameter;
        boolean isnull;
        for(int i=0; i<checkbox.length; i++){
            parameter = request.getParameter(checkbox[i]);
            isnull = parameter==null;
            if(isnull){
                switch (i){
                    case 0:
                        cb_whiteboard = "no";
                        break;
                    case 1:
                        cb_chalkBoard = "no";
                        break;
                    case 2:
                        cb_computerLaptop = "no";
                        break;
                    case 3:
                        cb_soundSystem = "no";
                        break;
                    case 4:
                        cb_cd = "no";
                        break;
                    case 5:
                        cb_dvd = "no";
                        break;
                    case 6:
                        cb_dataVideoProjector = "no";
                        break;
                    case 7:
                        cb_hearingAssisted = "no";
                        break;
                    case 8:
                        cb_visualOptimizer = "no";
                        break;
                    case 9:
                        cb_laptopConnectivity = "no";
                        break;
                    case 10:
                        cb_networkConnection = "no";
                        break;
                    case 11:
                        cb_overhearProjector = "no";
                        break;
                    case 12:
                        cb_podium = "no";
                        break;
                    case 13:
                        cb_projectorScreen = "no";
                        break;
                    case 14:
                        cb_tvMonitors = "no";
                        break;
                    case 15:
                        cb_piano = "no";
                        break;
                }
            }else{
                switch (i){
                    case 0:
                        cb_whiteboard = "yes";
                        break;
                    case 1:
                        cb_chalkBoard = "yes";
                        break;
                    case 2:
                        cb_computerLaptop = "yes";
                        break;
                    case 3:
                        cb_soundSystem = "yes";
                        break;
                    case 4:
                        cb_cd = "yes";
                        break;
                    case 5:
                        cb_dvd = "yes";
                        break;
                    case 6:
                        cb_dataVideoProjector = "yes";
                        break;
                    case 7:
                        cb_hearingAssisted = "yes";
                        break;
                    case 8:
                        cb_visualOptimizer = "yes";
                        break;
                    case 9:
                        cb_laptopConnectivity = "yes";
                        break;
                    case 10:
                        cb_networkConnection = "yes";
                        break;
                    case 11:
                        cb_overhearProjector = "yes";
                        break;
                    case 12:
                        cb_podium = "yes";
                        break;
                    case 13:
                        cb_projectorScreen = "yes";
                        break;
                    case 14:
                        cb_tvMonitors = "yes";
                        break;
                    case 15:
                        cb_piano = "yes";
                        break;
                }
            }
        }

       /* System.out.println(classroom_number + building + chairs + desks);
        System.out.println(cb_whiteboard + cb_chalkBoard + cb_computerLaptop + cb_soundSystem + cb_cd + cb_dvd + cb_dataVideoProjector +
               cb_hearingAssisted + cb_visualOptimizer + cb_laptopConnectivity + cb_networkConnection + cb_overhearProjector + cb_podium +
                cb_projectorScreen + cb_tvMonitors + cb_piano);
                */
        
        
        OIT_Dev.Classroom newClassroom = new OIT_Dev.Classroom(building, classroom_number, number_of_slots, 
        		chairs, cb_whiteboard, cb_chalkBoard, cb_computerLaptop, cb_soundSystem, cb_cd, cb_dvd, 
        		cb_dataVideoProjector, cb_hearingAssisted, cb_visualOptimizer, 
        		cb_laptopConnectivity, cb_networkConnection, cb_overhearProjector, cb_podium, 
        		cb_projectorScreen, cb_tvMonitors, cb_piano);
        
        Resource res = new Resource();
        List<OIT_Dev.Classroom> classroomList = res.roomList.getRoomList();
        
        classroomList.add(newClassroom);
        res.roomList.setRoomList(classroomList);
        
        try {
			response.sendRedirect("http://localhost:8080/ClassAllocation/exportCSV.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}
