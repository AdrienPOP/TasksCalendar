package com.tasksCalendar.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tasksCalendar.calend.Day;
import com.tasksCalendar.models.Task;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/DatasDay")
public class DatasDay extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public DatasDay() {
		// TODO Auto-generated constructor stub
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		if (request.getParameter("data") != null) {
			deleteTask(request);
			Day d = new Day(LocalDate.parse(request.getParameter("data")),
					(int) request.getSession().getAttribute("id_user"));
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.writeValue(response.getWriter(), d);

		}

		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/json");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	private void deleteTask(HttpServletRequest request) {

		if (request.getParameter("action") != null) {
			if (request.getParameter("action").equals("delete")) {
				Task t = new Task();
				t.setId(Integer.valueOf(request.getParameter("id")));
				t.setIdUser((int) request.getSession().getAttribute("id_user"));
				t.delete();

			}
		}
	}

}
