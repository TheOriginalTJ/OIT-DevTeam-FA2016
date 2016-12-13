
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import java.net.*;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.jetty.jsp.JettyJspServlet;
import org.apache.commons.io.IOUtils;
import org.apache.tomcat.InstanceManager;
import org.apache.tomcat.SimpleInstanceManager;
import org.eclipse.jetty.annotations.ServletContainerInitializersStarter;
import org.eclipse.jetty.apache.jsp.JettyJasperInitializer;
import org.eclipse.jetty.plus.annotation.ContainerInitializer;
import org.eclipse.jetty.server.ConnectionFactory;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.ServerConnector;
import org.eclipse.jetty.servlet.DefaultServlet;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.webapp.WebAppContext;

import GUI_Dev.AddClassroomServlet;
import GUI_Dev.ClassList;
import GUI_Dev.DeleteServlet;
import GUI_Dev.Download;
import GUI_Dev.EditClassroomServlet;
import GUI_Dev.MultipleServlet;
import GUI_Dev.Resource;
import GUI_Dev.SingleServlet;
import GUI_Dev.editClass;
import GUI_Dev.editClassroom;
import OIT_Dev.Parser;


/**
 * This class contains the main method that will connect to the server.
 */

public class Main {
    // Resource path pointing to where the WEBROOT is.
    private static final String WEBROOT_INDEX = "/webroot/";

    public static void main(String[] args) {

    	Resource res = new Resource();
    	
    	File rooms = new File("resources/rooms.txt");
		if(!rooms.exists()) {
			System.out.println("resources/rooms.txt does not exist; unable to add room to file.");
			return;
		}
    	
    	/*ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream is = classloader.getResourceAsStream("webroot/rooms.txt");
        File rooms = new File("rooms.txt");
         
        try {
        	OutputStream output = new FileOutputStream(rooms);
 			IOUtils.copy(is, output);
 			output.close();
 		} catch (IOException e) {
 			// TODO Auto-generated catch block
 			e.printStackTrace();
 		}*/
         
    
         Parser roomParse = new Parser(rooms.getAbsolutePath());
         res.roomList.setRoomList(roomParse.parseClassroom());
    	
    	
            int port = 8080;
            String context_path = "/ClassAllocation";
            Main main = new Main(port,context_path);
            main.start();
            main.waitForInterrupt();

    }

    private int port;
    private Server server;
    private URI serverURI;
    private String context_path;

    public Main(final int port, final String context_path) {
        this.port = port;
        this.context_path = context_path;
    }

    public void start() {
        server = new Server();
        ServerConnector connector = connector();
        server.addConnector(connector);

        URI baseUri = getWebRootResourceUri();

        // Set JSP to use Standard JavaC always
        System.setProperty("org.apache.jasper.compiler.disablejsr199", "false");

        WebAppContext webAppContext = getWebAppContext(baseUri, getScratchDir());

        server.setHandler(webAppContext);

        // Start Server
        try {
            server.start();
        } catch (Exception e) {
            System.out.println("Exception while starting server: " + e);
        }

        this.serverURI = getServerUri(connector);
    }

    private ServerConnector connector() {
        ServerConnector connector = new ServerConnector(server);
        connector.setPort(port);
        return connector;
    }

    private URI getWebRootResourceUri() {
        URL indexUri = this.getClass().getResource(WEBROOT_INDEX);
        if (indexUri == null) {
            System.out.println("Unable to find resource " + WEBROOT_INDEX);
        }
        // Points to wherever /webroot/ (the resource) is
        try {
            return indexUri.toURI();
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Error: " + e);
            return null;
        }
    }

    /**
     * Establish Scratch directory for the servlet context (used by JSP compilation).
     */
    private File getScratchDir() {
        File tempDir = new File(System.getProperty("java.io.tmpdir"));
        File scratchDir = new File(tempDir.toString(), "embedded-jetty-jsp");

        if (!scratchDir.exists()) {
            if (!scratchDir.mkdirs()) {
                System.out.println("Unable to create scratch directory: " + scratchDir);
            }
        }
        return scratchDir;
    }

