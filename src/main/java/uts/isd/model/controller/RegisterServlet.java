package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.User;
import uts.isd.model.dao.UserDAO;

public class RegisterServlet extends HttpServlet {

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phoneStr = request.getParameter("phone");
        int phone = Integer.parseInt(phoneStr);
		response.setContentType("text/html;charset=UTF-8");

		UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");


		if (name.length() <= 5) {
			session.setAttribute("nameErr", "The name provided was not long enough!");
			request.getRequestDispatcher("register.jsp").include(request, response);
		} else {
			try {
				userDAO.addUser(name, email, password, phone);

				User user = new User();
				user.setName(name);
				user.setEmail(email);
				user.setPassword(password);
				user.setPhone(phone);
				session.setAttribute("user", user);

				request.getRequestDispatcher("welcome.jsp").include(request, response);
			} catch (SQLException ex) {
           	Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        	}
		}
	}
}


    




