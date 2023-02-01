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
@WebServlet("/lpa")
public class Teacher_Update extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	    String id= req.getParameter("Id");
		String name=req.getParameter("Name");
		String subject = req.getParameter("Subject");
		String salary = req.getParameter("Salary");
		
		int id1 = Integer.parseInt(id);
		double salary1 = Double.parseDouble(salary);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mukesh");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Teacher t1 = new Teacher();
	    t1.setId(id1);
		t1.setName(name);
		t1.setSubject(subject);
	    t1.setSal(salary1);
		
		et.begin();
		em.merge(t1);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("teachermenu.html");
		rd.include(req, resp);
		
		
		System.out.println("Teacher details updated successfully...!!!");
		
		
		
		
	}
	
	

}
