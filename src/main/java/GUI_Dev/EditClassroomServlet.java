package GUI_Dev;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OIT_Dev.Classroom;

public class EditClassroomServlet  extends HttpServlet{
	
	private List<Classroom> filteredList;
	
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String classroom_number = request.getParameter("classroom_number_edit");
        String building = request.getParameter("building_edit");
        
        Resource res = new Resource();
        List<Classroom> roomList = res.roomList.getRoomList();
        
        List<Classroom> filtered = new ArrayList<Classroom>();
        
        for(int i=0; i<roomList.size(); i++){
        	boolean add = true;
        	if(!classroom_number.equals("") && !roomList.get(i).getRoomnum().contains(classroom_number)){
        		add=false;
        	}
        	if(!building.equals("") && !roomList.get(i).getBuilding().contains(building)){
        		add=false;
        	}
        	if(classroom_number.equals("") && building.equals("")){
        		add=false;
        	}
        	
        	if(add){
        		filtered.add(roomList.get(i));
        	}
        }
        
        res.filteredRoom.setFilteredList(filtered);
        //setFilteredList(filtered);    
        
        
        try {
			response.sendRedirect("http://localhost:8080/ClassAllocation/classroom.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public List<Classroom> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Classroom> filteredList) {
		this.filteredList = filteredList;
	}
    
}
