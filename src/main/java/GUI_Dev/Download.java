package GUI_Dev;

import java.io.IOException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import OIT_Dev.Schedule;

public class Download extends HttpServlet {

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        
        String dir = request.getParameter("dir");
        
        Schedule sch = new Schedule();
        sch.exportFile(dir);
        
        try {
			response.sendRedirect("http://localhost:8080/ClassAllocation/index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

}
