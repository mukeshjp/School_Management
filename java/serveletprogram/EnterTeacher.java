package serveletprogram;

import java.io.IOException;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/jsp")
public class EnterTeacher extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	String name = req.getParameter("Name");
	String subject = req.getParameter("subject");
	String sal = req.getParameter("Salary");
	
	double sal1 = Double.parseDouble(sal);
	EntityManagerFactory emf = Persistence.createEntityManagerFactory("mukesh");
	EntityManager em = emf.createEntityManager();
	EntityTransaction et = em.getTransaction();
	
	Teacher t = new Teacher();
	t.setName(name);
	t.setSubject(subject);
	t.setSal(sal1);
	
	et.begin();
	em.persist(t);
	et.commit();
	RequestDispatcher rd = req.getRequestDispatcher("teachermenu.html");
	rd.include(req, resp);
	
	System.out.println("data saved successfully");
	
	
	
	
	
	
	
	
	}
	

}
