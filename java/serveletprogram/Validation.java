package serveletprogram;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/qsp")
public class Validation extends HttpServlet  {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String email = req.getParameter("Email");
		String pass = req.getParameter("Pass");
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mukesh");
		EntityManager em = emf.createEntityManager();
		
		
		
		Query q = em.createQuery("select p from Principal p where p.email=?1 and p.password=?2");
		
		q.setParameter(1,email);
		q.setParameter(2, pass);
		
		List<Principal> lp = q.getResultList();
		
		
			if(lp.size()>0)
			{
				RequestDispatcher rd = req.getRequestDispatcher("menu.html");
				rd.forward(req, resp);
			}
			else
			{
				PrintWriter pw = resp.getWriter();
				pw.write("Invalid email and Password");
				
				RequestDispatcher rd = req.getRequestDispatcher("Login.html");
				rd.include(req, resp);
				resp.setContentType("text/html");
			}
			
		
		
	
	}
	


}
