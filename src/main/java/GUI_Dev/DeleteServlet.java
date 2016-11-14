package GUI_Dev;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DeleteServlet extends HttpServlet {

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String discipline = request.getParameter("discipline_delete");
        String courseNumber = request.getParameter("course_number_delete");
        String instructor = request.getParameter("instructor_delete");

        /*System.out.println(discipline);
        System.out.println(courseNumber);
        System.out.println(instructor);*/
    }
}
