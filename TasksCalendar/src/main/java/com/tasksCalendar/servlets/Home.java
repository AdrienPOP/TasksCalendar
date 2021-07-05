package com.tasksCalendar.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet({ "/Home", "" })
public class Home extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private boolean create;

	public Home() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (request.getParameter("action") != null) {
			if (request.getParameter("action").equals("createAccount")) {
				create = true;
				request.setAttribute("create", create);
			} else if (request.getParameter("action").equals("signUp")) {
				create = false;
			}
		}

		this.getServletContext().getRequestDispatcher("/jsps/home.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
