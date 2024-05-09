package uts.isd.model.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.dao.DBConnector;
import uts.isd.model.dao.UserDAO;

public class ConnServlet extends HttpServlet {
    
    private DBConnector db;
	private UserDAO userDAO;
	private Connection conn;

    @Override 
	public void init() {
		try {
			db = new DBConnector(); 
		} catch (ClassNotFoundException | SQLException ex) {
			Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null,ex);
		}
	}

    @Override 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		response.setContentType("text/html;charset=UTF-8");
		HttpSession session = request.getSession();
		conn = db.openConnection(); 

		try {
			userDAO = new UserDAO(conn);  
		} catch (SQLException ex) {
			Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null,ex);
		}

        //export the UserDAO to the view session (JSPs)
		session.setAttribute("userDAO", userDAO); // add the user DAO to the session
	}

    @Override 
	public void destroy() {
		try {
			db.closeConnection(); 
		} catch (SQLException ex) {
			Logger.getLogger(ConnServlet.class.getName()).log(Level.SEVERE, null,ex);
		}
	}
}