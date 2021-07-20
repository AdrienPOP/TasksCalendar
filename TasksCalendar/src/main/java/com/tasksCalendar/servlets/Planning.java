package com.tasksCalendar.servlets;

import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import com.tasksCalendar.calend.Month;
import com.tasksCalendar.calend.Week;
import com.tasksCalendar.models.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class Planing
 */
@WebServlet("/Planning")
public class Planning extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static LocalDate date = LocalDate.now();
	private boolean createTask = false;

	public Planning() {

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getSession().getAttribute("id_user") != null
				&& (int) request.getSession().getAttribute("id_user") != 0) {
			System.out.println(request.getSession().getAttribute("id_user"));
			interlayer(request);
			getLocalDate(request);
			getDateWeek(request);
			ifCreateTask(request);
			getDateMonth(request);
			sessionVue(request);
			this.getServletContext().getRequestDispatcher("/jsps/planning.jsp").forward(request, response);
		} else {

			this.getServletContext().getRequestDispatcher("/jsps/home.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		createTask(request);
		doGet(request, response);
	}

	private void interlayer(HttpServletRequest request) {
		String planning = "/TasksCalendar/Planning";
		String uri = request.getRequestURI();
		request.setAttribute("planning", planning);
		request.setAttribute("uri", uri);
	}

	private void getLocalDate(HttpServletRequest request) {
		request.setAttribute("date", date);
	}

	private void getDateWeek(HttpServletRequest request) {
		String dateUser = request.getParameter("dateUser");
		LocalDate date;
		if (dateUser != null) {
			try {
				date = LocalDate.parse(dateUser);
			} catch (Exception e) {
				e.printStackTrace();
				date = LocalDate.now();
			}
		} else {
			date = LocalDate.now();
		}
		Week week = new Week(date, (int) request.getSession().getAttribute("id_user"));
		request.setAttribute("firstDateDay", (week.getFirstDay()));
		request.setAttribute("week", week);
		request.setAttribute("days", week.getDaysOfWeek());
	}

	private void getDateMonth(HttpServletRequest request) {
		String dateUser = request.getParameter("dateUser");
		LocalDate date;
		if (dateUser != null) {
			try {
				date = LocalDate.parse(dateUser);
			} catch (Exception e) {
				e.printStackTrace();
				date = LocalDate.now();
			}
		} else {
			date = LocalDate.now();
		}
		Month month = new Month(date);

		request.setAttribute("firstDateMonth", (month.getFirstDayMonth()));
		request.setAttribute("weeks", month.getWeeksOfMonth());
		request.setAttribute("month", month);
	}

	private void ifCreateTask(HttpServletRequest request) {
		if (request.getParameter("action") != null && request.getParameter("action").equals("createTask")) {
			createTask = true;
			request.setAttribute("createTask", createTask);
		}
	}

	private void createTask(HttpServletRequest request) {

		if (createTask) {

			int id_user = (int) request.getSession().getAttribute("id_user");
			Task task = new Task();
			task.setTitle(request.getParameter("name_task"));
			task.setDescription(request.getParameter("description_task"));
			task.setDateTask(Date.valueOf(request.getParameter("date_task")));
			task.setIdUser(id_user);
			task.insert();

			createTask = false;
		}
	}

	private void sessionVue(HttpServletRequest request) {

		HttpSession sessionView = request.getSession(true);
		if (sessionView.getAttribute("viewUser") == null && request.getParameter("view") == null) {
			sessionView.setAttribute("viewUser", "week");

		} else if (sessionView.getAttribute("viewUser") != null && request.getParameter("view") != null) {
			sessionView.setAttribute("viewUser", request.getParameter("view"));
		}
	}

}
