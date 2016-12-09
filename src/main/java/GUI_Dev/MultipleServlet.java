package GUI_Dev;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import OIT_Dev.Class;
import OIT_Dev.Classroom;
import OIT_Dev.Parser;
import OIT_Dev.Population;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

public class MultipleServlet extends HttpServlet {

    protected void doPost(final HttpServletRequest request, final HttpServletResponse response) {
        response.setContentType("text/html");
        response.setStatus(HttpServletResponse.SC_OK);


        String file_name = null;
        FileItem fileItem=null;
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
        
        Parser parse = new Parser(file.getAbsolutePath());
        Resource res = new Resource();
        res.classList.setClassList(parse.parseClass());
        
      
        //call methods
        Population testPop = new Population(10, true);
        testPop.evolve(100, testPop);
       
        try {
			response.sendRedirect("http://localhost:8080/ClassAllocation/multipleResult.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
}