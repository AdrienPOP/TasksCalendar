package com.tasksCalendar.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import com.tasksCalendar.calend.Day;
import com.tasksCalendar.models.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Accueil")
public class Accueil extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Accueil() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Accueil.interlayer(request);

		if (request.getSession().getAttribute("id_user") != null
				&& (int) request.getSession().getAttribute("id_user") != 0) {
			
			request.setAttribute("day", new Day(LocalDate.now(), (int) request.getSession().getAttribute("id_user")));
//			request.setAttribute("dataTasks", Task.selectTaskUserByDay(
//					(int) request.getSession().getAttribute("id_user"), Date.valueOf(LocalDate.now())));
			this.getServletContext().getRequestDispatcher("/jsps/accueil.jsp").forward(request, response);
		} else {
			this.getServletContext().getRequestDispatcher("/jsps/home.jsp").forward(request, response);
		}
	}

	private static void interlayer(HttpServletRequest request) {
		String accueil = "/TasksCalendar/Accueil";
		String uri = request.getRequestURI();
		request.setAttribute("accueil", accueil);
		request.setAttribute("uri", uri);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
