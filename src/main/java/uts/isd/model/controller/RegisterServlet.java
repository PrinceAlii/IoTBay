package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;

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

		Validator validator = new Validator();
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phoneStr = request.getParameter("phone");
        int phone = Integer.parseInt(phoneStr);

		UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");
		validator.clear(session);

		if (!validator.validateEmail(email)){
            session.setAttribute("emailErr", "Error: Email format incorrect");
            request.getRequestDispatcher("register.jsp").include(request,response);
        } else if (!validator.validateName(name)) {
            session.setAttribute("nameErr", "Error: Name format incorrect");
            request.getRequestDispatcher("register.jsp").include(request,response);
        }else if (!validator.validatePassword(password)) {
            session.setAttribute("passErr", "Error: Password format incorrect");
            request.getRequestDispatcher("register.jsp").include(request,response);
        }else {
			// try {
			// 	User exist = userDAO.findUser(email, password);
			// 	if(exist != null){
			// 		session.setAttribute("existErr", "User already exists in the Database!");
            //         request.getRequestDispatcher("login.jsp").include(request,response);
			// 	}else {
			// 		userDAO.addUser(name, email, password, phone);
			// 		User user = new User();
			// 		session.setAttribute("user", user);
			// 		request.getRequestDispatcher("welcome.jsp").include(request, response);
			// 	}
			}catch (SQLException | NullPointerException ex) {
				System.out.println(ex.getMessage() == null ? "User does not exist" : "welcome");
			}
		}	
	} 
}  

    




