package com.tasksCalendar.servlets;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.tasksCalendar.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Inscription")
public class Inscription extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public Inscription() {
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		User userCreate = new User();
		userCreate.setName(request.getParameter("name"));
		userCreate.setSurname(request.getParameter("firstname"));
		userCreate.setAdress(request.getParameter("adress"));
		userCreate.setPhone(request.getParameter("phone"));
		userCreate.setMail(request.getParameter("mail"));
		userCreate.setPseudo(request.getParameter("login"));
		userCreate.setPassword(request.getParameter("password"));	
		userCreate.insert();
		response.sendRedirect(request.getContextPath() + "/Home");
	}
	

}
