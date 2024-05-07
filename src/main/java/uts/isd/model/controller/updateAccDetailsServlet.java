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

public class updateAccDetailsServlet extends HttpServlet {

    @Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();

		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		String phone = request.getParameter("phone");
		response.setContentType("text/html;charset=UTF-8");

		UserDAO userDAO = (UserDAO) session.getAttribute("userDAO");

		//Check if inputted regsitration details are correctly inputted
		Validator validate = new Validator();
        session.setAttribute("inputtedNameErr", validate.validateEmail(email));
        session.setAttribute("inputtedNameErr", validate.validateName(name));
		session.setAttribute("inputtedPassErr", validate.validatePassword(password));
        session.setAttribute("inputtedPhoneErr", validate.validatePhone(phone));

		//if there are no errors and all validations return null then add use
		if((validate.validateEmail(email)==null) && (validate.validateName(name)==null) && (validate.validatePassword(password)==null) 
			&& (validate.validatePhone(phone)==null)){
			try { if(!userDAO.checkEmail(email)) {

				userDAO.updateUser(name, email, password, phone);
				session.setAttribute("update", "the update was successful");
				request.getRequestDispatcher("accountDetails.jsp").include(request, response);

				}else{
					session.setAttribute("emailUsed", "Email has already been used please use a different one!");
					request.getRequestDispatcher("updateAccDetails.jsp").include(request, response);
				}
			}catch (SQLException ex) {
				Logger.getLogger(updateAccDetailsServlet.class.getName()).log(Level.SEVERE, null, ex);
			}
		}else{
			request.getRequestDispatcher("updateAccDetails.jsp").include(request, response);
		}
	}
}




	// 	if (name.length() <= 5) {
	// 		session.setAttribute("nameErr", "The name provided was not long enough!");
	// 		request.getRequestDispatcher("register.jsp").include(request, response);
	// 	} else {
	// 		try {
	// 			userDAO.addUser(name, email, password, phone);

	// 			User user = new User();
	// 			user.setName(name);
	// 			user.setEmail(email);
	// 			user.setPassword(password);
	// 			user.setPhone(phone);
	// 			session.setAttribute("user", user);

	// 			request.getRequestDispatcher("welcome.jsp").include(request, response);
	// 		} catch (SQLException ex) {
    //        	Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
    //     	}
	// 	}
	// }



    




