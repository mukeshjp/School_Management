package serveletprogram;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
@WebServlet("/logfghjk")
public class ServletDemo3 extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=req.getParameter("name");
		String email=req.getParameter("email");
		String mobile=req.getParameter("mobileno");
		String date=req.getParameter("date of birth");
		String pass=req.getParameter("password");
		
		PrintWriter pw=res.getWriter();
		
		pw.write("Welcome to Servlet world");
	
		
	}
	

}
