package uts.isd.model.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import uts.isd.model.User;
import uts.isd.model.dao.SystemAdminDAO;
import uts.isd.model.dao.DBConnector;

public class ViewUsersServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Connection conn = (Connection) session.getAttribute("conn");

        try {
            SystemAdminDAO dao = new SystemAdminDAO(conn);

            // Retrieve the search parameters
            String name = request.getParameter("name");
            String userType = request.getParameter("userType");

            // Fetch the users based on the search parameters
            ArrayList<User> users = dao.fetchUsers();

            // Set the users list as a request attribute
            request.setAttribute("users", users);

            // Forward the request to the ViewUsers.jsp
            request.getRequestDispatcher("ViewUsers.jsp").forward(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(ViewUsersServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
