package uts.isd.model.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import uts.isd.model.User;
import uts.isd.model.dao.SystemAdminDAO;

public class ViewUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection conn = (Connection) session.getAttribute("conn");

        SystemAdminDAO dao = new SystemAdminDAO(conn);

        try {
            // Fetch the users
            ArrayList<User> users = dao.fetchUsers();

            // Set the users list as a request attribute
            request.setAttribute("users", users);

            // Forward the request to the ViewUsers.jsp
            request.getRequestDispatcher("ViewUsers.jsp").forward(request, response);
        } catch (SQLException e) {
            // Handle the SQLException here
            System.err.println("An error occurred while fetching users: " + e.getMessage());
            // You can also display a user-friendly message to the user on the JSP
            // by setting a request attribute here
        }
    }
}
