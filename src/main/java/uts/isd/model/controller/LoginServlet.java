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

public class LoginServlet extends HttpServlet {

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

        UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
        response.setContentType("text/html;charset=UTF-8");

        try {
            // check if user login details for User exsists 
            if(userDAO.checkUser(email,password)){

                User user = userDAO.findUser(email, password);
                int userID = userDAO.getUserID(email, password);
                userDAO.addlogslogin(userID);
                
                session.setAttribute("user", user);
                request.getRequestDispatcher("welcome.jsp").include(request,response);
            }else{
                //else throws Incorrect Email or Password
                session.setAttribute("incorrectLogin", "Incorrect Email or Password");
                request.getRequestDispatcher("login.jsp").include(request, response);
            } 
        }catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
