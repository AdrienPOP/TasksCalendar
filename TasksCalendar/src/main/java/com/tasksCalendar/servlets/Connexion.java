package com.tasksCalendar.servlets;

import java.io.IOException;

import org.mindrot.jbcrypt.BCrypt;

import com.tasksCalendar.models.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Connexion")
public class Connexion extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Connexion() {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession sessionUser = request.getSession(true);
		String password = request.getParameter("password");
		sessionUser.setAttribute("id_user", 0);
		User userLogin = new User();
		userLogin.setPseudo(request.getParameter("login"));
		if (userLogin.selectByPseudo()) {
			if (BCrypt.checkpw(password, userLogin.getPassword())) {
				userLogin.selectByPseudoFull();
				sessionUser.setAttribute("id_user", userLogin.getId());
				sessionUser.setAttribute("name", userLogin.getName());
				response.sendRedirect(request.getContextPath() + "/Accueil");
				return;
			} else {
				response.sendRedirect(request.getContextPath() + "/Home");
				return;
			}
		}
	}
}
