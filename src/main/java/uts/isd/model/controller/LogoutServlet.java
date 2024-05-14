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

import uts.isd.model.dao.UserDAO;

public class LogoutServlet extends HttpServlet {

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

		String email = request.getParameter("email");
		String password = request.getParameter("password");
        response.setContentType("text/html;charset=UTF-8");

        try {
            int userID = userDAO.getUserID(email, password);
            userDAO.addlogslogout(userID); //add to accessLog
            request.getRequestDispatcher("logout.jsp").include(request,response);

        }catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}