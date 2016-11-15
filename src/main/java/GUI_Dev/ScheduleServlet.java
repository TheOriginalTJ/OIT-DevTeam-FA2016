package GUI_Dev;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import OIT_Dev.Parser;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

        File file = new File(file_name);
        
        try {
        	OutputStream outputStream = new FileOutputStream(file);
			IOUtils.copy(fileInputStream, outputStream);
			outputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        /*System.out.println(file.getAbsolutePath());
        System.out.println(file.length());*/
        
        Parser parse = new Parser(file.getAbsolutePath());
        ClassList cl = new GUI_Dev.ClassList();
        cl.setClassList(parse.parseClass());
        
    }
}
