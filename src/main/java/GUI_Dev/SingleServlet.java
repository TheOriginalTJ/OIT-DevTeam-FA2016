package GUI_Dev;
import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SingleServlet extends HttpServlet {
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String course_number = request.getParameter("course_number");
        String course_section = request.getParameter("course_section");
        String course_name = request.getParameter("course_name");
        String instructor = request.getParameter("instructor");
        String course_days = request.getParameter("course_days");
        String start_time = request.getParameter("start_time");
        String end_time = request.getParameter("end_time");
        String number_of_slots = request.getParameter("number_of_slots");
        String chairs = request.getParameter("chairs");

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
                        cb_whiteboard = "n";
                        break;
                    case 1:
                        cb_chalkBoard = "n";
                        break;
                    case 2:
                        cb_computerLaptop = "n";
                        break;
                    case 3:
                        cb_soundSystem = "n";
                        break;
                    case 4:
                        cb_cd = "n";
                        break;
                    case 5:
                        cb_dvd = "n";
                        break;
                    case 6:
                        cb_dataVideoProjector = "n";
                        break;
                    case 7:
                        cb_hearingAssisted = "n";
                        break;
                    case 8:
                        cb_visualOptimizer = "n";
                        break;
                    case 9:
                        cb_laptopConnectivity = "n";
                        break;
                    case 10:
                        cb_networkConnection = "n";
                        break;
                    case 11:
                        cb_overhearProjector = "n";
                        break;
                    case 12:
                        cb_podium = "n";
                        break;
                    case 13:
                        cb_projectorScreen = "n";
                        break;
                    case 14:
                        cb_tvMonitors = "n";
                        break;
                    case 15:
                        cb_piano = "n";
                        break;
                }
            }else{
                switch (i){
                    case 0:
                        cb_whiteboard = "y";
                        break;
                    case 1:
                        cb_chalkBoard = "y";
                        break;
                    case 2:
                        cb_computerLaptop = "y";
                        break;
                    case 3:
                        cb_soundSystem = "y";
                        break;
                    case 4:
                        cb_cd = "y";
                        break;
                    case 5:
                        cb_dvd = "y";
                        break;
                    case 6:
                        cb_dataVideoProjector = "y";
                        break;
                    case 7:
                        cb_hearingAssisted = "y";
                        break;
                    case 8:
                        cb_visualOptimizer = "y";
                        break;
                    case 9:
                        cb_laptopConnectivity = "y";
                        break;
                    case 10:
                        cb_networkConnection = "y";
                        break;
                    case 11:
                        cb_overhearProjector = "y";
                        break;
                    case 12:
                        cb_podium = "y";
                        break;
                    case 13:
                        cb_projectorScreen = "y";
                        break;
                    case 14:
                        cb_tvMonitors = "y";
                        break;
                    case 15:
                        cb_piano = "y";
                        break;
                }
            }
        }
        
        OIT_Dev.Class newClass = new OIT_Dev.Class(course_number, course_section, course_name, instructor, 
        		course_days, start_time, end_time, chairs, number_of_slots, cb_whiteboard, 
        		cb_chalkBoard, cb_computerLaptop, cb_soundSystem, cb_cd, cb_dvd, 
        		cb_dataVideoProjector, cb_hearingAssisted, cb_visualOptimizer, 
        		cb_laptopConnectivity, cb_networkConnection, cb_overhearProjector, cb_podium, 
        		cb_projectorScreen, cb_tvMonitors, cb_piano);
        
        Resource res = new Resource();
        List<OIT_Dev.Class> classList = res.classList.getClassList();
        
        classList.add(newClass);
        res.classList.setClassList(classList);
        
        try {
			response.sendRedirect("http://localhost:8080/ClassAllocation/recalculate.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
                
    }
}
