package GUI_Dev;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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

        /*System.out.println(discipline);
        System.out.println(courseNumber);
        System.out.println(instructor);*/
        
        
        Resource res = new Resource();
        List<Class> classList = res.classList.getClassList();
        
        List<Class> filtered = new ArrayList<Class>();
        
        for(int i=0; i<classList.size(); i++){
        	if(!discipline.equals("") && discipline.equals(classList.get(i).getDisc())){
        		filtered.add(classList.get(i));
        	}
        	if(!courseNumber.equals("") && courseNumber.equals(classList.get(i).getDisc())){
        		filtered.add(classList.get(i));
        	}
        	if(!instructor.equals("") && instructor.equals(classList.get(i).getInstructorID())){
        		filtered.add(classList.get(i));
        	}
        }
        
        setFilteredList(filtered);
        
        /*for(int i=0; i<filtered.size(); i++){
        	System.out.println(filtered.get(i).getCourseName());
        }*/
    
    }

	public List<Class> getFilteredList() {
		return filteredList;
	}

	public void setFilteredList(List<Class> filteredList) {
		this.filteredList = filteredList;
	}
    
}
