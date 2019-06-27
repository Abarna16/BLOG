import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
public class DisplayAsXML extends  HttpServlet{

	public void doPost(HttpServletRequest req,HttpServletResponse res) throws IOException,ServletException
	{
		res.setContentType("text/xml");
		PrintWriter object1=res.getWriter();
		StringBuffer object=new StringBuffer();
		object.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
		object.append("<Login_Details>");
		String name=req.getParameter("name");
		object.append("<User_Name>").append(name).append("</User_Name>");
		object.append("<password>").append(req.getParameter("password")).append("</password>");
		object.append("</Login_Details>");
		object1.write(object.toString());
	}
	  
	}  

