package com.tasksCalendar.servlets;

import java.io.IOException;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


public class Customer extends HttpServlet {
	private static final long serialVersionUID = 1L;


    public Customer() {
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		interlayer(request);
		this.getServletContext().getRequestDispatcher("/jsps/customer.jsp").forward(request, response);
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void interlayer(HttpServletRequest request) {
		String client = "/TasksCalendar/Customer";
		String uri = request.getRequestURI();
		request.setAttribute("client", client);
		request.setAttribute("uri", uri);
	}

}
