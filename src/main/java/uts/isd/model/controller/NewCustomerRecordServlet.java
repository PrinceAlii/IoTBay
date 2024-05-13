// NewCustomerRecordServlet.java

package uts.isd.model.controller;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import uts.isd.model.dao.SystemAdminDAO;
import uts.isd.model.dao.DBConnector;

public class NewCustomerRecordServlet extends HttpServlet {
    private SystemAdminDAO systemAdminDAO;

    @Override
    public void init() throws ServletException {
        systemAdminDAO = new SystemAdminDAO(DBConnector.getConnection());
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
        request.getRequestDispatcher("createCustomerRecord.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        systemAdminDAO.close();
    }
}
