package GUI_Dev;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OIT_Dev.Class;

public class DeleteServlet extends HttpServlet {
	
	private List<Class> filteredList;

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String discipline = request.getParameter("discipline_delete");
        String courseNumber = request.getParameter("course_number_delete");
        String instructor = request.getParameter("instructor_delete");
        
        Resource res = new Resource();
        List<Class> classList = res.classList.getClassList();
        
        List<Class> filtered = new ArrayList<Class>();
        
        for(int i=0; i<classList.size(); i++){
        	boolean add = true;
        	if(!discipline.equals("") && !classList.get(i).getClassnum().contains(discipline)){
        		add=false;
        	}
        	if(!courseNumber.equals("") && !classList.get(i).getClassnum().contains(courseNumber)){
        		add=false;
        	}
        	if(!instructor.equals("") && !instructor.equals(classList.get(i).getInstructorID())){
        		add=false;
        	}
        	if(discipline.equals("") && courseNumber.equals("") && instructor.equals("")){
        		add=false;
        	}
        	
        	if(add){
        		filtered.add(classList.get(i));
        	}
        }
        
        res.filtered.setFilteredList(filtered);
        //setFilteredList(filtered);    
        
        
        try {
			response.sendRedirect("http://localhost:8080/ClassAllocation/result.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	public List<Class> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Class> filteredList) {
		this.filteredList = filteredList;
	}
    
}