    /**
     * Setup the basic application "context" for this application at "/".
     * This is also known as the handler tree (in jetty speak).
     */
    private WebAppContext getWebAppContext(final URI baseUri, final File scratchDir) {
        WebAppContext context = new WebAppContext();
        context.setContextPath(context_path);
        context.setAttribute("javax.servlet.context.tempdir", scratchDir);
        context.setAttribute("org.eclipse.jetty.server.webapp.ContainerIncludeJarPattern",
                ".*/[^/]*servlet-api-[^/]*\\.jar$|.*/javax.servlet.jsp.jstl-.*\\.jar$|.*/.*taglibs.*\\.jar$");
        context.setResourceBase(baseUri.toASCIIString());
        context.setAttribute("org.eclipse.jetty.containerInitializers", jspInitializers());
        context.setAttribute(InstanceManager.class.getName(), new SimpleInstanceManager());
        context.addBean(new ServletContainerInitializersStarter(context), true);
        context.setClassLoader(getUrlClassLoader());

        context.addServlet(jspServletHolder(), "*.jsp");
        context.addServlet(defaultServletHolder(baseUri), context_path);
        context.addServlet(MultipleServlet.class, "/multiple");
        context.addServlet(DeleteServlet.class, "/delete");
        context.addServlet(editClass.class, "/editClass");
        context.addServlet(editClassroom.class, "/edit");
        context.addServlet(AddClassroomServlet.class, "/addClassroom");
        context.addServlet(EditClassroomServlet.class, "/editClassroom");
        context.addServlet(SingleServlet.class, "/single");
        context.addServlet(Download.class, "/download");
        context.addServlet(Resource.class, "/exit");

        context.addServlet(defaultServletHolder(baseUri), "/");
        return context;
    }

    /**
     * Ensure the jsp engine is initialized correctly.
     */
    private List<ContainerInitializer> jspInitializers() {
        JettyJasperInitializer sci = new JettyJasperInitializer();
        ContainerInitializer initializer = new ContainerInitializer(sci, null);
        List<ContainerInitializer> initializers = new ArrayList<ContainerInitializer>();
        initializers.add(initializer);
        return initializers;
    }

    /**
     * Set Classloader of Context to be sane (needed for JSTL).
     * JSP requires a non-System classloader, this simply wraps the
     * embedded System classloader in a way that makes it suitable
     * for JSP to use.
     */
    private ClassLoader getUrlClassLoader() {
        ClassLoader jspClassLoader = new URLClassLoader(new URL[0], this.getClass().getClassLoader());
        return jspClassLoader;
    }

    /**
     * Create JSP Servlet (must be named "jsp").
     */
    private ServletHolder jspServletHolder() {
        ServletHolder holderJsp = new ServletHolder("jsp", JettyJspServlet.class);
        holderJsp.setInitOrder(0);
        holderJsp.setInitParameter("logVerbosityLevel", "DEBUG");
        holderJsp.setInitParameter("fork", "false");
        holderJsp.setInitParameter("xpoweredBy", "false");
        holderJsp.setInitParameter("compilerTargetVM", "1.7");
        holderJsp.setInitParameter("compilerSourceVM", "1.7");
        holderJsp.setInitParameter("keepgenerated", "true");
        return holderJsp;
    }

    /**
     * Create Default Servlet (must be named "default").
     */
    private ServletHolder defaultServletHolder(final URI baseUri) {
        ServletHolder holderDefault = new ServletHolder("default", DefaultServlet.class);
        holderDefault.setInitParameter("resourceBase", baseUri.toASCIIString());
        holderDefault.setInitParameter("dirAllowed", "true");
        return holderDefault;
    }

    /**
     * Establish the Server URI.
     */
    private URI getServerUri(final ServerConnector connector) {
        String scheme = "http";
        for (ConnectionFactory connectFactory : connector.getConnectionFactories()) {
            if (connectFactory.getProtocol().equals("SSL-http")) {
                scheme = "https";
            }
        }
        String host = connector.getHost();
        if (host == null) {
            host = "localhost";
        }
        int port = connector.getLocalPort();
        try {
            serverURI = new URI(String.format("%s://%s:%d/", scheme, host, port));
        } catch (URISyntaxException e) {
            System.out.println("URI Syntax Exception: " + e);
        }
        return serverURI;
    }

    /**
     * Cause server to keep running until it receives a Interrupt.
     * <p>
     * Interrupt Signal, or SIGINT (Unix Signal), is typically seen as a result of a kill -TERM {pid} or Ctrl+C
     */
    public void waitForInterrupt() {
        try {
            server.join();
        } catch (InterruptedException e) {
            System.out.println("Interrupted signal: " + e);
        }
    }
}
