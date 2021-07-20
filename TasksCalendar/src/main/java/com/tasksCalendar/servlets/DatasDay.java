package com.tasksCalendar.servlets;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.tasksCalendar.calend.Day;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DatasDay extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public DatasDay() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("data")!= null) {
			
			
			Day d = new Day(LocalDate.parse(request.getParameter("data")), (int) request.getSession().getAttribute("id_user"));
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.registerModule(new JavaTimeModule());
			mapper.writeValue(response.getWriter(), d);
			
			response.setCharacterEncoding("UTF-8");
			response.setContentType("text/json");
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
