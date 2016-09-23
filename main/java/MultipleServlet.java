import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MultipleServlet extends HttpServlet {

    protected void doGet(final HttpServletRequest request, final HttpServletResponse response) {

        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);


        String file_name;
        FileItem fileItem;
        InputStream fileInputStream;

        try {
            List<FileItem> multiparts = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
            String inputName;
            for (FileItem item : multiparts) {
                //gets file item from form
                if (!item.isFormField()) {
                    file_name = new File(item.getName()).getName();
                    fileItem = item;

                    System.out.println(file_name);
                    try {
                        fileInputStream = fileItem.getInputStream();
                    } catch (IOException e) {
                        System.out.println("Bad");
                    }
                }
            }
        } catch (FileUploadException e) {
            System.out.println("bad");
        }

    }
}
