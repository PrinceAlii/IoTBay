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

public class DeleteServlet extends HttpServlet {

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		User user = (User) session.getAttribute("user");
		int userID = user.getUserID();

		try{
			String email = request.getParameter("email");
			UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
			userDAO.deleteAllLogs(userID);
			userDAO.deleteUser(email);
			request.getRequestDispatcher("logout.jsp").include(request, response);
		} catch (SQLException ex) {
			Logger.getLogger(DeleteServlet.class.getName()).log(Level.SEVERE, null, ex);
		}	
	}
}








    




