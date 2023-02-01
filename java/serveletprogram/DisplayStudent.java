package serveletprogram;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/vs")
public class DisplayStudent extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mukesh");
		EntityManager em = emf.createEntityManager();
		
		String id = req.getParameter("Id");
		
		int id1 = Integer.parseInt(id);
		
		Student s = em.find(Student.class, id1);
		
		HttpSession hs = req.getSession();
		
		hs.setAttribute("studentlist", s);
		RequestDispatcher rd = req.getRequestDispatcher("studentfetch.jsp");
		rd.forward(req, resp);
	}

}
