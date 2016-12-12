package GUI_Dev;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Resource extends HttpServlet{
	public static ClassList classList = new ClassList();
	public static RoomList roomList = new RoomList();
	public static DeleteServlet filtered = new DeleteServlet();
	public static EditClassroomServlet filteredRoom = new EditClassroomServlet();
	
	
	protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);
        
        System.exit(0);
	}

	
}
