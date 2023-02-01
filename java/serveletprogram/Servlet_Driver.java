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


@WebServlet("/rgstr")
public class Servlet_Driver extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name = req.getParameter("Name");
		String email = req.getParameter("Email");
		String mob = req.getParameter("Mobile");
		String age = req.getParameter("Age");
		String pass = req.getParameter("Pass");
		
		
		int age1 = Integer.parseInt(age);
		long mob1 = Long.parseLong(mob);
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("mukesh");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Principal p = new Principal();
		p.setName(name);
		p.setEmail(email);
		p.setAge(age1);
		p.setPassword(pass);
		p.setMobile_no(mob1);
		
		et.begin();
		em.persist(p);
		et.commit();
		
		System.out.println("Registration Successful....!!!");
		
		RequestDispatcher rd = req.getRequestDispatcher("Login.html");
		rd.forward(req, resp);
	}
	
	

}
