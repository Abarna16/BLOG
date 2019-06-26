import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class Display extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//ServletContext context=getServletContext();		
		resp.setContentType("text/html");		
		PrintWriter pw=resp.getWriter();
		req.getRequestDispatcher("Home.html").include(req, resp);  
		//String path= context.getInitParameter("Path");
		
		try {               
            JSONObject jo = (JSONObject)new JSONParser().parse(new FileReader("E://servlet.json")); 
            JSONArray ja=((JSONArray)jo.get("Details")); 
          pw.println(jo.toString());

        } catch (Exception ex) {
            System.out.println("Error Displaying the content");
        }  
	
	}

}

