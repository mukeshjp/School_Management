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
@WebServlet("/usd")
public class Student_Update extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String id = req.getParameter("Id");
		String name= req.getParameter("Name");
		String stream = req.getParameter("Stream");
		String fees = req.getParameter("Fees");
		
		int id1 = Integer.parseInt(id);
		double fees1 = Double.parseDouble(fees);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mukesh");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setId(id1);
		s1.setName(name);
		s1.setStream(stream);
		s1.setFees(fees1);
		
		et.begin();
		em.merge(s1);
		et.commit();
		
		RequestDispatcher rd = req.getRequestDispatcher("studentmenu.html");
		rd.forward(req, resp);
		
		System.out.println("Student Details updated successfully");
	}

}
