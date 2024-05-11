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
		String phone = request.getParameter("phone");
		response.setContentType("text/html;charset=UTF-8");

		UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");


		Validator validate = new Validator();
        session.setAttribute("emailUsed", validate.validateEmail(email));
        session.setAttribute("inputtedNameErr", validate.validateName(name));
		session.setAttribute("inputtedPassErr", validate.validatePassword(password));
        session.setAttribute("inputtedPhoneErr", validate.validatePhone(phone));


		if((validate.validateEmail(email)==null) && (validate.validateName(name)==null) && (validate.validatePassword(password)==null) 
			&& (validate.validatePhone(phone)==null)){
			try {
				if(!userDAO.checkEmail(email)) {
					userDAO.addUser(name, email, password, phone);

					User user = new User();
					user.setName(name);
					user.setEmail(email);
					user.setPassword(password);
					user.setPhone(phone);
					session.setAttribute("user", user);
	
					request.getRequestDispatcher("welcome.jsp").include(request, response);
				} else{
					session.setAttribute("emailUsed", "Email has already been used please sign in");
					request.getRequestDispatcher("register.jsp").include(request, response);
				}
			}catch (SQLException ex) {
				    Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
		} else{
			request.getRequestDispatcher("register.jsp").include(request, response);
		}
	}
}







    




