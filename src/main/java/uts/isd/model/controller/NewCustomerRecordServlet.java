package uts.isd.model.controller;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import uts.isd.model.dao.SystemAdminDAO;

public class NewCustomerRecordServlet extends HttpServlet {
    private SystemAdminDAO systemAdminDAO;

    @Override
    public void init() throws ServletException {
        systemAdminDAO = new SystemAdminDAO((Connection) getServletContext().getAttribute("connection"));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve customer information from the request
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String phone = request.getParameter("phone");
        String password = request.getParameter("password");
        String userType = request.getParameter("userType");
        String userAccount = request.getParameter("userAccount");

        // Add the new customer record
        try {
            systemAdminDAO.addUser(name, email, password, phone, userType, userAccount);
            request.setAttribute("message", "Customer record created successfully");
        } catch (SQLException e) {
            request.setAttribute("message", "Error creating customer record: " + e.getMessage());
        }

        // Forward the request to the JSP page
        RequestDispatcher dispatcher = request.getRequestDispatcher("createCustomerRecord.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    public void destroy() {
        try {
            systemAdminDAO.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
}
