package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.User;
import uts.isd.model.dao.UserDAO;

public class accessLogServlet extends HttpServlet {

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

		User user = (User) session.getAttribute("user");
		String email = user.getEmail();
        String password = user.getPassword();

		try{
			int userID = userDAO.getUserID(email,password);
			ArrayList logs = userDAO.getStatusLogs(userID);
			ArrayList tlogs = userDAO.getTimeLogs(userID);
			session.setAttribute("logs", logs);
            session.setAttribute("tlogs", tlogs);
			request.getRequestDispatcher("userAccessLogs.jsp").include(request, response);
		} catch (SQLException ex) {
			Logger.getLogger(accessLogServlet.class.getName()).log(Level.SEVERE, null, ex);
		}	
	}
}








    




