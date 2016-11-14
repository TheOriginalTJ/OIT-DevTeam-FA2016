package GUI_Dev;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class EditClassroomServlet  extends HttpServlet{
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String classroom_number = request.getParameter("classroom_number_edit");
        String building = request.getParameter("building_edit");

        //System.out.println(classroom_number+building);
    }
}
