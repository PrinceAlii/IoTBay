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

import uts.isd.model.UserAccessLogs;
import uts.isd.model.User;
import uts.isd.model.dao.UserDAO;

public class accessLogServlet extends HttpServlet {

    @Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		response.setContentType("text/html;charset=UTF-8");
		UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
		request.removeAttribute("noLogsFound");

		User user = (User) session.getAttribute("user");
		int userID = user.getUserID();
		String searchLogAccessDate = request.getParameter("search");
		ArrayList<UserAccessLogs> logs = new ArrayList<UserAccessLogs>();
		
		try{
			if (searchLogAccessDate != null && !searchLogAccessDate.isEmpty()) {
				logs = userDAO.searchLogByDate(searchLogAccessDate,userID);
			}else{
				logs = userDAO.getAllLogs(userID);
			}if(!logs.isEmpty()){
				session.setAttribute("logs", logs);
				request.getRequestDispatcher("userAccessLogs.jsp").include(request, response);
			}else{
				logs = userDAO.getAllLogs(userID);
                session.setAttribute("noLogsFound", "No logs were found");
                request.getRequestDispatcher("userAccessLogs.jsp").include(request, response);
            } 
		} catch (SQLException ex) {
			Logger.getLogger(accessLogServlet.class.getName()).log(Level.SEVERE, null, ex);
		}	
	}
}








    




