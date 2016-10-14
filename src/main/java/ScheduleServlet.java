import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ScheduleServlet extends HttpServlet {
    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);

        String file_name = null;
        FileItem fileItem;
        InputStream fileInputStream = null;

        //get all parameters from the form
        try {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            String inputName;
            for (FileItem item : multiparts) {
                //gets file item from form
                if (!item.isFormField()) {
                    file_name = new File(item.getName()).getName();
                    fileItem = item;
                    try {
                        fileInputStream = fileItem.getInputStream();
                    } catch (IOException e) {
                        System.out.println("Exception while getting file item from form: " + e);
                    }
                }
            }
        } catch (FileUploadException e) {
            System.out.println("Exception while uploading file: " + e);
        }


        System.out.println(file_name);
    }
}