package com.tasksCalendar.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Parametre
 */
@WebServlet("/Parametre")
public class Parametre extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Parametre() {
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Parametre.interlayer(request);
		if(request.getSession().getAttribute("id_user") != null && (int) request.getSession().getAttribute("id_user")!= 0) {
			this.getServletContext().getRequestDispatcher("/jsps/parametre.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/jsps/home.jsp").forward(request, response);
		}
	}
	
	private static void interlayer(HttpServletRequest request) {
		String parametre = "/TasksCalendar/Parametre"; 
		String uri = request.getRequestURI();
		request.setAttribute("parametre", parametre);
		request.setAttribute("uri", uri);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
