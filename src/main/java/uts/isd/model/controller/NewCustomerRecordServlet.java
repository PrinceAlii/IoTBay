package uts.isd.model.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import org.apache.commons.dbcp2.BasicDataSource;
import uts.isd.model.dao.SystemAdminDAO;

public class NewCustomerRecordServlet extends HttpServlet {
    private DataSource dataSource;

    @Override
    public void init() throws ServletException {
        try {
            BasicDataSource basicDataSource = new BasicDataSource();
            basicDataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
            basicDataSource.setUrl("jdbc:mysql://localhost:3306/your_database_name");
            basicDataSource.setUsername("your_username");
            basicDataSource.setPassword("your_password");
            dataSource = basicDataSource;
        } catch (Exception e) {
            throw new ServletException("Error initializing data source", e);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try (Connection connection = dataSource.getConnection()) {
            SystemAdminDAO systemAdminDAO = new SystemAdminDAO(connection);

            // Retrieve customer information from the request
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String password = request.getParameter("password");
            String userType = request.getParameter("userType");
            String userAccount = request.getParameter("userAccount");

            // Add the new customer record
            systemAdminDAO.addUser(name, email, password, phone, userType, userAccount);

            request.setAttribute("message", "Customer record created successfully");
        } catch (SQLException e) {
            request.setAttribute("message", "Error creating customer record: " + e.getMessage());
        }

        // Forward the request to the JSP page
        request.getRequestDispatcher("CreateCustomerRecord.jsp").forward(request, response);
    }

    @Override
    public void destroy() {
        if (dataSource instanceof BasicDataSource) {
            try {
                ((BasicDataSource) dataSource).close();
            } catch (SQLException e) {
                // Log or handle the exception
            }
        }
    }
}

