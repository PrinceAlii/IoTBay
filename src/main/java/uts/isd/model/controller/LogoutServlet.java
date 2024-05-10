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
                userDAO.addlogslogout(userID);
                request.getRequestDispatcher("logout.jsp").include(request,response);
        }catch (SQLException ex) {
            Logger.getLogger(LogoutServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

        // if (!validator.validateEmail(email)){
        //     session.setAttribute("emailErr", "Error: Email format incorrect");
        //     request.getRequestDispatcher("login.jsp").include(request,response);
        // } else if (!validator.validatePassword(password)) {
        //     session.setAttribute("passErr", "Error: Password format incorrect");
        //     request.getRequestDispatcher("login.jsp").include(request,response);
        // } else {
        //     try {
        //         user = userDAO.findUser(email, password);
        //         if (user != null){
        //             session.setAttribute("user", user);
        //             request.getRequestDispatcher("welcome.jsp").include(request,response);
        //         } else {
        //             session.setAttribute("existErr", "User does not exist in the Database!");
        //             request.getRequestDispatcher("register.jsp").include(request,response);

        //         }
        //     } catch (SQLException | NullPointerException ex) {
		// 		System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
		// 	    }
        // }